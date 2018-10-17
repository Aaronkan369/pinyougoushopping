//�����
app.service('sellerService',function($http){
	    	
	//��ȡ�б����ݰ󶨵�����
	this.findAll=function(){
		return $http.get('../seller/findAll.do');		
	}
	//��ҳ 
	this.findPage=function(page,rows){
		return $http.get('../seller/findPage.do?page='+page+'&rows='+rows);
	}
	//��ѯʵ��
	this.findOne=function(id){
		return $http.get('../seller/findOne.do?id='+id);
	}
	//���� 
	this.add=function(entity){
		return  $http.post('../seller/add.do',entity );
	}
	//�޸� 
	this.update=function(entity){
		return  $http.post('../seller/update.do',entity );
	}
	//ɾ��
	this.dele=function(ids){
		return $http.get('../seller/delete.do?ids='+ids);
	}
	//����
	this.search=function(page,rows,searchEntity){
		return $http.post('../seller/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
});
