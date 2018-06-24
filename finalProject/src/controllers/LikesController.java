package controllers;

import com.sun.org.apache.xpath.internal.operations.Bool;
import utils.PostUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/LikesController")
public class LikesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LikesController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> params = request.getParameterMap();
        Integer postId = params.containsKey("submitLikeHide") ? Integer.parseInt(params.get("submitLikeHide")[0]) : null;
        Boolean addLike = params.containsKey("addLike") && Boolean.parseBoolean(params.get("addLike")[0]);
        Integer likes = null;
        try {
            likes = PostUtils.getCurrentPostLikes(postId, addLike);

        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("currentLikes",likes);
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