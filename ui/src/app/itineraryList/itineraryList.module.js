import itineraryListComponent from './itineraryList.component.js'
import itineraryListService from './itineraryList.service'
import itineraryListController from './itineraryList.controller'

export default
  angular
    .module('itineraryList', [])
    .component('itineraryListComponent', itineraryListComponent)
    .controller('itineraryListController', itineraryListController)
    .service('itineraryListService', itineraryListService)
    .name