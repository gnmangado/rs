'use strict';

describe('Controller: StatesCtrl', function () {

  // load the controller's module
  beforeEach(module('reWebBackofficeApp'));

  var StatesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StatesCtrl = $controller('StatesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(StatesCtrl.awesomeThings.length).toBe(3);
  });
});
