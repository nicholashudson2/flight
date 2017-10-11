/* @ngInject */
class RegisterService {
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }


    createUser = (credentials, profile) => {
        return this.$http.post(`${this.apiUrl}/client`, {credentials, profile})
    }

    clearSessionStorage = () => {
        sessionStorage.clear();
    }

}

export default RegisterService
