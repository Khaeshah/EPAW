
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="models.BeanLogin" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<% 
BeanLogin login = null;
if (request.getAttribute("user")!=null) {
	login = (BeanLogin)request.getAttribute("login");
}
else {
	login = new BeanLogin();
}
%>

<script>
$(document).ready(function(){
    $("#loginForm").validate({
    	submitHandler: function(form) {
    		$('#content').load('LoginController',$("#loginForm").serialize());
    }
    });
});


</script>

<form  class="w3-container" id="loginForm" action="" method="POST" style="color:rgb(0, 102, 153);">
<div class="w3-section">      
<label>Usarname</label> 
<input  type="text" name="user" value="${login.user}" id="user" class=" w3-input required" placeholder="Username" minlength="5"/> </td> 
</div>
<c:if test="${login.error[0] == 1}">
   <div class="error"> Nonexistent username in our DB! </div> 
</c:if>

<div class="w3-section">      
<label>Password</label> 
<input type="password" name="password" id="password_input" class="w3-input" placeholder="Password" value="${login.password}" ></input>
</div>
<div class="w3-section w3-center">      
<input class="w3-button w3-black" name="submit" type="submit" value="Enviar"> 
</div>      
</form>