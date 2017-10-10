angular.module('flightApp').service('loginService', ['$http', function ($http) {

    this.registerNewUser = () => {
        if (!this.user || !this.user.credentials || !this.user.credentials.userLogin || !this.user.credentials.password || !this.user.profile || !this.user.profile.email) {
            alert('Are you Serious!');
            return
        }
        sessionStorage.setItem('username', this.user.credentials.userLogin);
        sessionStorage.setItem('password', this.user.credentials.password);
        return $http.post('http://localhost:8090/users', this.user);

    }

    this.myStyle = { display: 'none' }

    this.authenticateUser = () => {
        if (!this.credentials || !this.credentials.userLogin || !this.credentials.password) {
            alert('Forgot something!');
            return 'signIn';
        }

        return $http.post('http://localhost:8090/users/signIn', this.credentials).then((result) => {
            if (result.data) {
                sessionStorage.setItem('userLogin', this.credentials.userLogin);
                sessionStorage.setItem('password', this.credentials.password);
                return 'main.allTweets';
            } else {
                this.myStyle = { display: 'block', opacity: 0.5, "margin-bottom": '8%' }
                return 'signIn';
            }

        });

    }

    this.clearSessionStorage = () => {
        sessionStorage.clear();
    }
}])