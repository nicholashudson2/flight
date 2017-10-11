/* @ngInject */
class LoginController {
    credentials = {
        username: '',
        password: ''
    }

    constructor(loginService) {
        this.loginService = loginService
    }

    userLogin = () => {
        this.loginService.authenticateUser(this.credentials).then((result) => {
            if (result.data) {
                sessionStorage.setItem('userLogin', this.credentials.userLogin);
                sessionStorage.setItem('password', this.credentials.password);
                alert('Thank you! You are now logged in!')
            }
        }, (error) => {
            alert('Login failed. Try again.')
        })
    }

}

export default LoginController