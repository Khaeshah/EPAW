<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import="models.BeanUser"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

$(document).ready(function() {
    $(".menu").click(function(event) {
        $('#content').load('ContentController',{content: $(this).attr('id')});
        });
    
	$(".menu2").click(function(event) {
	    $('#profile_modal').show();
	    });
});
</script>


 <div id= userinfo>
  		  <div  class="w3-container"> 
          <a class="menu2" id="ProfileController" href="#"><i class="material-icons" style="float: right;  padding-top:20px; padding-right: 35px;">mode_edit</i></a>
          </div>
 		
        <div id=profile class="w3-display-container"> 
        
        
        
        <c:choose>
		  <c:when test="${empty  userinfo.url}">
		     <img class="profile" src="images/profile.png" height="40" width="40"> 
		  </c:when>
		  <c:when test="${not empty  userinfo.url}">
		   <img class= "image-cropper" src="${userinfo.url}" height="40" width="40"> 
		  </c:when>
		</c:choose>
		
          <div id="user_name" class="w3-container w3-light-grey w3-center w3-section w3-round-small"> ${userinfo.profilename}
      		
          <a class="menu" id="LogoutController" href="#"> <i class="fa fa-sign-out" style="float: right; font-size:24px; padding-right: 20px;"></i></a>
     	
          </div>

        </div>
			<div id= "user_description" class="w3-container">
          		<span> ${userinfo.description} </span>
          		<hr>
			  	<p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Subcriptions</b>
			  	<div class="w3-bar-block">
			  	<a class="w3-bar-item w3-button w3-center w3-round-medium w3-teal" style= "margin: 5px; href="#">barcelona/Food</a>
			  	<a class="w3-bar-item w3-button w3-center w3-round-medium w3-teal" style= "margin: 5px; href="#">barcelona/Movie</a>
			  	<a class="w3-bar-item w3-button w3-center w3-round-medium w3-teal" style= "margin: 5px; href="#">barcelona/disco</a>
			</div>
			</div>
</div>





