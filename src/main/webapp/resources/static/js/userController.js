'use strict'

angular.module('safeStopApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService){
	var self = this;
	self.user = new User();
	self.users = [];
	self.submit = submit;
	self.reset = reset;
	
	function listUsers() {
		UserService.listUsers().then(function(data) {
			self.users = data;
		},
			function(err) {
				console.error(err + 'Error while fetching users list');
			}
		)
	}
	
	function saveUser(user) {
		return UserService.saveUser(user).then(listUsers, function(err) {
			console.error(err + 'Error while trying to save user');
		});
	}
	
	function updateUser(user, id) {
		UserService.updateUser(user, id).then(listUsers, function(err) {
			console.error(err + 'Error while trying to update user');
		});
	}
	
	function submit() {
		if(self.user.id === null) {
			console.log('Saving new user', self.user);
			saveUser(self.user);
		}
		if(self.user.id !== null) {
			updateUser(self.user, self.user.id);
			console.log('User updated with id: ', self.user.id);
		}
		reset();
	}
	
	function reset() {
		self.user = { id: null, username: '', email: '', password: ''};
		$scope.safeStopForm.$setPristine();
	}
	
}]);