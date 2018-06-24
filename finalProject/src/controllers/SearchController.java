package controllers;

import models.BeanPost;
import models.BeanUser;
import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



/**
 * Servlet implementation class MainController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // test branch
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<BeanPost> postList = new ArrayList<BeanPost>();
        List<BeanUser> userList = new ArrayList<BeanUser>();
        String searchQuery = (String)request.getParameter("search_input");
        String checkboxTweets = (String)request.getParameter("checkboxTweets");
        String checkboxUsers = (String)request.getParameter("checkboxUsers");
   
        PrintWriter out = response.getWriter();
        
   
        Gson gson = new Gson();
      
        
        try {
            if(!searchQuery.equals("") && !checkboxTweets.equals("true") && !checkboxUsers.equals("true")){
                //postList = PostUtils.getAllPostFromContentLike(searchQuery);
                userList = UserUtils.getUsersLike(searchQuery);
                
                
                ResultSet allPosts = null;
				
		
                allPosts = PostUtils.getAllPosts();
					
                
            	while (allPosts.next()){

					BeanPost post = new BeanPost();
					post.setId(allPosts.getInt("id"));
					post.setAuthor(allPosts.getString("author"));
					post.setTitle(allPosts.getString("title"));
					post.setContent(allPosts.getString("content"));
					post.setEventTime(allPosts.getString("eventTime").replace("T", " "));
					post.setPlace(allPosts.getString("place"));
					post.setLikes(allPosts.getString("likes"));
					post.setTime(allPosts.getString("time"));
					post.setInterest(allPosts.getString("interest"));
					post.setIs_public(allPosts.getBoolean("is_public"));
					
					postList.add(post);
				}


                String jsonList = gson.toJson(postList);
                
                System.out.println(jsonList+"asdsa");
                String jsonUser = gson.toJson(userList);
         /*       
                String element = gson.toJson(
                		postList, new TypeToken<ArrayList<BeanPost>>() {}.getType());
                String element2 = gson.toJson(
                		userList, new TypeToken<ArrayList<BeanUser>>() {}.getType());
       */         
                out.println(jsonList);
                
            }else if(!searchQuery.equals("") && !checkboxTweets.equals("true") && !checkboxUsers.equals("false")){
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                if(!postList.isEmpty()) {
                	  String jsonList = gson.toJson(postList);
                      out.println(jsonList);
                      System.out.println("caso2");
                	
                }
            }else if(!searchQuery.equals("") && !checkboxTweets.equals("false") && !checkboxUsers.equals("true")){
                userList = UserUtils.getUsersLike(searchQuery);
                if (!userList.isEmpty()){
                	
                	  String jsonList = gson.toJson(userList);
                	  System.out.println("caso3");
                      out.println(jsonList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
