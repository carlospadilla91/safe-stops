'use strict'

angular.module('safeStopApp').controller('SafeStopController', ['$scope', 'SafeStopService', function($scope, SafeStopService){
	var self = this;
	self.safeStop = { id: null, name: '', description: '', rating: null };
	self.safeStops = [];
	self.submit = submit;
	self.reset = reset;
	
	findAllSafeStops();
	
	function findAllSafeStops() {
		SafeStopService.findAllSafeStops().then(function(data) {
			console.log(data);
			self.safeStops = data;
		},
			function(err) {
				console.error(err + 'Error while fetching safeStops list');
			}
		)
	}
	
	function saveSafeStop(safeStop) {
		return SafeStopService.saveSafeStop(safeStop).then(findAllSafeStops, function(err) {
			console.error(err + 'Error while trying to save safeStop');
		});
	}
	
	function updateSafeStop(safeStop, id) {
		SafeStopService.updateSafeStop(safeStop, id).then(findAllSafeStops, function(err) {
			console.error(err + 'Error while trying to update safeStop');
		});
	}
	
	function submit() {
		if(self.safeStop.id === null) {
			console.log('Saving new safeStop', self.safeStop);
			saveSafeStop(self.safeStop);
		}
		if(self.safeStop.id !== null) {
			updateSafeStop(self.safeStop, self.safeStop.id);
			console.log('SafeStop updated with id: ', self.safeStop.id);
		}
		reset();
	}
	
	function reset() {
		self.safeStop = { id: null, name: '', description: '', rating: null};
		$scope.safeStopForm.$setPristine();
	}
	
	
}]);