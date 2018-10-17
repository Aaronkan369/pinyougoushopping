 
 app.controller('brandController',function($scope,$http,$controller,brandService){
        	  
        	     //伪继承,可以实现继承的效果
        	  $controller('baseController',{$scope:$scope});//继承
        	    
        	     //查询全部
	     	     $scope.finadAll = function(){
        	    	
     	    	       brandService.finAll().success(
        	    		  
	            	    	  function(response){
	            	    		    $scope.list =response;
	            	    		    //console.log($scope.list);
	            	    	  }	  
            	      );
	     	     };
        	    
	     	     
	     	    //分页查询
       	        $scope.findPage = function(page,rows){
	     	    	
       	        	  brandService.findPage(page,rows).success(
           	    	         function(response){
            	    	    	   //response PageResult对象
            	    	    	   $scope.list=response.rows;	
            	    	    	   $scope.paginationConf.totalItems=response.total;//更新总记录数
            	    	       }		
              	      );
       	         };
	       	      
	       	      
        	      //entity的结构 {speciation:{},pecificationOptionList:[]}
        	      $scope.save=function(){
        	    	 
        	    	  if($scope.entity.id==null){
        	    		  
        	    		  brandService.add($scope.entity).success(
                	    		  function(response){
                	    			   console.log(response);
                	    			    if(response.success){
                	    			    	  
                	    			    	 //重新进行分页查询
                	    			    	 $scope.reloadList();//重新加载
                	    			    }else{
                	    			    	 alert(response.message);
                	    			    }
                	    		  }	  
                	    	  );
        	    	  }else{
        	    		  //console.log($scope.entity);
        	    		  brandService.update($scope.entity).success(
        	    				  
                	    		  function(response){
                	    			   // console.log(response);
                	    			    if(response.success){
                	    			    	  
                	    			    	 //重新进行分页查询
                	    			    	 $scope.reloadList();//重新加载s
                	    			    }else{
                	    			    	 alert(response.message);
                	    			    }
                	    		  }	  
                	    	  );
        	    	  }
        	    	  
        	      };
        	      
        	      $scope.findOne=function(id){
        	    	  brandService.findOne().success(
        	    			function(response){
        	    				$scope.entity = response;
        	    		      
        	    	   });
        	      };
        	      
        	     
        	      //删除操作
        	      $scope.dele = function(){
        	  
        	    	  brandService.dele($scope.selectIds).success(
        	                function(response){
        	                	 // console.log(response);
        	    			    if(response.success){
        	    			    	  
        	    			    	 //重新进行分页查询
        	    			    	 $scope.reloadList();//重新加载
        	    			    	 
        	    			    }else{
        	    			    	
        	    			    	 alert(response.message);
        	    			    }
        	                }		
        	            ); 
                   };
                   
                   
          	       $scope.searchEntity={};//定义搜索对象
          	     
          	        //条件查询 
          	        $scope.search = function(){
	          	    	//console.log($scope.paginationConf.currentPage);
	          	    	//console.log($scope.paginationConf.itemsPerPage);
	          	    	//console.log($scope.searchEntity);
	          	     	brandService.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.searchEntity).success(
	          	     		function(response){
	         	     				$scope.paginationConf.totalItems=response.total;//总记录数 
	         	     				$scope.list=response.rows;//给列表变量赋值 
	          	     		}		
	          	     	);				
          	     };
        	      
          });
          