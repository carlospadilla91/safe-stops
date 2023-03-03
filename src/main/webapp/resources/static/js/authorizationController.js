'use strict'

angular.module('safeStopApp').controller('AuthorizationController', ['$scope', '$window', 'AuthorizationService', function($scope, $window, AuthorizationService) {
	var self = this;
	self.user = { id: null, email: '', username: '', password: '' };
	self.users = [];

	self.loginSubmit = loginSubmit;
	self.submit = submit;
	self.reset = reset;
	
	function loginUser(user) {
		
		return AuthorizationService.loginUser(user).then(function(data) {
			console.log('User login success' + data);
			if(user.username === data.username && user.password === data.password) {
				toSafeStops();
			} else {
				$window.alert('Incorrect Username or Password');
				redirect();
			}
		},
			function(error) {
				console.error('Error in loginUser Controller' + error);
			}
		);
	}
	
	function createUser(user) {
		
		return AuthorizationService.createUser(user).then(function(data) {
			console.log('New user created' + data);
			redirect();
		},
		function(error) {
			console.error('Error in createUser Controller' + error);
		}
		);
	}
	
	function loginSubmit() {
		let userLogin = {
			username: $scope.username,
			password: $scope.password
		}
		console.log(userLogin);
		loginUser(userLogin);
	}
	
	function submit() {
		createUser(self.user);
	}
	
	function reset() {
		self.user = { id: null, email: '', username: '', password: ''};
		$scope.safeStopForm.$setPristine();
	}
	
	function redirect() {
		return $window.location.href = '/login';
	}
	
	function toSafeStops() {
		return $window.location.href = '/safeStops';
	}
	
}]);