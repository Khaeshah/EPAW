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
 * Servlet implementation class EditPostController
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
		
		BeanPost post = new BeanPost();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		   try {
			   
			   BeanUtils.populate(post, request.getParameterMap());
			   LocalDateTime localDateTime = LocalDateTime.now();
			   String  time = localDateTime.toString().replace("T", " ").replace(".", " ");
			   String splitedtime[] = time.split(" ");
			   if (splitedtime.length > 1) {
				   time = splitedtime[0]+ " " +splitedtime[1];
			   }
			   
			   PostUtils.updatePostFromId(post.getId(),post.getTitle(),post.getContent(),time);

			   dispatcher = request.getRequestDispatcher("ViewDeleteDone.jsp");
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
