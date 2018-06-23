<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

$(document).ready(function(){
    $("#EditPostForm").validate({
    	submitHandler: function(form) {
    		$("#wrapper").load('EditPostController',$("#EditPostForm").serialize());
    	}
    });      
});

</script>

<div id="post_modal" class="w3-modal">

    <div class="w3-modal-content" style="width:40%">
        <form  id="EditPostForm" class="w3-container w3-card-4" action="EditPostController" >
        <span onclick="document.getElementById('post_modal').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		<br>
		<p>
		
		<div class="w3-row ">
		  <div class="w3-container">
		  	<textarea class="w3-input w3-border" style="display:none;" id="idPost" name="id"></textarea>
			<p>      
			<label class="w3-text-grey">Title</label>
			<textarea class="w3-input w3-border" id="titlePost" name="title" style="resize:none"></textarea>
			</p>
			<p>
		    <label class="w3-text-grey">Content </label>
		    <textarea class="w3-input w3-border " id="contentPost" name="content" style="resize:none"></textarea>
		    </p>
		    
			
			<p> <input class="w3-button w3-black" name="submit" type="submit" value="Save"> </p>

		  </div>
		</div>
      </form>
    </div>
  </div>