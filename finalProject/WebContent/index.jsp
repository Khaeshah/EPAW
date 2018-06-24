<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import="models.BeanUser, models.BeanPost" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"> </script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
</style>
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">

</head>
<body class="w3-light-grey">


<% 
	String user = "";
		if(session.getAttribute("user") != null ){
			user = session.getAttribute("user").toString();
		}

	BeanUser userinfo = null;
		if (request.getAttribute("userinfo")!=null) {
			userinfo = (BeanUser)request.getAttribute("userinfo");
		}
		else {
			userinfo = new BeanUser();
		}
%>

  <!-- Begin Wrapper -->
  <div id=wrapper class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
      
      	<c:if test= "${empty user}">
      
	    <jsp:include page="ViewMenuNotLogged.jsp" />
	    
		 </c:if>	   
		 
		  <c:if test= "${not empty user}">
		  				
		  	<jsp:include page="ViewMenuLogged.jsp" />
		  </c:if>	 
      	
     
		<div id="content"></div>
		
  <div  id="hot_topics" style="margin:10px;">
  <p class="w3-large w3-text-theme"><b><img class="new" src="images/new.png" ></i>Updates</b></p>

          <h5  >Movies</h5>
  <a href="index.html" style="text-decoration: none">      

  <ul class="w3-ul">
  <li>
    <div class="w3-container w3-card w3-indigo">
    Underground movies
    </div>
    <p>Free movie night at espai brut workshop </p>
  </li>
  </ul>
  </a>
       

  <p>Parties</p>
        <a href="index.html" style="text-decoration: none">      

  <ul class="w3-ul">
  <li>
    <div class="w3-container w3-card w3-indigo">
    80s parties 
    </div>
    <p>At mongoli dancefloor</p>
  </li>
  </ul>
  </a>
    
  <p>Food</p>
        <a href="index.html" style="text-decoration: none">      

  <ul class="w3-ul">
  <li>
    <div class="w3-container w3-card w3-indigo">
    Cheap shushi
    </div>
    <p>New shushi place at xxx serving unlimited sushi for 5euros</p>
  </li>
  </ul>
  </a>
  </div>
        </div>
        <br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    <div id="search_bar" class="w3-bar w3-black ">
    
    
     <div class="w3-col" style="width:10%">  <div class="w3-dropdown-hover">
     		
		    <button class="w3-button w3-black" onclick="sendButton(this)">Home</button>
		    
			     <c:if test= "${not empty user}">
			    <div class="w3-dropdown-content w3-bar-block w3-border">
			    	<button class="w3-bar-item w3-button" onclick="sendButton(this)">Subscription</button> 
			    </div>
			    </c:if>
		  </div> 
	</div>
        <div class="w3-col" style="width:80%;">
        

            <jsp:include page="ViewSearch.jsp" />


		</div>

    <div class="w3-col" style="width:10%">
    	 
		  <c:if test= "${not empty user}">
		  
	 		<button class="w3-button w3-circle w3-teal w3-show-inline-block" onclick="document.getElementById('id01').style.display='block'">+</button>	 
		 </c:if>
	</div>
	</div>
	
	   <jsp:include page="ViewPostModal.jsp" />
	   
	   <jsp:include page="ViewProfile.jsp"/>
	   
	   <jsp:include page="ViewUserProfile.jsp"/>
	   <jsp:include page="ViewPost.jsp"/>
	
      	<div id="Posts"  class="w3-container w3-card w3-white w3-margin-bottom">
      	
      	<c:forEach items="${postList}" var="BeanPost">
      	
      	<div id="post${BeanPost.id}}">
      	
      	
      	<!-- Admin can delete or edit all posts.
      		 Users can only delete their own posts
   		-->
      	<c:choose>
    		<c:when test="${userinfo.is_admin eq true}">
    			<!-- Delete and Edit posts -->
        		<span onclick="deletePost(${BeanPost.id})" class="w3-button" >&times;</span>
        		<span onclick="editPost(${BeanPost.id})" class="w3-button" id="bEditPost">■</span>
    		</c:when>    
    		<c:otherwise>
	        	<!-- Delete posts -->
				<c:if test="${BeanPost.author eq user}">
      				<span onclick="deletePost(${BeanPost.id})" class="w3-button" >&times;</span>
      			</c:if>
      	
      			<!-- Edit posts -->  
      			<c:if test="${BeanPost.author eq user}"> 	
      				<span onclick="editPost(${BeanPost.id})" class="w3-button" id="bEditPost">■</span>
      			</c:if>  
    		</c:otherwise>
		</c:choose>
      	
        <h2  class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i> ${BeanPost.title}  ||  ${BeanPost.interest} </h2>

        <div class="w3-container">
          <h5 class="w3-opacity"><b>${BeanPost.content}</b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>${BeanPost.eventTime} <span class="w3-tag w3-teal w3-round">  ${BeanPost.place} </span></h6>
           <span class="fake-link"  style="text-decoration: underline; color:blue;" onclick="showProfile(this)">${BeanPost.author}</span>  posted ${BeanPost.time}
            <jsp:include page="ViewLikes.jsp" ><jsp:param name="postId" value="${BeanPost.id}"/></jsp:include>


            <hr>
        </div>
        </div>
        
      	</c:forEach>
            <c:forEach items="${userList}" var="BeanUser">
                <div id="post${BeanUser.user}}">
                    <h2  class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i> ${BeanUser.profilename}</h2>
                    <div class="w3-container">
                        <h5 class="w3-opacity"><b>${BeanUser.user}</b></h5>
                        <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>${BeanUser.profilename} <span class="w3-tag w3-teal w3-round">  ${BeanUser.mail} </span></h6>
                        <span class="fake-link"  style="text-decoration: underline; color:blue;" onclick="showProfile(this)">${BeanUser.phoneNumber}</span>  USER -> ${BeanUser.user}
                        <hr>
                    </div>

                </div>

            </c:forEach>
     
        </div>
      </div>
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->




	<div id="user_post" style="display:none;">
        <h2  id="user_post_title" class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i></h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b  id="user_post_content"></b></h5>
          <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>time<span class="w3-tag w3-teal w3-round">  ${post.place} </span></h6>
          <p> <span class="fake-link" style="text-decoration: underline color:blue">name </span> posted this at </p>
          <hr>
        </div>
     </div>
        
        
	<script>
	
	function sendButton(event){
		
		$('#wrapper').load('MainController',{content:event.innerHTML});
		
	}
	
	
	function showProfile(event){		

		
		url ="http://localhost:8080/finalProject/UserProfileController"
		$("#userProfile").show();
	
		
		me = "";
		if (document.getElementById("user_name")) {
			me = document.getElementById("user_name").innerText;
		}
	
		if (event.innerHTML === me || me === "")
			document.getElementById("followbutoon").style.display="none";
		else 
			{document.getElementById("followbutoon").style.display="inline";}
		$.post(url,{user1:me, content:event.innerHTML},
			function(response){

			document.getElementById('profileposts').innerHTML = '';
		
			a = JSON.parse(response)
			
			
			var usarname = document.getElementById("labe_username").innerHTML= a[0].username;


			if (a[1].description=="null")
				var description = document.getElementById("labe_description").innerHTML= "";
			else
				var description = document.getElementById("labe_description").innerHTML= a[1].description;
			
				if(a[2].url !="null")
					var url = document.getElementById("user_profile").src= a[2].url;
				else 
					var url = document.getElementById("user_profile").src= "images/profile.png";
				
			
				var i;
				for (i = 0; i < a[3].length; i++) { 
				
					
					var div = document.getElementById('user_post');
				    clone = div.cloneNode(true); // true means clone all childNodes and all event handlers
					clone.id = "post"+a[3][i][0].id+ +a[3][i][0].author;
					
					clone.style.display="block";
					clone.children[1].children[0].children[0].innerHTML = a[3][i][0].content;
		
					clone.children[0].innerHTML += a[3][i][0].title+"   ||  "+a[3][i][0].interest;
					
					clone.children[1].children[1].innerHTML=clone.children[1].children[1].innerHTML.replace("time",a[3][i][0].eventime+" ");
					clone.children[1].children[1].children[1].innerHTML = a[3][i][0].place;
					clone.children[1].children[2].children[0].innerHTML = a[3][i][0].author;
					clone.children[1].children[2].innerHTML += a[3][i][0].time;

					document.getElementById('profileposts').appendChild(clone);
				}
				
				
				if (a[4].isFollowing=="true")
					document.getElementById("followbutoon").innerHTML= "Following";
			}
		);		
	}
	
	function deletePost(id) {
		$('#wrapper').load('DeletePostController',{postId: id})
	}
	
	function editPost(id) {
		postide = "post" + id + "}";
		a = document.getElementById(postide);
		
		// Obtenim el titol
		title = a.children[2].innerText.split('|')[0];
		// Obtenim el contingut
		content = a.children[3].children[0].innerText;
		
		document.getElementById("idPost").innerText = id;
		document.getElementById("titlePost").innerText = title;
		document.getElementById("contentPost").innerText = content;
		$('#post_modal').show();
	}
	
	  
	  buttontest = document.getElementById("followbutoon");
	  realvalue ="";

	  	buttontest.addEventListener("mouseover", function( event ){
	  		if (buttontest.innerText=="Following"){
	  		realvalue = buttontest.innerText;
	  	  	buttontest.innerText="Unfollow";
	  	  	}
	  	    setTimeout(function() {
	  	 
	  	    }, 500);
	  	  }, false);
	  	
  		buttontest.addEventListener("mouseout", function( event ){
  			realvalue = buttontest.innerText;
  			if (buttontest.innerText=="Unfollow"){
  		  		realvalue = buttontest.innerText;
  		  	  	buttontest.innerText="Following";
  		  	  	}
	  	    setTimeout(function(){     
	  	    }, 500);
	  	  }, false);
	</script>
</body>

</html>



