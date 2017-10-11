/* @ngInject */
class HistoryListController {

    constructor(historyListService, $map, $state) {
        this.historyListService = historyListService
        this.$map = $map
        this.$state = $state

        this.findHistory()
    }

    findHistory() {
        this.historyListService.findHistory().then((result) => {
            this.historyList = result.data
            console.dir(this.historyList)
        })
    }

    showHistoryMap(history) {
        this.$map.flights = history
        this.$state.go('index.historyList.map')
    }

}

export default HistoryListController