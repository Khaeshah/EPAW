package controllers;

import models.BeanPost;
import models.BeanUser;
import utils.PostUtils;
import utils.Querys;
import utils.UserUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



/**
 * Servlet implementation class MainController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // test branch
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<BeanPost> postList = new ArrayList<BeanPost>();
        List<BeanUser> userList = new ArrayList<BeanUser>();
        String searchQuery = (String)request.getParameter("search_input");

   
        PrintWriter out = response.getWriter();
   
      	System.out.println(Querys.getAllPostInterest(searchQuery));
        Gson gson = new Gson();
      
        try {
            if(!searchQuery.equals("")){
            	
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                userList = UserUtils.getUsersLike(searchQuery);
                
                String jsonList = gson.toJson(postList);
                String jsonUser = gson.toJson(userList);

                out.println("["+jsonList+","+jsonUser+"]");
                
           
            }
        }catch (Exception e){
            e.printStackTrace();
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
