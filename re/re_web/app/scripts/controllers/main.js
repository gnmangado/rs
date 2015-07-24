'use strict';

/**
 * @ngdoc function
 * @name reWebApp.controller:MainCtrl
 * @description # MainCtrl Controller of the reWebApp
 */
angular.module('reWebApp').controller('MainCtrl', function($scope) {
	$scope.todos = [ ];
	$scope.addTodo = function() {
		$scope.todos.push($scope.todo);
		$scope.todo = '';
	};
	$scope.removeTodo = function (index) {
		$scope.todos.splice(index, 1);
	};
});
