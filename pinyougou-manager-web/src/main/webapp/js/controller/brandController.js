 
 app.controller('brandController',function($scope,$http,$controller,brandService){
        	  
        	     //α�̳�,����ʵ�ּ̳е�Ч��
        	  $controller('baseController',{$scope:$scope});//�̳�
        	    
        	     //��ѯȫ��
	     	     $scope.finadAll = function(){
        	    	
     	    	       brandService.finAll().success(
        	    		  
	            	    	  function(response){
	            	    		    $scope.list =response;
	            	    		    //console.log($scope.list);
	            	    	  }	  
            	      );
	     	     };
        	    
	     	     
	     	    //��ҳ��ѯ
       	        $scope.findPage = function(page,rows){
	     	    	
       	        	  brandService.findPage(page,rows).success(
           	    	         function(response){
            	    	    	   //response PageResult����
            	    	    	   $scope.list=response.rows;	
            	    	    	   $scope.paginationConf.totalItems=response.total;//�����ܼ�¼��
            	    	       }		
              	      );
       	         };
	       	      
	       	      
        	      //entity�Ľṹ {speciation:{},pecificationOptionList:[]}
        	      $scope.save=function(){
        	    	 
        	    	  if($scope.entity.id==null){
        	    		  
        	    		  brandService.add($scope.entity).success(
                	    		  function(response){
                	    			   console.log(response);
                	    			    if(response.success){
                	    			    	  
                	    			    	 //���½��з�ҳ��ѯ
                	    			    	 $scope.reloadList();//���¼���
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
                	    			    	  
                	    			    	 //���½��з�ҳ��ѯ
                	    			    	 $scope.reloadList();//���¼���s
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
        	      
        	     
        	      //ɾ������
        	      $scope.dele = function(){
        	  
        	    	  brandService.dele($scope.selectIds).success(
        	                function(response){
        	                	 // console.log(response);
        	    			    if(response.success){
        	    			    	  
        	    			    	 //���½��з�ҳ��ѯ
        	    			    	 $scope.reloadList();//���¼���
        	    			    	 
        	    			    }else{
        	    			    	
        	    			    	 alert(response.message);
        	    			    }
        	                }		
        	            ); 
                   };
                   
                   
          	       $scope.searchEntity={};//������������
          	     
          	        //������ѯ 
          	        $scope.search = function(){
	          	    	//console.log($scope.paginationConf.currentPage);
	          	    	//console.log($scope.paginationConf.itemsPerPage);
	          	    	//console.log($scope.searchEntity);
	          	     	brandService.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage,$scope.searchEntity).success(
	          	     		function(response){
	         	     				$scope.paginationConf.totalItems=response.total;//�ܼ�¼�� 
	         	     				$scope.list=response.rows;//���б������ֵ 
	          	     		}		
	          	     	);				
          	     };
        	      
          });
          