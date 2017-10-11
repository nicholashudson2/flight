/* @ngInject */
class ItineraryListController {

    itineraryList = []

    constructor(itineraryListService, $state) {
        this.itineraryListService = itineraryListService
        this.$state = $state

        this.findItineraries()
    }

    findItineraries() {
        this.itineraryListService.findItineraries().then((result) => {
            this.itineraryList = result.data
            console.dir(this.itineraryList)
        })
    }

}

export default ItineraryListController