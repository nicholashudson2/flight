import mapLocations from './map.locations'
import mapComponent from './map.component.js'
import mapService from './map.service'

export default
  angular
    .module('flight.search', ['ngSearch'])
    .constant('locations', mapLocations)
    .component('flightMap', mapComponent)
    .service('$map', mapService)
    .name







import '../../static/style.css'
import 'bootstrap'
import flightMap from './map/map.module'
import apiUrl from './api.url'
import appComponent from './app.component.js'


export default
  angular
    .module('flight', [
      'ngAria',
      'ngAnimate',
      'ngMaterial',
      'ngMessages',
      'ui.router',

      flightMap
    ])

    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .name