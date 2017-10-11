import historyListComponent from './historyList.component.js'
import historyListService from './historyList.service'
import historyListController from './historyList.controller'

export default
  angular
    .module('historyList', [])
    .component('historyListComponent', historyListComponent)
    .controller('historyListController', historyListController)
    .service('historyListService', historyListService)
    .name