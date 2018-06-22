<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import="models.BeanLogin"%>
    
    
<script type="text/javascript">

$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); // Avoids Internet Explorer caching!
	    $('#wrapper').load('MainController');
});

</script>
