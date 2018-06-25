<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="models.BeanUser" %>

<script>
$(document).ready(function(){
    $("#registerForm").validate({
    	submitHandler: function(form) {
    		
    		var test = validatePassword();
    		if(test) {
    			$('#wrapper').load('RegisterController',$("#registerForm").serialize());
    		}
    		
    }
    });
});

</script>

<% 
BeanUser user = null;
if (request.getAttribute("user")!=null) {
	user = (BeanUser)request.getAttribute("user");
}
else {
	user = new BeanUser();
}
%>



<form class="w3-container" action="RegisterController" method="post" id="registerForm" style="color:rgb(0, 102, 153);">  


	<div class="w3-section">   
	
		<label>Username</label>   
        <input type="text" id="username_input" class="w3-input required" placeholder="Username" name="user" value="<%=user.getUser() %>" required minlength="5"></input>
        
    </div>
   
      <div class="w3-section">   
      <label>Email</label>   
       <input type="email" name="mail" id="mail" value="<%=user.getMail() %>" required email" class="w3-input required" placeholder="Email"></input>
 	  </div>
 	  
 	  <div class="w3-section">   
      <label>Password</label>   
      <input type="password" name="password" id="password_input" class="password-input w3-input required" placeholder="Password" value="<%=user.getPassword() %>" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers."></input>
 	  </div>
 	  
 	   <div class="w3-section">   
      <label>Confirm password</label>   
      <input type="password" name="confirmPassword" id="confirmPassword" class="password-input w3-input required"  placeholder="Confirm Password" value="<%=user.getConfirmPassword() %>" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Please enter the same Password as above." ></input>
 	  </div>
 	  
  		<div class="w3-section w3-center">   
      <button  class ="w3-button w3-black" id="login-button" type="submit" value="Enviar" >Register</button>
		</div>
    </form>


 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdn.jsdelivr.net/velocity/1.2.2/velocity.min.js'></script>
<script src='https://cdn.jsdelivr.net/velocity/1.2.2/velocity.ui.min.js'></script>



 <script>
 
	var Msg ='<%=user.getError()[0]%>';
	var Msg2 ='<%=user.getError()[1]%>';
	    if (Msg != "null" &&  Msg2 != "null") {
	 function alertName(){
		 swal("mail already or username in use");
	 	} 
	 }
	
	
		function validatePassword(){
			
			var password = document.getElementById("password_input")
			, confirm_password = document.getElementById("confirmPassword");
			
			
			if(password.value != confirm_password.value) {
				swal("password doest not match ");
				return false;
			}
			return true;
		}
    
</script>
</body>
</html>
