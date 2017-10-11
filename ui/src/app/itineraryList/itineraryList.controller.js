/* @ngInject */
class ItineraryListController {

    constructor(itineraryListService, $map, $state) {
        this.itineraryListService = itineraryListService
        this.$map = $map
        this.$state = $state

        this.findItineraries()
    }

    findItinerary() {
        this.itineraryListService.findItinerary().then((result) => {
            this.itineraryList = result.data
            console.dir(this.itineraryList)
        })
    }

    showItineraryMap(itinerary) {
        this.$map.flights = itinerary
        this.$state.go('index.itineraryList.map')
    }

}

export default ItineraryListController