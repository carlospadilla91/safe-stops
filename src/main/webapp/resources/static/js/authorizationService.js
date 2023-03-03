'use strict'

angular.module('safeStopApp').factory('AuthorizationService', ['$http', '$q', function($http, $q) {
	
	var LOCAL = 'http://localhost:8081/api/auth/';
	
	var factory = {
		createUser: createUser,
		loginUser: loginUser
	};
	return factory;
	
	function createUser(user) {
		var deferred = $q.defer();
		$http.post(LOCAL + 'register', user).then(function(response) {
			console.log('New User created' + response)
			deferred.resolve(response.data);
		},
		function(error) {
			console.error('Error' + error);
			deferred.reject(error);
		}
	);
	return deferred.promise;
	}
	
	function loginUser(user) {
		var deferred = $q.defer();
		$http.post(LOCAL + 'login', user).then(function(response) {
			console.log('Login success');
			deferred.resolve(response.data);
		},
		function(error) {
			console.error('Error in login' + error);
			deferred.reject(error);
		}
	);
	return deferred.promise;
	}
	
	
}])