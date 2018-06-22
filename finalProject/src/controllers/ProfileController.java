package controllers;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import utils.HtmlUtils;
import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;
import models.BeanPost;
import models.BeanUser;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BeanUser user = new BeanUser();
		HttpSession session = request.getSession();
		String oldusername = (String) session.getAttribute("user");
		
		try{
			
				BeanUtils.populate(user, request.getParameterMap());
				UserUtils.UpdateUserFromName(oldusername,user.getUrl(), user.getDescription(), user.getUser());
				
				
				ResultSet user_db = UserUtils.getUser(oldusername);
				while (user_db.next()){
			
				user.setUser(user_db.getString("username"));
				user.setMail((user_db.getString("mail")));
				user.setPassword(user_db.getString("password"));
				user.setUrl(user_db.getString("url"));
				user.setDescription(user_db.getString("description"));
				user.setIs_admin(user_db.getBoolean("is_admin"));
				user.setPhoneNumber(user_db.getString("is_admin"));
				user.setProfilename(user_db.getString("profilename"));
				
				}
					
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
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
