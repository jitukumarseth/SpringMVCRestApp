<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script>
	var app = angular.module('myapp', []);
	
			app.controller('myctrl',function($scope, $http) {
				
						$scope.postData=function(){
							
							var sid= document.getElementById("pid").value;
							var name= document.getElementById("name").value;
							var location= document.getElementById("location").value;
							var data ={
									
									sid:sid,
									name:name,
									location:location
							}
							
							$http.post('http://localhost:8080/SpringMVCRestApp/rest/addperson',JSON.stringify(data))
									.success(function(response) {
											
											
											
										
									});
						}
						
				
				
				
						$http.get('http://localhost:8080/SpringMVCRestApp/rest/getperson')
								.success(function(data) {
									$scope.persons = data;
								});
					});
			
			
			
</script>
 
</head>
<body ng-app="myapp" ng-controller="myctrl">

	<table  border="2px" cellspacing="2px" align="center">
		<tr>
			<td>sid</td>
			<td>name</td>
		    <td>location</td>
		<tr ng-repeat="person in persons">
			<td>{{person.sid}}</td>
			<td>{{person.name}}</td>
			<td>{{person.location}}</td>
			
		<tr>
		</tr>
	</table>
	

		<label>Pid</label>:<input type="text" id="pid"/><br/>
		<label>name</label>:<input type="text" id="name"/><br/>
		<label>location</label>:<input type="text" id="location"/><br/>
		<input type="button" ng-click="postData()" value="send Data">
		<h1 ng-bind="msg"></h1>
	
	

</body>
</html>