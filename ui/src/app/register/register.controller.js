/* @ngInject */
class RegisterController {
    profile = {
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
    }
    
    credentials = {
        username: '',
        password: ''
    }


    constructor(registerService) {
        this.registerService = registerService
    }

    userRegister = () => {
        this.registerService.createUser(this.credentials, this.profile).then((result) => {
            if (result.data) {
                // sessionStorage.setItem('userLogin', this.credentials.userLogin);
                // sessionStorage.setItem('password', this.credentials.password);
            } else {
                this.myStyle = { display: 'block', opacity: 0.5, "margin-bottom": '8%' }
            }

        }, (error) => {
            alert('Account Creation failed. Try again.')
        })
    }

}

export default RegisterController