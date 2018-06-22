package utils;

import models.BeanPost;
import models.DAO;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostUtils {
	
	private static ResultSet result;

    public static ResultSet getPostsFromUser(String username) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getPostsQueryFromName(username));
        return result;
        
    }
    
    public static ResultSet getAllPosts() throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getAllPosts());
        return result;
    }

    public static ResultSet gettAllPostInterest(String interest) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getAllPostInterest(interest));
        return result;
    }
    
    public static List<BeanPost> getAllPostFromContentLike(String interest) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getAllPostFromContentLike(interest));

        List<BeanPost> postList = new ArrayList<>();

        while (result.next()){
            System.out.println(result.toString());
            BeanPost post = new BeanPost();
            post.setId(result.getInt("id"));
            post.setAuthor(result.getString("author"));
            post.setTitle(result.getString("title"));
            post.setContent(result.getString("content"));
            post.setEventTime(result.getString("eventTime"));
            post.setPlace(result.getString("place"));
            String likes = result.getString("likes");
            post.setLikes(likes != null ? new JSONObject(likes) : null);
            post.setTime(result.getString("time"));
            postList.add(post);
        }
        return postList;
    }

    public static ResultSet getAllPostInterest(String interest) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getAllPostInterest(interest));
        return result;
    }
    
    public static void deletePost(Integer id) throws Exception {
        DAO dao = new DAO();
    	dao.execute(Querys.deletePost(id));
    	
        //result = dao.executeSQL(Querys.deletePost(id));
        //return result;
    }
    
    /*
    private static ResultSet checkMailAndUsername(String mail, String username) throws Exception {
    	DAO dao = new DAO();
    	result = dao.executeSQL(Querys.getUserQueryFromEmailAndUsername(username, mail));
    	return result;
    }
    
    public static ResultSet checkUsernameAndPassword(String username, String password) throws Exception {
    	DAO dao = new DAO();
    	result = dao.executeSQL(Querys.getUserQueryFromUsernameAndPassword(username, password));
    	return result;
    }
    */
    public static void insertPost(String author, String title, String content , String eventTime, String place, String time, String interest, Boolean isPublic) throws Exception {
    		DAO dao = new DAO();
   	     	dao.execute(Querys.insertPost(author, title, content, eventTime, place, time, interest, isPublic));
    }
    
}