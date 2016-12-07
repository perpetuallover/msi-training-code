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
		$http.delete("/rest/es/" + emp.name).then(function(resp){
			$scope.empList.splice(index, 1);
		});
	}
}]);

app.controller("addCtrl", ["$scope", "$http", "$location", function($scope, $http, $location){
	$scope.doSubmit = function(){
		$http.post("/rest/es", $scope.emp).then(function(resp){
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
		$http.get('/rest/es/' + name).then(function(resp){
			$scope.emp  = resp.data;
			$scope.originalEmp = angular.copy($scope.emp);
		});
		$scope.doSubmit = function(){
			$http.put("/rest/es", $scope.emp).then(function(resp){
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
			$http.get("/rest/es").then(function(resp){
				defer.resolve(resp.data);
			});
			return defer.promise;
		}
	}
})