/* @ngInject */
import templateUrl from './login.component.html'

// /* @ngInject */
// class LoginController {

//     constructor($login) {
//         this.$login = $login
//         this.credentials = {
//             username: '',
//             password: ''
//         }
//     }

//     userLogin = () => {
//         $login.authenticateUser(this.credentials).then((result) => {
//             if (result.data) {
//                 // sessionStorage.setItem('userLogin', this.credentials.userLogin);
//                 // sessionStorage.setItem('password', this.credentials.password);
//             } else {
//                 this.myStyle = { display: 'block', opacity: 0.5, "margin-bottom": '8%' }
//             }

//         }, (error) => {
//             prompt('Login failed. Try again.')
//         })
//     }

// }

export default {
    templateUrl,
    controller: 'loginController',
    // controllerAs: '$loginCtrl',
    // bindings: {
    //     credentials: '='
    // }
}










// OLD PROJECT



// angular.module('twitterApp').service('signInService', ['$http', function($http){


//         this.myStyle = {display: 'none'}

//         this.authenticateUser = () => {
//             if(!this.credentials || !this.credentials.userLogin || !this.credentials.password){
//                 alert('Forgot something!');
//                 return 'signIn';
//             }

//             return $http.post('http://localhost:8090/client/signIn', this.credentials).then((result) => {
//                if(result.data){
//                    sessionStorage.setItem('userLogin', this.credentials.userLogin);
//                    sessionStorage.setItem('password', this.credentials.password);
//                    return 'main.allFlights';
//                }else{
//                     this.myStyle = {display: 'block', opacity: 0.5, "margin-bottom": '8%'}
//                 return 'signIn';
//                }

//             });

//         }

//         this.clearSessionStorage = () => {
//             sessionStorage.clear();
//         }


//     }])