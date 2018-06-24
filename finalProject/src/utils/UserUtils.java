package utils;

import models.BeanUser;
import models.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {
	
	private static final String USER_EMAIL_IN_DB = "User or email already in DB";
	private static ResultSet result;
	
    public static ResultSet getUsers() throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getUsersQuery());
        return result;
    }

    public static ResultSet getUser(String name) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getUserQueryFromName(name));
        return result;
    }

    public static List<BeanUser> getUsersLike(String name) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getUsersLikeQuery(name));
        List<BeanUser> userList = new ArrayList<>();

        while (result.next()){
            BeanUser user = new BeanUser();
            user.setUser(result.getString("username"));
            user.setMail(result.getString("mail"));
            //user.set(result.getString("description"));
            //user.setUser(result.getString("phoneNumber"));
            userList.add(user);
        }
        return userList;
    }
    
    public static ResultSet checkMail(String mail) throws Exception {
        DAO dao = new DAO();
        result = dao.executeSQL(Querys.getUserQueryFromEmail(mail));
        return result;
    }
    
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
    
    public static void UpdateUserFromName(String username, String url, String description, String newUsername) throws Exception {
    	DAO dao = new DAO();
    	
    	dao.execute((Querys.updateUserFromName(username, url, description , newUsername)));
    	
    }

    //follow
    
    public static void insertFollow(String user1, String user2) throws Exception {
    	DAO dao = new DAO();
    	dao.execute((Querys.insertFollow(user1,user2)));
    	
    }
    
    public static void deleteFollow(String user1, String user2) throws Exception {
    	DAO dao = new DAO();
    	dao.execute((Querys.deleteFollow(user1,user2)));
    	
    }
    public static ResultSet checkFollow(String user1, String user2) throws Exception {
    	DAO dao = new DAO();
    	result = dao.executeSQL((Querys.checkFollow(user1,user2)));
    	return result;
    }	
    
    
    public static void insertUser(String username, String mail, String password) throws Exception {
		if(!checkMailAndUsername(mail, username).next()){
			DAO dao = new DAO();
   	     	dao.execute(Querys.insertUserQuery(username,mail,password));
		}else {
        	throw new Exception(USER_EMAIL_IN_DB);
    	}
    }
}