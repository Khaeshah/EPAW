<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="models.BeanUser"  import="models.BeanLogin" import="models.BeanPost" %>



<% 
BeanUser user = null;
BeanLogin login = null;

if (request.getAttribute("user")!=null) {
	user = (BeanUser)request.getAttribute("user");
}
else {
	user = new BeanUser();
}

if (request.getAttribute("login")!=null) {
	login = (BeanLogin)request.getAttribute("login");
}
else {
	login = new BeanLogin();
}

%>


<script>
	$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); // Avoids Internet Explorer caching!
	    $('#wrapper').load('MainController');
	});
	
	var Msg, Msg2= null;
	Msg ='<%=user.getError()[0]%>';
	Msg2 ='<%=login.getError()[0]%>';

   if (Msg != "null" ) {
	 swal("Mail already or username in use.");
	}
  
   if (Msg2 != "null" ) {
		 swal("wrong username or password.");
	}
	   

</script>


