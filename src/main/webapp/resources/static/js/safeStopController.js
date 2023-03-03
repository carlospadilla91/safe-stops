'use strict'

angular.module('safeStopApp').controller('SafeStopController', ['$scope', 'SafeStopService', function($scope, SafeStopService){
	var self = this;
	self.safeStop = { id: null, name: '', description: '', rating: null };
	self.safeStops = [];
	self.submit = submit;
	self.reset = reset;
	self.edit = edit;
	self.remove = remove;
	
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
	
	function deleteSafeStop(id) {
		SafeStopService.deleteSafeStop(id)
			.then(findAllSafeStops, function(err) {
				console.error('Error deleting SafeStop');
			});
	}
	
	function remove(id) {
		console.log('id to be deleted', id);
		let accept = confirm("Are you sure you want to delete this SafeStop?");
		if(accept) {
			deleteSafeStop(id);
		}
		reset();
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
	
	function edit(id) {
		console.log('id to be edited', id);
		for(const stop of self.safeStops) {
			if(stop.id === id) {
				self.safeStop = angular.copy(stop);
				break;
			}
		}
	}
	
	function reset() {
		self.safeStop = { id: null, name: '', description: '', rating: null};
		$scope.safeStopForm.$setPristine();
	}
	
	
}]);