var app = angular.module("mainApp", ["ngResource", "ngRoute"]);
app.controller("mainCtrl", ["$scope", function($scope){

}]);

//Angular Routing
app.config(["$routeProvider", function($routeProvider){
	$routeProvider.when("/", {
		templateUrl: "template/home.html"
	}).when("/add",{
		templateUrl: "template/add.html"
	}).when("/show",{
		templateUrl: "template/show.html",
		controller: "showCtrl"
	}).when("/update/:name",{
		templateUrl: "template/update.html",
		controller: "updateCtrl"

	}).otherwise({
		redirectTo: "/"
	});

}]);

app.controller("homeCtrl", ["$scope", "$http", "empFactory", function($scope, $http, empFactory){
	// $http.get("/rest/es").then(function(resp){
	// 	$scope.empList = resp.data;
	// });
	empFactory.getEmpList().then(function(data){
		$scope.empList = data;
		
	});
	$scope.doDelete = function(index){
		var emp = $scope.empList[index];
		var url = "http://localhost:8080/SpringRESTCORS/rest/person/";
		$http.delete(url + emp.name).then(function(resp){
			$scope.empList.splice(index, 1);
		});
	}
}]);

app.controller("addCtrl", ["$scope", "$http", "$location", function($scope, $http, $location){
	$scope.doSubmit = function(){
		var url = "http://localhost:8080/SpringRESTCORS/rest/person";
		$http.post(url, $scope.emp).then(function(resp){
			console.log("resp");
			$location.path("/home");
		})
	}
	$scope.doClear = function(){
		$scope.emp = {};
	}
}]);

app.controller("updateCtrl", ["$scope", "$http", "$location", "$routeParams", "empFactory",
	function($scope, $http, $location, $routeParams, empFactory){
		var name = $routeParams.name;
		var url = "http://localhost:8080/SpringRESTCORS/rest/person/" + name;
		$http.get(url).then(function(resp){
			$scope.emp  = resp.data;
			$scope.originalEmp = angular.copy($scope.emp);
		});
		$scope.doSubmit = function(){
			$http.put("http://localhost:8080/SpringRESTCORS/rest/person", $scope.emp).then(function(resp){
				console.log(resp);
				$location.path("/home");
			})
		}
		$scope.doClear = function(){
			$scope.emp.address = {};
			$scope.emp.age = null;
		}
		$scope.doClear = function(){
			$scope.emp = angular.copy($scope.originalEmp);//?
		}
	}])

app.controller("showCtrl", ["$scope", "$http", "empFactory", function($scope, $http, empFactory){
	$scope.c = 0;
	empFactory.getEmpList().then(function(data){
		$scope.empList = data;
		$scope.current = $scope.empList[$scope.c];
	});
	$scope.goPrevious = function(){
		$scope.c--;
		$scope.current = $scope.empList[$scope.c];
	}
	$scope.goNext = function(){
		$scope.c++;
		$scope.current = $scope.empList[$scope.c];
	}
}])

app.factory("empFactory", function($q, $http){
	return {
		getEmpList : function(){
			var defer = $q.defer();
			var url = "http://localhost:8080/SpringREST/rest/person"
			$http.get(url).then(function(resp){
				defer.resolve(resp.data);
			});
			return defer.promise;
		}
	}
})