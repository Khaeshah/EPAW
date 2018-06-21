<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import= "models.BeanPost"%>
    
    
<% 
BeanPost post = null;

if (request.getAttribute("post")!=null) {
	post = (BeanPost)request.getAttribute("post");
	post.setEventime(post.getEventime().replace('T', ' '));
	System.out.println(post.getEventime());
}
else {
	post = new BeanPost();
}

%>
    
<script>
$(document).ready(function(){

    $('#Posts').prepend($('#post'));

    });

</script>
		<div id="post">
        <h2  class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i> ${post.title}</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>${post.content}</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>${post.eventime} <span class="w3-tag w3-teal w3-round">  ${post.place} </span></h6>
          <p> <span class="fake-link" style="text-decoration: underline color:blue">${post.author}</span>  posted ${post.postime}</p>  
          <hr>
        </div>
        </div>
