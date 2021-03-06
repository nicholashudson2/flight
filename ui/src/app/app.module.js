import 'bootstrap'
import '../../static/style.css'
import '../../src/app/script.js'
import flightMap from './map/map.module'
import flightList from './flightList/flightList.module'
import userLogin from './login/login.module'
import itineraryList from './itineraryList/itineraryList.module'
import historyList from './historyList/historyList.module'
import userRegistration from './register/register.module'
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

      flightMap,
      userLogin,
      userRegistration,
      flightList,
      itineraryList,
      historyList
    ]).config(['$stateProvider', '$urlRouterProvider', 
    function($stateProvider, $urlRouterProvider) {

      const mainPageState = {
        abstract: true,
        name: 'index',
        url: '/index',
        component: 'flightApp'
      }

      const flightListState = {
        name: 'index.flightList',
        url: '/flightList',
        component: 'flightList'
      }

      const itineraryListState = {
        name: 'index.itineraryList',
        url: '/itineraryList',
        component: 'itineraryListComponent'
      }

      const allFlightsMapState = {
        name: 'index.flightList.map',
        url: '/map',
        component: 'flightMap'
      }

      const itineraryListMapState = {
        name: 'index.itineraryList.map',
        url: '/map',
        component: 'flightMap'
      }

      const historyListState = {
        name: 'index.historyList',
        url: '/historyList',
        component: 'historyListComponent'
      }

      const historyListMapState = {
        name: 'index.historyList.map',
        url: '/map',
        component: 'flightMap'
      }

      $stateProvider.state(mainPageState)
      .state(allFlightsMapState)
      .state(flightListState)
      .state(itineraryListState)
      .state(itineraryListMapState)
      .state(historyListState)
      .state(historyListMapState)
      
      $urlRouterProvider.otherwise('/index/flightList')
    } 
  ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .name
