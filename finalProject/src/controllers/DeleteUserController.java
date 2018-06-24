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
import utils.UserUtils;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/DeleteUserController")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String userToDelete = request.getParameter("userDel").toString();

		RequestDispatcher dispatcher = null;
		   try {
			   dispatcher = request.getRequestDispatcher("ViewUserDeleteDone.jsp");
			   if(userToDelete != "") {
				   // Borrem usuari i els posts que ha fet
				   UserUtils.deleteUser(userToDelete);
				   PostUtils.deletePostsFromUser(userToDelete);
			   }
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
