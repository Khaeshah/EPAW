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
 * Servlet implementation class MenuController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	
		String user = "";
		
		if(session.getAttribute("user") != null ){
			user = session.getAttribute("user").toString();
		}
		
		LocalDateTime localDateTime = LocalDateTime.now();
		String  time = localDateTime.toString().replace("T", " ").replace(".", " ");
		String splitedtime[] = time.split(" ");
		if (splitedtime.length > 1)
			time = splitedtime[0]+ " " +splitedtime[1];
		
		BeanPost post= new BeanPost();
		post.setAuthor(user);
		post.setTime(time);
		RequestDispatcher dispatcher = null;
		post.setLikes(0);
	
		
		   try {
				
			   BeanUtils.populate(post, request.getParameterMap());
			   dispatcher = request.getRequestDispatcher("ViewPostDone.jsp");
			   
			   if (post.isComplete()) {
				  
				   PostUtils.insertPost(
				   		post.getAuthor(),
						   post.getTitle(),
						   post.getContent(),
						   post.getEventTime(),
						   post.getPlace(),
						   post.getLikes(),
						   post.getTime(),
						   post.getInterest(),
						   post.getIs_public());
				   //System.out.println(Querys.insertPost(post.getAuthor(),post.getTitle(),post.getContent(),post.getEventTime(),post.getPlace(), post.getTime(), post.getInterest()));
				   request.setAttribute("post",post);
				   dispatcher.forward(request, response);
			   } 
	
		   } catch (Exception exception) {
			   		dispatcher = request.getRequestDispatcher("ViewPostModal.jsp");
			   		request.setAttribute("post",post);
			   		exception.printStackTrace();
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
