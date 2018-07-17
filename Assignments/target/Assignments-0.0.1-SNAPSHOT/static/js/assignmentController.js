//AssignmentController.js

angular
.module('app').controller('AssignmentController', function ($scope, $rootScope, $location,  $http , $q, assignmentDataFactory) {
	var vm = this;
    var uploadUrl = "";
    var obj = {
			transactionReference: "",
			description: "",
			failedReason: ""
    	    };
	    $scope.processFile = function () {
		      var file = document.getElementById("myFile").files[0];
		      
		      
			  $scope.responseData = [];
		      if (file) {
		    	  var extn = file.name.split(".").pop();
			      if(extn == "csv"){
			    	    uploadUrl = "http://localhost:8080/Assignments/processCSV";
			      }
			      else if(extn == "xml"){
			    	    uploadUrl = "http://localhost:8080/Assignments/processXML";
			      }
		        var fileReader = new FileReader();
		        fileReader.readAsText(file);
		        fileReader.onload = function (evt) {
		            $scope.fileContent = fileReader.result;
				    console.dir(file);
				    var deffered = $q.defer();		            
		            console.log("fileContent=====>"+$scope.fileContent);
		            var dataObject = { fileName : file.name, fileContent : JSON.stringify($scope.fileContent) };
		            $http.post(uploadUrl,dataObject).then(
	            		function (response) {
	            			var data = response.data;
	            			var size = Object.keys(response.data).length;
	            			//alert(size);
	            			var lines = [];
	        	    		for ( var i = 0; i <size; i++) {
	        	    				obj = {
	        	    						transactionReference: "",
	        	    						description: "",
	        	    						failedReason: ""
	        	    			    	    };
	        	    				obj.transactionReference = data[i].transactionReference;
	        	    				obj.description = data[i].description;
	        	    				obj.failedReason = data[i].failedReason;
	        	    				lines.push(obj);
	        	    		}
	        	    		assignmentDataFactory.set(lines);
	        	    		console.log("lines=====>"+lines);
	        			    $location.path("/assignments-result");
			            },
			            function (data, status, header, config) {
			            }	
		            )
		        }
		        fileReader.onerror = function (evt) {
		            $scope.fileContent = "error";
		        }
		      }
	    }	



});