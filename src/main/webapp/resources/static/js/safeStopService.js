'use strict'

angular.module('safeStopApp').factory('SafeStopService', ['$http', '$q', function($http, $q) {
	
	var LOCAL = 'http://localhost:8081/api/safeStops';
	
	var factory = {
		findAllSafeStops: findAllSafeStops,
		saveSafeStop: saveSafeStop,
		updateSafeStop: updateSafeStop,
		deleteSafeStop: deleteSafeStop
	};
	return factory;
	
	function findAllSafeStops() {
		var deferred = $q.defer();
		$http.get(LOCAL).then(function(response) {
			deferred.resolve(response.data);
		},
			function(err) {
				console.error('Error while fetching safeStops');
				deferred.reject(err);
			}
		);
		return deferred.promise;
	}
	
	function saveSafeStop(safeStop) {
		var deferred = $q.defer();
		$http.post(LOCAL, safeStop).then(function(response) {
			console.log('SafeStop saved');
			deferred.resolve(response.data);
		},
			function(err) {
				console.log('Error');
			}
		);
			return deferred.promise;
	}
	
	function updateSafeStop(safeStop, id) {
		var deferred = $q.defer();
		$http.put(LOCAL + '/' + id, safeStop).then(function(response) {
			deferred.resolve(response.data);
		},
		function(err) {
			console.error('Error');
			deferred.reject(err);
		});
		return deferred.promise;
	}
	
	function deleteSafeStop(id) {
		var deferred = $q.defer();
		console.log('safestop to be deleted', id);
		$http.delete(LOCAL + '/' + id)
		.then(function (response) {
			deferred.resolve(response.data);
		},
		function(error) {
			console.error('Error deleting SafeStop', error);
			deferred.reject(error);
		});
		return deferred.promise;
	}
	
}

])