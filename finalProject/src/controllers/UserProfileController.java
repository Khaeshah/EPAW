package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HtmlUtils;
import utils.PostUtils;
import utils.UserUtils;
import models.BeanPost;
import models.BeanUser;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/UserProfileController")
public class UserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String username = (String)request.getParameter("content");
			BeanUser user = null;
			ArrayList<BeanPost> postList = new ArrayList<BeanPost>();
			try {
					ResultSet user_bd = UserUtils.getUser(username);
					
					user = new BeanUser();
					
					while (user_bd.next()){
				
					user.setUser(user_bd.getString("username"));
					user.setUrl(user_bd.getString("url"));
					user.setDescription(user_bd.getString("description"));				
					user.setProfilename(user_bd.getString("profilename"));
					}
					
					ResultSet allPosts = PostUtils.getPostsFromUser(username);
					while (allPosts.next()){

						BeanPost post = new BeanPost();
						post.setId(allPosts.getInt("id"));
						post.setAuthor(allPosts.getString("author"));
						post.setTitle(allPosts.getString("title"));
						post.setContent(allPosts.getString("content"));
						post.setEventTime(allPosts.getString("eventTime").replace("T", " "));
						post.setPlace(allPosts.getString("place"));
						post.setLikes(allPosts.getInt("likes"));
						post.setTime(allPosts.getString("time"));
						post.setInterest(allPosts.getString("interest"));
						post.setIs_public(allPosts.getBoolean("is_public"));
						
						postList.add(post);
					}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			
			

			out.println("[{\"username\":\""+user.getProfilename()+"\"},{\"description\":\""+user.getDescription()+"\"},{\"url\":\""+user.getUrl()+"\"}]");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
