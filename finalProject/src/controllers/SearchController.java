package controllers;

import models.BeanPost;
import models.BeanUser;
import utils.PostUtils;
import utils.UserUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



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


        List<BeanPost> postList;
        List<BeanUser> userList;
        String searchQuery = (String)request.getParameter("search_input");
        String checkboxTweets = (String)request.getParameter("checkboxTweets");
        String checkboxUsers = (String)request.getParameter("checkboxUsers");
   
        PrintWriter out = response.getWriter();
        
        JSONObject allEmps=new JSONObject();
        /*
        Gson gson = new Gson();
        String element = gson.toJson(
                groupsList,
        new TypeToken<ArrayList<GroupItem>>() {}.getType());
        */
        try {
            if(!searchQuery.equals("") && !checkboxTweets.equals("true") && !checkboxUsers.equals("true")){
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                userList = UserUtils.getUsersLike(searchQuery);

                out.println( "hello wold");
            }else if(!searchQuery.equals("") && !checkboxTweets.equals("true") && !checkboxUsers.equals("false")){
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                if(!postList.isEmpty()) {
                	  out.println( searchQuery);
                }
            }else if(!searchQuery.equals("") && !checkboxTweets.equals("false") && !checkboxUsers.equals("true")){
                userList = UserUtils.getUsersLike(searchQuery);
                if (!userList.isEmpty()){
                	  out.println( searchQuery);
                }
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
