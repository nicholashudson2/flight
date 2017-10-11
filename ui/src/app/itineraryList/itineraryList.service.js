/* @ngInject */
class ItineraryListService {
    constructor($http, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    findItineraries = (origin, destination) => {
        return this.$http.get(`${this.apiUrl}/flights/from/@${origin}/to/@${destination}`)
    }

}

export default ItineraryListService
