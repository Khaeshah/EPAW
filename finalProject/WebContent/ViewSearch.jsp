<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>


function sendSearch(){
	$('#wrapper').load('SearchController',{search_input:$("#search_input").val(),checkboxTweets:$("#checkboxTweets").val(),checkboxUsers:$("#checkboxUsers").val()});
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

	<!--
	  		<div class="w3-bar">
			  <a href="#" class="w3-button">1</a>
			  <a href="#" class="w3-button">2</a>
			  <a href="#" class="w3-button">3</a>
			  <a href="#" class="w3-button">4</a>
			  <a href="#" class="w3-button">5</a>
			</div>
	-->