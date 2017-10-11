/* @ngInject */
class LoginService {
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }


    authenticateUser = (credentials) => {
        return this.$http.post(`${this.apiUrl}/client/login`, credentials)
    }

    clearSessionStorage = () => {
        sessionStorage.clear();
    }

}

export default LoginService
