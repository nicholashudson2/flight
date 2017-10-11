import flightListComponent from './flightList.component.js'
import flightListService from './flightList.service'
import flightListController from './flightList.controller'

export default
  angular
    .module('flightList', [])
    .component('flightList', flightListComponent)
    .controller('flightListController', flightListController)
    .service('flightListService', flightListService)
    .name