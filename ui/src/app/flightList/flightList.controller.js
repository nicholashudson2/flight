/* @ngInject */
class FlightListController {

    flightList = []

    constructor(flightListService, $map) {
        this.flightListService = flightListService
        this.$map = $map
        
        this.getAllFlights()
    }

    getAllFlights = () => {
        this.flightListService.getDailyFlights().then((result) => {
            this.flightList = result.data
        })
    }

    findItineraries() {
        this.flightListService.findItineraries(this.origin, this.destination).then((result) => {
            this.flightList = result.data
        })
    }

    showFlightsMap(itinerary) {
        this.$map.flights = flightList
        this.$state.go('index.map')
    }

}

export default FlightListController