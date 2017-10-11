import registerComponent from './register.component.js'
import registerService from './register.service'
import registerController from './register.controller'

export default
  angular
    .module('userRegistration', [])
    .component('register', registerComponent)
    .controller('registerController', registerController)
    .service('registerService', registerService)
    .name