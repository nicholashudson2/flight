import loginComponent from './login.component.js'
import loginService from './login.service'
import loginController from './login.controller'

export default
  angular
    .module('userLogin', [])
    .component('login', loginComponent)
    .controller('loginController', loginController)
    .service('loginService', loginService)
    .name