
app.controller('indexController' ,function($scope,$controller   ,loginService){	
    //��ȡ��ǰ��¼��  
	$scope.showLoginName=function(){
		loginService.loginName().success(
			function(response){
				$scope.loginName=response.loginName;
			}			
		);
	}    
});	


