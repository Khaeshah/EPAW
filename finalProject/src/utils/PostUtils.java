package utils;

import models.DAO;

import java.sql.ResultSet;

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
        result = dao.executeSQL(Querys.gettAllPostInterest(interest));
        return result;
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
    public static void insertPost(String author, String title,  String content , String eventime, String place, String postime, String insterest) throws Exception {
    
    		DAO dao = new DAO();
   	     	dao.execute(Querys.insertPost(author,title,content,eventime,place,postime,insterest));

    }
    
}