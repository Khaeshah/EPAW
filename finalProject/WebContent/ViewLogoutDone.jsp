<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<script type="text/javascript">
swal("Logged out!");
$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); //Avoids Internet Explorer caching!
        $('#wrapper').load('MainController');   
});
</script>

