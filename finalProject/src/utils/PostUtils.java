package utils;

import models.BeanPost;
import models.DAO;

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
    
    public static ResultSet getPost(Integer id) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getPost(id));
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
            post.setLikes(result.getInt("likes"));
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
    
   
 
    public static ResultSet getAllPostsByFollow(String follower) throws Exception {
    	DAO dao = new DAO();
    	result = dao.executeSQL((Querys.getAllPostsByFollow(follower)));
    	return result;
    }	
    
    public static void insertPost(String author, String title,  String content , String eventTime, String place, Integer likes, String time, String interest, Boolean isPublic) throws Exception {
    		DAO dao = new DAO();
   	     	dao.execute(Querys.insertPost(author,title,content,eventTime,place,likes, time,interest, isPublic));
    }
    
    public static void UpdatePostFromId(Integer id, String title, String content, String date) throws Exception {
    	DAO dao = new DAO();    	
    	dao.execute((Querys.UpdatePostFromId(id,title,content,date)));
    	
    }
    
}