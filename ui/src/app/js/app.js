var myApp = angular.module('flightApp', ['ui.router']).config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider, $transition$) {

    $urlRouterProvider.otherwise('/signIn');

    var signInState = {
        name: 'signIn',
        url: '/login',
        component: 'loginRegisterComponent',
        onEnter: ['loginRegisterService', function (loginRegisterService) {
            loginRegisterService.clearSessionStorage();
            loginRegisterService.myStyle = { display: 'none' }
        }]
    }

    var mainPageState = {
        name: 'main',
        url: '/main',
        component: 'mainPageComponent',
        resolve: {
            resolvedFollowers: ['usernameListService', function (usernameListService) {
                return usernameListService.getFollowers('');
            }],
            resolvedFollowing: ['usernameListService', function (usernameListService) {
                return usernameListService.getFollowing('');
            }]
        }
    }

}])