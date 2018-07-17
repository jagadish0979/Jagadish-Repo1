//app.js
var app = angular.module("app", ["ngRoute"]);
app.config(function($routeProvider) {
$routeProvider
.when("/", {
    templateUrl : "/Assignments/views/main.html"
})
.when("/assignments", {
	controller: 'AssignmentController',
    templateUrl : "/Assignments/views/assignments.html",
	controllerAs: 'vm'
})
.when("/assignments-fe", {
	controller: 'AssignmentFEController',
	templateUrl: '/Assignments/views/assignments-fe.html',
	controllerAs: 'vm'
}) 
.when("/assignments-fe-result", {
	controller: 'AssignmentFEResultController',
	templateUrl: '/Assignments/views/assignments-fe-result.html',
	controllerAs: 'vm'
}) 
.when("/assignments-result", {
	controller: 'AssignmentResultController',
	templateUrl: '/Assignments/views/assignments-result.html',
	controllerAs: 'vm'
}) 
.otherwise({ redirectTo: '/' });
});
