app.controller('sellerController',function($scope,$controller,sellerService ){
	
	$controller('baseController',{$scope:$scope});//�̳�
	
	//����
	$scope.add=function(){
		
		sellerService.add($scope.entity).success(
		     function(response){
		    	 
		    	    if(response.success){
						//���ע��ɹ�����ת����¼ҳ
			        	location.href="shoplogin.html";
					}else{
						alert(response.message);
					}
		     }		
		);
	}
	
});