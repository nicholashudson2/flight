import itineraryComponent from './itinerary.component.js'
import itineraryService from './itinerary.service'
import itineraryController from './itinerary.controller'

export default
  angular
    .module('itinerary', [])
    .component('itineraryComponent', itineraryComponent)
    .controller('itineraryController', itineraryController)
    .service('itineraryService', itineraryService)
    .name