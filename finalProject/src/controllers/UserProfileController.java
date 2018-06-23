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

import org.json.JSONArray;
import org.json.JSONObject;

import utils.HtmlUtils;
import utils.PostUtils;
import utils.Querys;
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
			String allpost ="";
			
			StringBuilder stringBuilder = new StringBuilder();

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
					stringBuilder.append("[");
					
		
					while (allPosts.next()){
				
						
						stringBuilder.append("[{");
						stringBuilder.append("\"id\""+":\""+allPosts.getInt("id")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"author\""+":\""+allPosts.getString("author")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"title\""+":\""+allPosts.getString("title")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"content\""+":\""+allPosts.getString("content")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"eventime\""+":\""+allPosts.getString("eventTime").replace("T", " ")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"place\""+":\""+allPosts.getString("place")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"likes\""+":\""+allPosts.getInt("likes")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"time\""+":\""+allPosts.getString("time")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"interest\""+":\""+allPosts.getString("interest")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"is_public\""+":\""+allPosts.getBoolean("is_public")+"\"");
						stringBuilder.append("}],");
					
						//json.put("id",allPosts.getInt("id"));
						//json.put("author",allPosts.getString("author"));
						//json.put("title",allPosts.getString("title"));
						//json.put("eventime",allPosts.getString("eventTime").replace("T", " "));
						//json.put("place",allPosts.getString("place"));
						//json.put("likes",allPosts.getInt("likes"));
						//json.put("time",allPosts.getString("time"));
						//json.put("interest",allPosts.getString("interest"));
						//json.put("is_public",allPosts.getBoolean("is_public"));
						
					
						
					}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			String finalString = stringBuilder.toString();
			if (finalString.endsWith(",")) {
				finalString = finalString.substring(0, finalString.length() - 1);
				}
			finalString = finalString+ "]";
			
			out.println("[{\"username\":\""+user.getProfilename()+"\"},{\"description\":\""+user.getDescription()+"\"},{\"url\":\""+user.getUrl()+"\"},"+finalString+"]");

		
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
