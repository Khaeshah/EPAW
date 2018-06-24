<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>

function giveLikeToComment(){
    $('#content_giveLike_input').load('LikesController',{content:$("#submitLikeHide").val()});
}

</script>
<body>
<div class="search-container" style="width:95%;" >

	<form id="giveLike" action="LikesController" class= "w3-padding-5">
		<input type="image" name="submitLike" id="submitLike" src="images/heart.png" value= "${param.postId}" onclick="giveLikeToComment(${param.postId})" style="width: 20px; height: 20px">
		${currentLikes}
		<input type="hidden" id="submitLikeHide" name="submitLikeHide" value="${param.postId}">
		<input type="hidden" id="addLike" name="addLike" value="true">

	</form>

</div>
</body>
