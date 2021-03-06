package utils;

public class Querys {

    public Querys(){}

    public static String getUsersQuery(){
        return "SELECT id, username, mail, password, description, phoneNumber FROM User;";
    }

    public static String getUserQueryFromName(String username){
    	return "SELECT * FROM User WHERE username = '" + username + "';";
    }

    public static String getUsersLikeQuery(String name){
        return "SELECT * FROM User WHERE username like '%" + name + "%';";
    }
    
    public static String getUserQueryFromEmail(String mail){
    	return "SELECT id, mail, username, password, description, phoneNumber FROM User WHERE mail = '" + mail + "';";
    }
    
    public static String getUserQueryFromEmailAndUsername(String username, String mail){
    	return "SELECT id, mail, username, password, description, phoneNumber FROM User WHERE mail = '" + mail + "' OR username = '" + username + "'";
    }
    
    public static String getUserQueryFromUsernameAndPassword(String username, String password){
    	return "SELECT id, mail, username, password, description, phoneNumber FROM User WHERE password = '" + password + "' AND username = '" + username + "'";
    }

    public static String insertUserQuery(String username, String mail, String password){
        return "INSERT INTO User VALUES (null, '" + username + "','" + mail + "','" + password + "', null, null, null, FALSE, '"+username+"');";
    }

    public static String insertUserQuery(String username, String mail, String description, String password){
        return "INSERT INTO User VALUES (null, '" + username + "','" + mail + "','" + password + "', '"+ description +"', null, null, FALSE, '"+username+"');";
    }

    public static String insertUserQuery(String username, String mail, String password, String description, String phoneNumber){
        return "INSERT INTO User VALUES (null, '" + username + "','" + mail + "','" + password + "', '"+ description +"', '" + phoneNumber + "', null, FALSE, '"+username+"');";
    }
    
    //update user 
    
    public static String UpdateUserFromName(String username, String url, String description, String newUsername){
    	return "UPDATE user SET profilename ='"+newUsername+"', url ='"+url+"', description ='"+description+"' WHERE username ='"+username+"';";
    }
    public static String UpdateUserFromNameFull(String username, String url, String description, String newUsername){
    	return "UPDATE user SET profilename ='"+newUsername+"', authorname = '" + newUsername + "', url ='"+url+"', description ='"+description+"' WHERE username ='"+username+"';";
    }
    

    //follow 
    public static String insertFollow(String user1 , String user2){
        return "INSERT INTO follow VALUES ('"+ user1 + "','"+user2+"');";
    }
    
    public static String checkFollow(String user1 , String user2){
    	return "SELECT * FROM follow WHERE user1 = '"+ user1 +"' and user2 = '"+user2+"';";
    }

    // update post
    
    public static String updatePostFromId(Integer id, String title, String content, String date){
    	return "UPDATE post SET title = '"+ title +"', content ='" + content + "', time = '"+ date +"' WHERE id ='" + id +"';";
    }
    
    public static String editPostsUsernameFromUser(String oldUsername, String newUsername){
    	return "UPDATE post SET author = '"+ newUsername + "' WHERE author ='" + oldUsername +"';";
    }    
    
    // post 
    public static String insertPost(String author, String title, String content, String eventTime, String place, String time, String interest, Boolean is_public){
        return "INSERT INTO Post (author, title, content, eventTime, place, time, interest, is_public) VALUES ('"+ author + "', '" + title + "','" + content + "','"+ eventTime+ "','"+place+"','"+time+"','"+ interest+ "'," + is_public +");";
    }
    
    public static String getPostsQueryFromName(String Username){
        return "SELECT * FROM Post where author = '"+ Username +  "' ";
    }
    
    public static String getAllPosts(){
        return "SELECT * FROM Post ORDER BY time DESC;";
    }
    
    public static String getPost(Integer id){
        return "SELECT * FROM Post WHERE id = '" + id + "';";
    }
    public static String getAllPublicPosts(){
        return "SELECT * FROM Post WHERE is_public = true ORDER BY time DESC;";
    }
    
    public static String getAllPostInterest(String interest){
    	  return "SELECT * FROM Post where interest = '"+interest+"' ORDER BY time DESC;";
    }

    public static String getAllPostFromContentLike(String content){
        return "SELECT * FROM Post where content like '%"+ content +"%' or author like '%"+ content +"%' or interest like '%"+ content +"%' or title like '%"+ content +"%' ORDER BY time DESC;";
    }

    public static String getAllPublicPostInterest(String interest){
        return "SELECT * FROM Post where interest = '"+interest+"' ORDER BY time DESC;";
    }
    
    public static String  getAllPostsByFollow(String follower){

        return "SELECT * FROM Post where author in (SELECT user2 FROM follow where user1 = '"+follower+"');";
    }


    // Deletes

    public static String deleteUser(String user){
        return "DELETE FROM User WHERE username = '" + user +"';";
    }

    public static String deletePost(Integer id){
        return "DELETE FROM Post WHERE id = "+ id +";";
    }

    public static String deletePostsFromUser(String userToDelete){
        return "DELETE FROM Post WHERE author = '"+ userToDelete +"';";
    }
    
    public static String deleteFollow(String user1 , String user2){
        return "DELETE FROM follow WHERE user1 = '"+ user1 +"' and user2 = '"+user2+"';";
    }

    public static String getCurrentPostLikes(Integer postId) {
        return "SELECT likes FROM Post WHERE id = " + postId + ";";
    }

    public static String updatePostLikes (Integer postId, String likes){
        return "UPDATE Post SET likes = '" + likes + "' WHERE id = " + postId + ";";
    }
}