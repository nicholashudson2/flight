/* @ngInject */
class ItineraryListController {

    constructor(itineraryListService, $map, $state) {
        this.itineraryListService = itineraryListService
        this.$map = $map
        this.$state = $state

        this.findItineraries()
    }

    findItineraries() {
        this.itineraryListService.findItineraries().then((result) => {
            this.itineraryList = result.data
            console.dir(this.itineraryList)
        })
    }

    showItineraryMap(itinerary) {
        this.$map.flights = itinerary
        this.$state.go('index.itineraryList.map')
    }

    bookTrip(itinerary) {
        this.itineraryListService.bookTrip(itinerary)
    }

}

export default ItineraryListController