 //自定义服务
app.service('brandService',function($http){
        	  
        	  //查询全部
     	     this.finadAll = function(){
        		  
     	    	return  $http.get('../brand/findAll.do');
        	    		  
     	     };
     	     
     	     
     	    //分页查询
   	        this.findPage = function(page,rows){
   	    	 
   	    	   return  $http.get('../brand/findByPage.do?pageNum='+page+'&pageSize='+rows);
   	        };
   	      
   	      
   	      
          
          //有条件分页查询
    	  this.search = function(page,rows,searchEntity){
        	  console.log(page);
        	  console.log(rows);
        	  console.log(searchEntity);
    		  return $http.post('../brand/search.do?pageNum='+page+'&pageSize='+rows,searchEntity);
    	  };
          
          //查询指定品牌
          this.findOne=function(id){
    	        $http.get('../brand/findOne.do?id='+id);
          };
          
          
          //新增
          this.add=function(entity){
        	  
        	    return $http.post('../brand/add.do',entity);
          };
          
           //修改
           this.update=function(entity){
        	  
        	    return $http.post('../brand/update.do',entity);
          };
       
          //删除
          this.dele = function(selectIds){
        	  
        	   return $http.get('../brand/delete.do?ids='+selectIds);
          };
    	    
    	      
        	  
    });
          