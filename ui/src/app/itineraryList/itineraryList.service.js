/* @ngInject */
class ItineraryListService {

    origin = ''
    destination = ''
    flights = []
    flightArrivalTimes = []
    flightDestinations = []
    flightDurations = []
    flightOffsets = []
    flightOrigins = []

    constructor($http, apiUrl, ) {
        this.$http = $http
        this.apiUrl = apiUrl
    }

    saveTrip = (itinerary) => {
        this.flights.forEach((flight) => {
            this.flightArrivalTimes.add(flight.arrival)
            this.flightDestinations.add(flight.destination)
            this.flightDurations.add(flight.arrival - flight.offsetFromStart)
            this.flightOffsets.add(flight.offsetFromStart)
            this.flightOrigins.add(flight.origin)

            console.dir(flightArrivalTimes)
            console.dir(flightDestinations)
            console.dir(flightDurations)
            console.dir(flightOffsets)
            console.dir(flightOrigins)
        }).then((results) => {
            this.bookTrip()
        })
    }

    findItineraries = () => {
        return this.$http.get(`${this.apiUrl}/flights/from/@${this.origin}/to/@${this.destination}`)
    }

    bookTrip = () => {
        return this.$http.post(`${this.apiUrl}/itinerary`, 
        { credentials: { 
            password: sessionStorage.getItem('userLogin'),
            username: sessionStorage.getItem('password')
          }, 
          flightArrivalTimes: this.flightArrivalTimes, 
          flightDestinations: this.flightDestinations, 
          flightDurations: this.flightDurations, 
          flightOffsets: this.flightOffsets, 
          flightOrigins: this.flightOrigins 
        })
    }

}

export default ItineraryListService
