//�ѹ��ԵĶ����ҳ���
app.controller('baseController',function($scope){
	
	 //��ҳ�ؼ����� 
     $scope.paginationConf = {
    		 currentPage: 1,
    		 totalItems: 10,
    		 itemsPerPage: 10,
    		 perPageOptions: [10, 20, 30, 40, 50],
    		 
    		 onChange: function(){
    		     $scope.reloadList();//���¼���
    		 }
     };
    
    
     //ˢ���б�
	 $scope.reloadList=function(){
		
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	 }; 
	 
	 
      
     
	
	 //���¸�ѡ
	 $scope.selectIds = [];//ѡ�е�ID����
     
     
     $scope.updateSelection = function($event, id) {	
    	 
    		if($event.target.checked){
    			
			      //����Ǳ�ѡ��,�����ӵ�����
				  $scope.selectIds.push( id);			
    		}else{
    			
				 var idx = $scope.selectIds.indexOf(id);
		         $scope.selectIds.splice(idx, 1);//ɾ�� 
    		}
     };
	
	
	
});