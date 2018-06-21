<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<script type="text/javascript">
$(document).ready(function() {
    $(".menu").click(function(event) {
        $('#content').load('ContentController',{content: $(this).attr('id')});
        });
});
</script>
<div class="w3-container">

      	 <img class="profile" src="images/logo.png" >
      	 
</div>

<div class="w3-container w3-center "  style= "padding-top:30px;">


  <a class="menu w3-button w3-hover-none w3-centered w3-blue w3-hover-red" id="RegisterController"  href=#>	Registration </a> 
  <a class="menu w3-button w3-hover-none w3-centered w3-blue w3-hover-red" id="LoginController" href=# > Login </a> 


</div>





	