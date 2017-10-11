/* @ngInject */
class ItineraryService {

    flights = []

    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

}

export default ItineraryService
