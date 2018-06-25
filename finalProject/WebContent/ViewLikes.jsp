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

	<form id="giveLike${param.postId}" action="LikesController" class= "w3-padding-5">
		<input type="image" name="submitLike" id="submitLike${param.postId}" src="images/heart.png" value= "${param.postId}" onclick="giveLikeToComment(${param.postId})" style="width: 20px; height: 20px">
		<input type="hidden" id="submitLikeHide${param.postId}" name="submitLikeHide" value="${param.postId}">
		<input type="hidden" id="addLike${param.postId}" name="addLike" value="true">

	</form>

</div>
</body>
