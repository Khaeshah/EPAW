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
		  	<img id=user_profile class= "image-cropper" src="" >
		  	
		  	
		  </div>
		</div>
		
		<h2 class="w3-round w3-teal w3-center w3-content" style="width:80%; margin-top:30px;">Post History</h2>
		<hr>
		<div id="profileposts" class="w3-container w3-round">
		
		<div id="user_post">
        <h2  id="user_post_title" class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i></h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b  id="user_post_content"></b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>${post.eventTime} <span class="w3-tag w3-teal w3-round">  ${post.place} </span></h6>
          <p> <span class="fake-link" style="text-decoration: underline color:blue">${post.author}</span>  posted ${post.time}</p>
          <hr>
        </div>
        </div>
		
		
		</div>
		
    </div>
  </div>