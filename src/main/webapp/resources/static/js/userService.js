'use strict'

angular.module('safeStopApp').factory('UserService', ['$http', '$q', function($http, $q){
	
	var LOCAL = 'http://localhost:8080/users/';
	
	var factory = {
		listUsers: listUsers,
		saveUser: saveUser
	};
	return factory;
	
	function listUsers() {
		var deferred = $q.defer();
		$http.get(LOCAL + "userList").then(function(response) {
			deferred.resolve(response.data);
		},
			function(err) {
				console.error('Error while fetching users');
				deferred.reject(err);
			}
		);
		return deferred.promise;
	}
	
	function saveUser(user) {
		var deferred = $q.defer();
		$http.post(LOCAL, user).then(function(response) {
			console.log('User saved');
			deferred.resolve(response.data);
		},
			function(err) {
				console.log('Error');
			}
		);
			return deferred.promise;
	}
	
}]);