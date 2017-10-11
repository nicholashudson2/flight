/* @ngInject */
class FlightListController {
    // credentials = {
    //     username: '',
    //     password: ''
    // }

    flightList = []

    constructor(flightListService) {
        this.flightListService = flightListService

        this.getAllFlights()
    }

    getAllFlights = () => {
        this.flightListService.getDailyFlights().then((result) => {
            this.flightList = result.data
            console.dir(this.flightList)
        })
    }

    findItineraries() {
        this.flightListService.findItineraries(this.origin, this.destination).then((result) => {
            this.flightList = result.data
        })
    }

    // userLogin = () => {
    //     this.loginService.authenticateUser(this.credentials).then((result) => {
    //         if (result.data) {
    //             // sessionStorage.setItem('userLogin', this.credentials.userLogin);
    //             // sessionStorage.setItem('password', this.credentials.password);
    //         } else {
    //             this.myStyle = { display: 'block', opacity: 0.5, "margin-bottom": '8%' }
    //         }

    //     }, (error) => {
    //         alert('Login failed. Try again.')
    //     })
    // }

}

export default FlightListController