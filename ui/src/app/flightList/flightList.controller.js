/* @ngInject */
class FlightListController {

    flightList = []

    constructor(flightListService, $map, $state) {
        this.flightListService = flightListService
        this.$map = $map
        this.$state = $state
        
        this.getAllFlights()
    }

    getAllFlights = () => {
        this.flightListService.getDailyFlights().then((result) => {
            this.showFlightsMap(result.data)
        })
    }

    findItineraries() {
        this.flightListService.findItineraries(this.origin, this.destination).then((result) => {
            this.flightList = result.data
        })
    }

    showFlightsMap(flights) {
        this.$map.flights = flights
        this.$state.go('index.map')
    }

}

export default FlightListController