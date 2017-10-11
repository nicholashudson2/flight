import templateUrl from './app.component.html'


/* @ngInject */
class AppController {

  origin = ''
  destination = ''

  constructor($log, $state, itineraryListService) {
    this.itineraryListService = itineraryListService
    this.$state = $state
    $log.debug('AppController is a go.')
  }

  findItineraries() {
    this.itineraryListService.origin = this.origin
    this.itineraryListService.destination = this.destination
    if (!this.$state.is('index.itineraryList')) {
      this.$state.go('index.itineraryList')
    } else {
      this.$state.reload()
    }
  }

}

export default {
  templateUrl,
  controller: AppController,
  controllerAs: '$appCtrl',
  bindings: {
    origin: '=',
    destination: '='
  }
}
