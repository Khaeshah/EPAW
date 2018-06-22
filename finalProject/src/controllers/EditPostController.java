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
import utils.Querys;

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
		Integer id = Integer.parseInt(request.getParameter("postId").toString());
		String title = request.getParameter("title").toString();
		String content = request.getParameter("content").toString();

		RequestDispatcher dispatcher = null;
		   try {
			   
			   // We can reuse the delete view
			   dispatcher = request.getRequestDispatcher("ViewDeleteDone.jsp");
			   //System.out.println(Querys.deletePost(id));
			   
			   
			   TODO UPDATEPOST
			   if(id != -1) PostUtils.updatePost(id,title,content);

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
