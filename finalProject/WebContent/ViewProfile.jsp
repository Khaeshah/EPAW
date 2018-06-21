<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>


</script>

<div id="profile_modal" class="w3-modal">

    <div class="w3-modal-content">
        <form  id="ProfileForm" class="w3-container w3-card-4" action="PostController" >
        <span onclick="document.getElementById('profile_modal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		<p>
		
		<div class="w3-row ">
		  <div class="w3-container w3-half ">
		  	<p>
			<label class="w3-text-grey">username</label>
			<input class="w3-input w3-border " name="title" type="text" required>
			</p>
			<p>      
			<label class="w3-text-grey">Description</label>
			<textarea class="w3-input w3-border" name="description" style="resize:none"></textarea>
			</p>
			<p>
		    <label class="w3-text-grey">image url</label>
		    <input class="w3-input w3-border " name="url" type="text" style="heigh:110%;" required>
		    </p>

			<p> <input class="w3-button w3-black" name="submit" type="submit" value="save"> </p>
			
		  </div>
		  <div class="w3-container w3-half">
		  	<img class= "image-cropper" src="https://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg" width="200" height="200"  alt="Computer Hope">
		  </div>
		</div>
	
		
	
      </form>
    </div>
  </div>