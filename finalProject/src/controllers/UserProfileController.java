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
		
			String content =  (String)request.getParameter("content");
			Boolean isFollowing = false;
					
			if (content.equals("Follow")){
				String user1 =  (String)request.getParameter("user1");
				String user2 =  (String)request.getParameter("user2");
				System.out.println(Querys.insertFollow(user1, user2));
				try {
					UserUtils.insertFollow(user1,user2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter out = response.getWriter();
				out.println("{\"content\":\"Follow\"}");

			}
			else if (content.equals("Unfollow")){
				
				String user1 =  (String)request.getParameter("user1");
				String user2 =  (String)request.getParameter("user2");
				System.out.println(Querys.deleteFollow(user1, user2));
				try {
					UserUtils.deleteFollow(user1,user2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter out = response.getWriter();
				out.println("{\"content\":\"Unfollow\"}");
				
			} 
			else {
				
			
			String username = (String)request.getParameter("content");
			String myusername = (String)request.getParameter("user1");
			

			BeanUser user = null;
		
			StringBuilder stringBuilder = new StringBuilder();

			try {
					
					ResultSet follow =UserUtils.checkFollow(myusername,username);
					
					ResultSet user_bd = UserUtils.getUser(username);
					
					if (!follow.isBeforeFirst() ) {    
						isFollowing=false;
					}else {isFollowing=true;}
					
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
						stringBuilder.append("\"time\""+":\""+allPosts.getString("time")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"interest\""+":\""+allPosts.getString("interest")+"\"");
						stringBuilder.append(",");
						stringBuilder.append("\"is_public\""+":\""+allPosts.getBoolean("is_public")+"\"");
						stringBuilder.append("}],");
					

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
			
			out.println("[{\"username\":\""+user.getProfilename()+"\"},{\"description\":\""+user.getDescription()+"\"},{\"url\":\""+user.getUrl()+"\"},"+finalString+",{\"isFollowing\":\""+isFollowing+"\"}]");

		}
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
