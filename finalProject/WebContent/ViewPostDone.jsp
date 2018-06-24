<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import= "models.BeanPost"%>
    
    
<% 
BeanPost post = null;

if (request.getAttribute("post")!=null) {
	post = (BeanPost)request.getAttribute("post");
	post.setEventTime(post.getEventTime().replace('T', ' '));
	System.out.println(post.getEventTime());
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
      	<span onclick="deletePost(${post.id})" class="w3-button" >&times;</span>
      	
      	<!-- Edit posts -->  
      	<span onclick="editPost(${post.id})" class="w3-button" id="bEditPost">■</span>
 
        <h2  class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i> ${post.title}</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b>${post.content}</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>${post.eventTime} <span class="w3-tag w3-teal w3-round">  ${post.place} </span></h6>
          <p> <span class="fake-link" style="text-decoration: underline color:blue" onclick="showProfile(this)">${post.author}</span>  posted ${post.time}</p>
          <hr>
        </div>
        </div>
