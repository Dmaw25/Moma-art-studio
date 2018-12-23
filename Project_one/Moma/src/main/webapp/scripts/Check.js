let user = {};

window.onload = function(){
	populateUser();
}

function populateUser(){
	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/Moma/session").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		if (data.session === null) {
			console.log("data.session was null");
			window.location = "http://localhost:7001/Moma/Login";
		} else {
			//define behavior for user returned
			user = data;
			document.getElementById("username").innerText = "Username: "+user.userName;
			document.getElementById("firstname").innerText = "First name: "+user.firstName;
			document.getElementById("lastname").innerText = "Last name: "+user.lastName;
		}
	});	
}
	function populateReim() {
		//send a GET request to localhost:7001/SessionMgntDemo/session
		fetch("http://localhost:7001/Moma/reimList").then(function(response) {
			return response.json();
		}).then(function(data) {
			if (data.session === null) {
				console.log("data.session was null")
				window.location = "http://localhost:7001/Moma/ReimbursmentList";
			} else {
				var listReim = "";
				thing = data;
				var i;
				for (i = 0; i < thing.length; i++) { 
					listReim += JSON.stringify(thing[i]);
					var para = document.createElement('p');
					var t = document.createTextNode(listReim);
					para.appendChild(t);
				}
				document.getElementById("reim").appendChild(para);
			}
		});
	}
