package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;
import models.BeanPost;
import models.BeanUser;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BeanPost> postList = new ArrayList<BeanPost>();
		
		HttpSession session = request.getSession();
		
		String content ="";
		
	
		content =  (String)request.getParameter("content");
		
		String username = null;
		BeanUser user = null;
		ResultSet user_db = null;
		
		try {
			
				if(session.getAttribute("user")!=null)
					username = (String) session.getAttribute("user");
					user = new BeanUser();
					user_db = UserUtils.getUser(username);
					while (user_db.next()){
						
						user.setUser(user_db.getString("username"));
						user.setMail((user_db.getString("mail")));
						user.setPassword(user_db.getString("password"));
						user.setUrl(user_db.getString("url"));
						user.setDescription(user_db.getString("description"));
						user.setIs_admin(user_db.getInt("is_admin"));
						user.setPhoneNumber(user_db.getString("is_admin"));
						user.setProfilename(user_db.getString("profilename"));
					}
	
					ResultSet allPosts = null;
					
					if(content!=null && !content.isEmpty() && content.equals("Subscription")){
						allPosts = PostUtils.getAllPostsByFollow(username);
						System.out.println(Querys.getAllPostsByFollow(username));
					}
					else {
						
						allPosts = PostUtils.getAllPosts();
						
					}
					
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
			
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("postList",postList);
		request.setAttribute("userinfo",user);
		dispatcher.forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
