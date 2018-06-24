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
import java.util.List;
import java.util.Map;

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

        Map<String, String[]> params = request.getParameterMap();
        List<BeanPost> postList;
        List<BeanUser> userList;

        String searchQuery = params.containsKey("search") ? !params.get("search")[0].equals("") ? params.get("search")[0] : null : null;
        String checkboxTweets = params.containsKey("checkboxTweets") ? params.get("checkboxTweets")[0] : null;
        String checkboxUsers = params.containsKey("checkboxUsers") ? params.get("checkboxUsers")[0] : null;

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            if(searchQuery != null && checkboxTweets != null && checkboxUsers != null){
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                userList = UserUtils.getUsersLike(searchQuery);
                request.setAttribute("postList",postList);
                request.setAttribute("userList",userList);
            }else if(searchQuery != null && checkboxTweets != null && checkboxUsers == null){
                postList = PostUtils.getAllPostFromContentLike(searchQuery);
                if(!postList.isEmpty()) {
                    request.setAttribute("postList",postList);
                }
            }else if(searchQuery != null && checkboxTweets == null && checkboxUsers != null){
                userList = UserUtils.getUsersLike(searchQuery);
                if (!userList.isEmpty()){
                    request.setAttribute("userList",userList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       
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
