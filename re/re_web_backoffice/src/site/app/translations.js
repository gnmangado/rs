angular.module('gettext').run(['gettextCatalog', function (gettextCatalog) {
/* jshint -W100 */
    gettextCatalog.setStrings('en', {"Home":"Home","Search":"Search","States":"States"});
    gettextCatalog.setStrings('es', {"Home":"Inicio","Search":"Búsqueda","States":"Departamentos"});
/* jshint +W100 */
}]);