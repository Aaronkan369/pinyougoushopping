 //�Զ������
app.service('brandService',function($http){
        	  
        	  //��ѯȫ��
     	     this.finadAll = function(){
        		  
     	    	return  $http.get('../brand/findAll.do');
        	    		  
     	     };
     	     
     	     
     	    //��ҳ��ѯ
   	        this.findPage = function(page,rows){
   	    	 
   	    	   return  $http.get('../brand/findByPage.do?pageNum='+page+'&pageSize='+rows);
   	        };
   	      
   	      
   	      
          
          //��������ҳ��ѯ
    	  this.search = function(page,rows,searchEntity){
        	  console.log(page);
        	  console.log(rows);
        	  console.log(searchEntity);
    		  return $http.post('../brand/search.do?pageNum='+page+'&pageSize='+rows,searchEntity);
    	  };
          
          //��ѯָ��Ʒ��
          this.findOne=function(id){
    	        $http.get('../brand/findOne.do?id='+id);
          };
          
          
          //����
          this.add=function(entity){
        	  
        	    return $http.post('../brand/add.do',entity);
          };
          
           //�޸�
           this.update=function(entity){
        	  
        	    return $http.post('../brand/update.do',entity);
          };
       
          //ɾ��
          this.dele = function(selectIds){
        	  
        	   return $http.get('../brand/delete.do?ids='+selectIds);
          };
    	    
    	      
        	  
    });
          