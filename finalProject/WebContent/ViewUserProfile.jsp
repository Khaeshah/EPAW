<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="models.BeanUser"%>



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

</script>

<div id="userProfile" class="w3-modal">

    <div class="w3-modal-content">
        <span onclick="document.getElementById('userProfile').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		<p>
		
		<div class="w3-row ">
		  <div class="w3-container w3-half ">
		  	<p>
			<label class="w3-text-grey">Username: </label>
			</p> 
			${user.user}
			<p>      
			<label class="w3-text-grey">Description: </label>
			</p>
			

			<!-- <p> <input class="w3-button w3-black" name="submit" type="submit" value="save"> </p> -->
		  </div>
		  <div class="w3-container w3-half">
		  	<img class= "image-cropper" src="https://i.pinimg.com/originals/c9/df/ed/c9dfede10c5ee873384927b015bb6d06.jpg" width="200" height="400"  alt="Computer Hope">
		  </div>
		</div>
    </div>
  </div>