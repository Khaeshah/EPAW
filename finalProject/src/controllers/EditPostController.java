package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import models.BeanPost;
import models.BeanUser;
import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;

/**
 * Servlet implementation class DeletePostController
 */
@WebServlet("/EditPostController")
public class EditPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Id of the post to be edited
		//Integer id = Integer.parseInt(request.getParameter("postId").toString());
		BeanPost post = new BeanPost();
		HttpSession session = request.getSession();
		//String oldusername = (String) session.getAttribute("user");
		//String title = request.getParameter("title").toString();
		//String content = request.getParameter("content").toString();
		
		RequestDispatcher dispatcher = null;
		   try {
			   BeanUtils.populate(post, request.getParameterMap());
			   PostUtils.UpdatePostFromId(post.getId(),post.getTitle(),post.getContent());
			   //UserUtils.UpdateUserFromName(oldusername,user.getUrl(), user.getDescription(), user.getUser());
			   //ResultSet post_db = PostUtils.getPost(id);
			   //while (post_db.next()){
				   /*
					user.setUser(user_db.getString("username"));
					user.setMail((user_db.getString("mail")));
					user.setPassword(user_db.getString("password"));
					user.setUrl(user_db.getString("url"));
					user.setDescription(user_db.getString("description"));
					user.setIs_admin(user_db.getInt("is_admin"));
					user.setPhoneNumber(user_db.getString("is_admin"));
					user.setProfilename(user_db.getString("profilename"));
					*/
			   //}
				   	

			   
			   
			   //TODO UPDATEPOST
			   //if(id != -1) PostUtils.updatePost(id,title,content);

			   dispatcher = request.getRequestDispatcher("index.jsp");
			   //dispatcher = request.getRequestDispatcher("ViewDeleteDone.jsp");
			   //request.setAttribute("id",id);
			   // revisar que pasa al index
			   request.setAttribute("post",post);
			   dispatcher.forward(request, response);
		   
	
		   } catch (Exception exception) {
					if(dispatcher != null){
						dispatcher.forward(request, response);
					}

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
