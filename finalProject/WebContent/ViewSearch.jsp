<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>



function openTab(cityName) {
	
	if(cityName=='SearchPosts'){
	    var x = document.getElementById('SearchUsers');
		x.style.display = "none";  
		document.getElementById(cityName).style.display = "block";  
	}
	else {
		
		var x = document.getElementById('SearchPosts');
		x.style.display = "none";  
		document.getElementById(cityName).style.display = "block";  
	} 
}


function sendSearch(){
	$('#searchresult').show();
	
	url ="http://localhost:8080/finalProject/SearchController"

	$.post(url,{search_input:$("#search_input").val(),checkboxTweets:$("#checkboxTweets").is(':checked'),checkboxUsers:$("#checkboxUsers").is(':checked')},
			
			function(response){

			//document.getElementById('profileposts').innerHTML = '';
			
			console.log(response);
			/*
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
				*/
			}
		);		
}


</script>
<body>
<div class="search-container" style="width:95%;" >

		
				
				<input name="search" id="search_input" class="w3-input w3-border w3-show-inline-block" type="text" style="width: 40%" placeholder="Search something">
				<button class="w3-btn w3-teal w3-border w3-show-inline-block" type="submit" onclick="sendSearch()"> <i class="fa fa-search"></i></button>
					<input name="checkboxTweets" id="checkboxTweets" class="w3-check w3-show-inline" type="checkbox">
					<label>Tweets</label>
					<input name="checkboxUsers" id="checkboxUsers" class="w3-check w3-show-inline" type="checkbox">
					<label>Users</label>
		
	
</div>
</body>



<div id="searchresult" class="w3-modal">

    <div class="w3-modal-content">
      
		<div class="w3-bar w3-row w3-black">
		<div class="w3-container w3-half" style="text-align:center;">
			<a class="w3-button w3-block" onclick="openTab('SearchPosts')" >Tweets</a>
		 </div>
		 <div class="w3-container w3-half" >
		 	<a class="w3-button w3-block" onclick="openTab('SearchUsers')" >Users</a>
		 </div>
		  <span onclick="document.getElementById('searchresult').style.display='none'" class="w3-button w3-display-topright">&times;</span>
	
		</div>
		
		<div class="w3-container">
		<div id="SearchPosts" class="w3-container" style = "color:black;">
		   <h2  class="w3-text-grey w3-padding-16"> <i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i> ${BeanUser.profilename}</h2>

                    <div class="w3-container">
                        <h5 class="w3-opacity"><b>name </b></h5>
                        <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i>name <span class="w3-tag w3-teal w3-round">  mail </span></h6>
                        <span class="fake-link"  style="text-decoration: underline; color:blue;" onclick="showProfile(this)">xiwei</span> 
                        <hr>
                    </div>
		</div>
		
		<div id="SearchUsers" class="w3-container" style="display:none">
		
			<div class="w3-row ">
			
			  <div class="w3-container w3-half">
	
				<ul class="w3-ul">
				<div>Username:</div>
		    	<li><label id="labe_username" class="w3-text-grey"></label></li>
		    	
		    	<div>Description:</div>
		    	<li><label id="labe_description" class="w3-text-grey">Description: </label></li>
		 		 </ul>
	
			  	</div>
			  	<div class="w3-container w3-half">
	
			  	<img id=user_profile class= "image-cropper" src="" >
	
			  </div>
			</div>
                   

		</div>
				
		</div>
		
    </div>
  </div>




