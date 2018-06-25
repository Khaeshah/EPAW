<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

$(document).ready(function(){
    $("#EditProfileForm").validate({
    	submitHandler: function(form) {
    		$("#wrapper").load('EditUserController',$("#EditProfileForm").serialize());
    }
    });
});


</script>

<div id="edit_profile_modal" class="w3-modal">

    <div class="w3-modal-content">
        <form  id="EditProfileForm" class="w3-container w3-card-4" action="EditUserController" >
        <span onclick="document.getElementById('profile_modal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		<p>
		
		<div class="w3-row ">
		  <div class="w3-container w3-half ">
		  	<p>
			<label class="w3-text-grey">Username</label>
			<textarea class="w3-input w3-border " name="user" id="userNameEdit" style="resize:none">a</textarea>
			</p>
			<p>      
			<label class="w3-text-grey">Description</label>
			<textarea class="w3-input w3-border" name="description" id="descriptionEdit" style="resize:none"></textarea>
			</p>
			<p>
		    <label class="w3-text-grey">Image url </label>
		    <textarea class="w3-input w3-border " name="url" id="imageSrcEdit" style="resize:none"></textarea>
		    </p>

			<p> <input class="w3-button w3-black" name="submit" type="submit" value="save"> </p>
			
		  </div>
		  <div class="w3-container w3-half">
		  	<img class= "image-cropper" src="${userinfo.url}" width="200" height="200">
		  </div>
		</div>
      </form>
    </div>
  </div>