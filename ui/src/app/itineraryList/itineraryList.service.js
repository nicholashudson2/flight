/* @ngInject */
class ItineraryListService {

    origin = ''
    destination = ''
    flights = []

    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    findItineraries = () => {
        return this.$http.get(`${this.apiUrl}/flights/from/@${this.origin}/to/@${this.destination}`)
    }

}

export default ItineraryListService
