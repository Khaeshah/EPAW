<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(document).ready(function(){
    $("#PostForm").validate({
    	submitHandler: function(form) {
    		$('#content').load('PostController',$("#PostForm").serialize());
    }});
    
    var elements = document.getElementsByTagName("input");
    for (var ii=0; ii < elements.length; ii++) {
      if (elements[ii].type == "text") {
        elements[ii].value = "";
      }
    }
});




</script>

<div id="id01" class="w3-modal">

    <div class="w3-modal-content">
      <form  id="PostForm" class="w3-container w3-card-4" action="PostController" >
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		<p>      
		<label class="w3-text-grey">Title</label>
		<input class="w3-input w3-border" name="title" type="text" required>
		</p>
		<p>      
		<label class="w3-text-grey">Content</label>
		<textarea class="w3-input w3-border" name="content" style="resize:none"></textarea>
		</p>
		<div class="w3-half">
		<select class="w3-select" name="place">
	    <option value="" disabled selected>where to publish</option>
	    <option value="Barcelona">Barcelona</option>
	    <option value="Valencia">Valencia</option>
	    <option value="Madrid">Madrid</option>
	 	</select>
	 	</div>
	 	<div class="w3-half">
	 	<select class="w3-select" name="interest">
	    <option value=""disabled selected>What's the topic</option>
	    <option value="Restaurants">Restaurants</option>
	    <option value="Movie">Movie</option>
	    <option value="Parties">Parties</option>
	 	</select>	 
	 	</div>
		<br>
		<input type="datetime-local" name="eventime">
		<p> <input class="w3-button w3-black" name="submit" type="submit" value="Enviar"> </p>
		

      </form>
    </div>
  </div>