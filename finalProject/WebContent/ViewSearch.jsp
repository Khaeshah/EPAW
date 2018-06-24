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


function isEmpty(a) {
    for(var prop in a) {
        if(a.hasOwnProperty(prop))
            return false;
    }
    return true;
    
}

function sendSearch(){
	$('#searchresult').show();
	
	url ="http://localhost:8080/finalProject/SearchController"

	$.post(url,{search_input:$("#search_input").val(),
			checkboxTweets:$("#checkboxTweets").is(':checked'),
			checkboxUsers:$("#checkboxUsers").is(':checked')},
			function(response){
		
			document.getElementById("notfoundimage").style.display="none";
		
			if(response){
			
			a = JSON.parse(response);
			document.getElementById('SearchPosts').innerHTML = '';
			document.getElementById('SearchUsers').innerHTML = '';
			var i,j;
			var foundcontent =0;
			for (i = 0; i < a.length; i++) { 
				if(!isEmpty(a[i])){
					
					if(i==0){
					
						for (j = 0; j < a[i].length; j++ ){
							
							
							var div = document.getElementById('user_post');
						    clone = div.cloneNode(true); // true means clone all childNodes and all event handlers
							clone.id = "searchpost"+a[i][j].id+ +a[i][j].author;
							
							clone.style.display="block";
							clone.children[1].children[0].children[0].innerHTML = a[i][j].content;
				
							clone.children[0].innerHTML += a[i][j].title+"   ||  "+a[i][j].interest;
							
							clone.children[1].children[1].innerHTML=clone.children[1].children[1].innerHTML.replace("time",a[i][j].eventime+" ");
							clone.children[1].children[1].children[1].innerHTML = a[i][j].place;
							clone.children[1].children[2].children[0].innerHTML = a[i][j].author;
							clone.children[1].children[2].innerHTML += a[i][j].time;

							document.getElementById("SearchPosts").appendChild(clone);

							
						}
					}
					else if(i==1){
						for (j = 0; j < a[i].length; j++ ){
							var div = document.getElementById("search_user");
							clone = div.cloneNode(true);
							clone.style.display="block";
							clone.children[1].children[0].innerText=a[i][j].user;
							clone.children[1].children[1].innerText=a[i][j].description;
							if(!a[i][j].hasOwnProperty("url"))
								clone.children[0].src="images/profile.png";
							else {clone.children[0].src=a[i][j].url;}
	
							document.getElementById('SearchUsers').appendChild(clone);
							
							}
					}
				}
					else if(isEmpty(a[i])&&i==0){
						
						document.getElementById("SearchPosts").innerHTML="";
						img = document.getElementById("notfoundimage");
						clone2 = img.cloneNode(true);
						clone2.style.display="block";
						document.getElementById("SearchPosts").append(clone2);
					}
					
					else if(isEmpty(a[i])&&i==1){
						
						document.getElementById("SearchUsers").innerHTML="";
						img = document.getElementById("notfoundimage");
						clone2 = img.cloneNode(true);
						clone2.style.display="block";
						document.getElementById("SearchUsers").append(clone2);
						
					}
			}
		
			}


			}
		);		
}


</script>
<body>
<div class="search-container" style="width:95%;" >
	
				<input name="search" id="search_input" class="w3-input w3-border w3-show-inline-block" type="text" style="width: 40%" placeholder="Search something">
				<button class="w3-btn w3-teal w3-border w3-show-inline-block" type="submit" onclick="sendSearch()"> <i class="fa fa-search"></i></button>
					
</div>
</body>



<div id="searchresult" class="w3-modal">

    <div class="w3-modal-content">
      
		<div class="w3-bar w3-row w3-black">
		<div class="w3-container w3-half" style="text-align:center;">
			<a class="w3-button w3-block" onclick="openTab('SearchPosts')" >Posts</a>
		 </div>
		 <div class="w3-container w3-half" >
		 	<a class="w3-button w3-block" onclick="openTab('SearchUsers')" >Users</a>
		 </div>
		  <span onclick="document.getElementById('searchresult').style.display='none'" class="w3-button w3-display-topright">&times;</span>
	
		</div>
		
		<div class="w3-container">
				<div id="SearchPosts" class="w3-container" style = "color:black;">
	
				</div>
				
				<div id="SearchUsers" class="w3-container" style="display:none">
				
				<ul class="w3-ul w3-card-4">


				</ul>
		
				</div>

		</div>
		
    </div>
  </div>

		<div  id="notfoundimage" style="display:none;">
		  <img class="image-cropper" src="https://png.icons8.com/small/1600/nothing-found.png" > 
		  <h2 class="w3-center"><font color="black">Nothing found</font></h2>
		</div>
  
  
		
	  <li id="search_user" class="w3-bar" style="display:none;">
	    <img src="images/profile.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px">
	    <div class="w3-bar-item">
	      <span class="w3-large fake-link"  style="text-decoration: underline; color:blue;" onclick="showProfile(this)"></span>
	      <span>Web Designer</span>
	    </div>
	  </li>
	  
	  



