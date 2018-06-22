package controllers;

import java.io.IOException;
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
import utils.PostUtils;

/**
 * Servlet implementation class DeletePostController
 */
@WebServlet("/DeletePostController")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		Integer id = Integer.parseInt(request.getParameter("postId").toString());
		//if(session.getAttribute("id") != null ){
			//id = Integer.parseInt(session.getAttribute("id").toString());
		//}
		
		
		/*BeanPost post= new BeanPost();
		post.setAuthor(user);
		post.setTime(time);
		RequestDispatcher dispatcher = null;
		post.setLikes(0);*/
	
		RequestDispatcher dispatcher = null;
		   try {
			   
			   //BeanUtils.populate(post, request.getParameterMap());
			   dispatcher = request.getRequestDispatcher("index.jsp");
			   
			   if(id != -1) PostUtils.deletePost(id);
			   
			   request.setAttribute("id",id);
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
