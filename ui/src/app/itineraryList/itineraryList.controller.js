/* @ngInject */
class ItineraryListController {
    // credentials = {
    //     username: '',
    //     password: ''
    // }

    itineraryList = []

    constructor(itineraryListService) {
        this.itineraryListService = itineraryListService
    }

    findItineraries() {
        this.itineraryListService.findItineraries(this.origin, this.destination).then((result) => {
            this.itineraryList = result.data
        })
    }

}

export default ItineraryListController