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
import models.BeanUser;
import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;

/**
 * Servlet implementation class DeleteUserController
 */
@WebServlet("/EditUserController")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BeanUser user = new BeanUser();
		HttpSession session = request.getSession();
		
		RequestDispatcher dispatcher = null;
		   try {

			   BeanUtils.populate(user, request.getParameterMap());			   
			   // Aprofito el camp phonenumber ja que la final no el fem servir i no hi ha temps per fer refactor
			   String oldUsername = user.getPhoneNumber().toString();
			   dispatcher = request.getRequestDispatcher("ViewUserEditDone.jsp");
			   if(user.getUser() != "") {
				   // Editem usuari amb els nous parametres
				   UserUtils.UpdateUserFromName(oldUsername,user.getUrl(), user.getDescription(), user.getUser());
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
