/* @ngInject */
class ItineraryController {

    constructor(itineraryService, $map, $state) {
        this.itineraryService = itineraryService
        this.$map = $map
        this.$state = $state
    }

    showItineraryMap(flights) {
        this.$map.flights = flights
        this.$state.go('index.itinerary.map')
    }

}

export default ItineraryController