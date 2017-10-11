/* @ngInject */
class HistoryListService {

    history = []

    constructor($http, apiUrl, ) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    findHistory = () => {
        return this.$http.get(`${this.apiUrl}/flights/from/@${this.origin}/to/@${this.destination}`)
    }

}

export default HistoryListService
