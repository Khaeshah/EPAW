<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>


function sendSearch(){
	$('#content_search_input').load('SearchController',{content:$("#search_input").val()});
    $('#content_checkboxTweets').load('SearchController',{content:$("#checkboxTweets").val()});
    $('#content_checkboxUsers').load('SearchController',{content:$("#checkboxUsers").val()});

}

</script>
<body>
<div class="search-container" style="width:95%;" >

		<form id="searchForm" action="SearchController" class= "w3-padding-5">
				
				<input name="search" id="search_input" class="w3-input w3-border w3-show-inline-block" type="text" style="width: 40%" placeholder="Search something">
				<button class="w3-btn w3-teal w3-border w3-show-inline-block" type="submit" onclick="sendSearch()"> <i class="fa fa-search"></i></button>
					<input name="checkboxTweets" id="checkboxTweets" class="w3-check w3-show-inline" type="checkbox">
					<label>Tweets</label>
					<input name="checkboxUsers" id="checkboxUsers" class="w3-check w3-show-inline" type="checkbox">
					<label>Users</label>
		</form>
	
</div>
</body>
