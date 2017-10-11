/* @ngInject */
class ItineraryListService {

    origin = ''
    destination = ''

    constructor($http, $state, apiUrl) {
        this.$http = $http
        this.apiUrl = apiUrl
        this.$state = $state
    }

    findItineraries = () => {
        return this.$http.get(`${this.apiUrl}/flights/from/@${this.origin}/to/@${this.destination}`)
    }

}

export default ItineraryListService
