 //自定义服务
app.service('specificationService',function($http){
        	  
	    	  //查询全部
	 	     this.finadAll = function(){
	    		  
	 	    	return  $http.get('../specification/findAll.do');
	    	    		  
	 	     };
	 	     
	 	     
	 	    //分页查询
	        this.findPage = function(page,rows){
	    	 
	    	   return  $http.get('../specification/findByPage.do?pageNum='+page+'&pageSize='+rows);
	        };
	      
	        //有条件分页查询
		    this.search = function(page,rows,searchEntity){
	    	  //console.log(page);
	    	  //console.log(rows);
	    	  //console.log(searchEntity);
			  return $http.post('../specification/search.do?pageNum='+page+'&pageSize='+rows,searchEntity);
		    };
	      
	      //查询指定规格
	      this.findOne=function(id){
		       return  $http.get('../specification/findOne.do?id='+id);
	      };
	      
	      
	      //新增
	      this.add=function(entity){
	    	  
	    	    return $http.post('../specification/add.do',entity);
	      };
	      
	       //修改
	       this.update=function(entity){
	    	  
	    	    return $http.post('../specification/update.do',entity);
	      };
	   
	      //删除
	      this.dele = function(selectIds){
	    	  
	    	   return $http.get('../specification/delete.do?ids='+selectIds);
	      };
    	    
    	      
        	  
    });
          