/* @ngInject */
class HistoryListService {

    history = []

    constructor($http, apiUrl, ) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    findHistory = () => {
        return this.$http.get(`${this.apiUrl}/itinerary/from/@${sessionStorage.getItem('userLogin')}`)
    }

}

export default HistoryListService
