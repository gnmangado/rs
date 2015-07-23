'use strict';

/**
 * @ngdoc overview
 * @name reWebBackofficeApp
 * @description
 * # reWebBackofficeApp
 *
 * Main module of the application.
 */
angular
  .module('reWebBackofficeApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/home', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl',
        controllerAs: 'home'
      })
      .when('/states', {
        templateUrl: 'views/states.html',
        controller: 'StatesCtrl',
        controllerAs: 'states'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
