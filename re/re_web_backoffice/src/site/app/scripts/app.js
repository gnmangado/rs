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
    'ngTouch',
    'gettext'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl',
        controllerAs: 'home'
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
      .when('/cities', {
        templateUrl: 'views/cities.html',
        controller: 'CitiesCtrl',
        controllerAs: 'cities'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

  angular.module('reWebBackofficeApp').run(function (gettextCatalog) {
    gettextCatalog.debug = true;
    gettextCatalog.setCurrentLanguage('es');
});
