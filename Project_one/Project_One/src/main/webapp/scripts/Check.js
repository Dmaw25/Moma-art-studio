/**
 * 
 */
window.onload = function(){
populateUser();
}
function populateUser(){
	fecth("localhost:7001/sessionMgmtDemo/session")
	.then(function(response){
	return response.json();
	})
	.then(function(data){
		objReturned = JSON.parse(data);
		
		if(data.session === null){
			window.location = "http://localhost:7001/SessionMgmtDemo/login";
			
		}
		else{
			emp = date;
			document.getElementById("managers").innerText = user.userName;
			document.getElementById("username").innerText = user.userName;
			document.getElementById("firstName").innerText = user.userName;
			document.getElementById("lastName").innerText = user.userName;
			document.getElementById("reportTo").innerText = user.userName;
			document.getElementById("account").innerText = user.userName;
			document.getElementById("reimbursment").innerText = user.userName;
		}
	});
}