<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="models.BeanUser"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 


BeanUser user = null;
if (request.getAttribute("user")!=null) {
	user = (BeanUser)request.getAttribute("user");
}
else {
	user = new BeanUser();
}

System.out.println(user.getUser());

%>

<script>


function follow(event){
	
	url ="http://localhost:8080/finalProject/UserProfileController"
	user1 = document.getElementById("user_name").innerText;
	user2 = document.getElementById("labe_username").innerHTML;
	$.post(url,{content:event.innerText, user1:user1, user2:user2},
		function(response){
		
		a = JSON.parse(response);
		if(a.content=="Follow")
			document.getElementById("followbutoon").innerText="Following";
		else
			document.getElementById("followbutoon").innerText="Follow";
		}

	);
	
}

function deleteUser(event){
	userToDelete = document.getElementById("labe_username").innerHTML;
	$('#wrapper').load('DeleteUserController',{userDel: userToDelete})	
}

function editUser(event){
	

	
	// Agafo el contingut del usuari i el carrego al formulari per poder editarlo
	userNameToEdit = document.getElementById("labe_username").innerHTML;
	description = document.getElementById("labe_description").innerHTML;
	imageUrl = document.getElementById("user_profile").src;
	// Els camps que ens interessen son carregats
	document.getElementById("userNameEdit").innerText = userNameToEdit;
	document.getElementById("descriptionEdit").innerText = description;
	document.getElementById("imageSrcEdit").innerText = imageUrl;
	
	$('#edit_profile_modal').show();
	//$('#wrapper').load('EditUserController',{content: userNameToEdit, desc:description, img:imageUrl});	
}


</script>

<div id="userProfile" class="w3-modal">

    <div class="w3-modal-content">
        <span onclick="document.getElementById('userProfile').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		
		<div class="w3-row ">
		
		  <div class="w3-container w3-half">

		  <br>
			<ul class="w3-ul">
			<div>Username:</div>
	    	<li><label id="labe_username" class="w3-text-grey"></label></li>
	    	
	    	<div>Description:</div>
	    	<li><label id="labe_description" class="w3-text-grey">Description: </label></li>
	 		 </ul>

		  	</div>
		  	<div class="w3-container w3-half">
		  	
		  	<button id="followbutoon" class="w3-btn w3-teal w3-round-xlarge w3-center w3-show-inline-block " onclick="follow(this);">Follow</button>
			<c:if test="${userinfo.is_admin eq true}">
				<button id="editUserButton" class="w3-btn w3-teal w3-round-xlarge w3-center w3-show-inline-block " onclick="editUser(this);">Edit User</button>
			
				<button id="deleteButton" class="w3-btn w3-teal w3-round-xlarge w3-center w3-show-inline-block " onclick="deleteUser(this);">Delete User</button>
			</c:if>
		  	<img id=user_profile class= "image-cropper" src="" >

		  </div>
		</div>
		
		<h2 class="w3-round w3-teal w3-center w3-content" style="width:80%; margin-top:30px;">Post History</h2>
		<hr>
		<div id="profileposts" class="w3-container w3-round">
		

		</div>
		
    </div>
  </div>
  
  