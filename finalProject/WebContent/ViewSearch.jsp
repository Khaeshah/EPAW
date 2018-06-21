<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>


function sendSearch(){
	$('#content').load('SearchController',{content:$("#search_input").val()});
}

</script>


 <div class="search-container">
     <form id="searchForm" action="SearchController" class= "w3-padding-5">
				 <div class="w3-half">
				 <input name="search" id="search_input" class="w3-input w3-border" type="text" placeholder="One">
				 </div>
			     <button  class="w3-btn w3-teal w3-border" type="submit" onclick="sendSearch()"> <i class="fa fa-search"></i></button>
	 </form>
</div>