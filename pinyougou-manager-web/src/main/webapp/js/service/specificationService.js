 //�Զ������
app.service('specificationService',function($http){
        	  
	    	  //��ѯȫ��
	 	     this.finadAll = function(){
	    		  
	 	    	return  $http.get('../specification/findAll.do');
	    	    		  
	 	     };
	 	     
	 	     
	 	    //��ҳ��ѯ
	        this.findPage = function(page,rows){
	    	 
	    	   return  $http.get('../specification/findByPage.do?pageNum='+page+'&pageSize='+rows);
	        };
	      
	        //��������ҳ��ѯ
		    this.search = function(page,rows,searchEntity){
	    	  //console.log(page);
	    	  //console.log(rows);
	    	  //console.log(searchEntity);
			  return $http.post('../specification/search.do?pageNum='+page+'&pageSize='+rows,searchEntity);
		    };
	      
	      //��ѯָ�����
	      this.findOne=function(id){
		       return  $http.get('../specification/findOne.do?id='+id);
	      };
	      
	      
	      //����
	      this.add=function(entity){
	    	  
	    	    return $http.post('../specification/add.do',entity);
	      };
	      
	       //�޸�
	       this.update=function(entity){
	    	  
	    	    return $http.post('../specification/update.do',entity);
	      };
	   
	      //ɾ��
	      this.dele = function(selectIds){
	    	  
	    	   return $http.get('../specification/delete.do?ids='+selectIds);
	      };
    	    
    	      
        	  
    });
          