/* @ngInject */
class SearchService {
    constructor ($http, apiUrl, origin, destination) {
      this.$http = $http
      this.origin = origin
      this.destination = destination
      this.apiUrl = apiUrl
    }
  
    getFlightsByOriginDestination (origin, destination) {
      return this.$http
        .get(`${this.apiUrl}/from/@${this.origin}/to/@${this.destination}`)
        .then(result => result.data)
    }
  }
  
  export default SearchService
  
  