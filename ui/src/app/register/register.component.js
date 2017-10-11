/* @ngInject */
import templateUrl from './register.component.html'

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
    controller: 'registerController',
    // controllerAs: '$loginCtrl',
    // bindings: {
    //     credentials: '='
    // }
}