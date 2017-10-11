/* @ngInject */
class FlightListService {
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    getDailyFlights = () => {
        return this.$http.get(`${this.apiUrl}/flights`)
    }

}

export default FlightListService
