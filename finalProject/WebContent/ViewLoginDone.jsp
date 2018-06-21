<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<script type="text/javascript">

swal("Login done");
$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); // Avoids Internet Explorer caching!
	    $('#wrapper').load('MainController');
});
</script>
