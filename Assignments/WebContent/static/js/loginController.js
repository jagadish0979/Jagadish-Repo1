//loginController.js
(function () {
'use strict';
angular
.module('app')
.controller('LoginController', LoginController);
LoginController.$inject = ['$location'];
function LoginController( $location) {
var vm = this;
vm.login = login;
function login() {
console.log("login method executing");

if (vm.username === "admin" && vm.password === "admin") {
$location.path('/links');
} else {
alert("Error !");
}

}
}
})();