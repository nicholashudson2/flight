/* @ngInject */
class MapService {

  flights = []

  constructor ($http, apiUrl, $state) {
    this.$http = $http
    this.apiUrl = apiUrl
  }

  getMarkerByCityName (name) {
    return this.$http
      .get(`${this.apiUrl}/location/name`, { params: { name } })
      .then(result => result.data)
    }

}

export default MapService

