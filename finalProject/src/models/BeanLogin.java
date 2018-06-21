package models;
import java.io.Serializable;
public class BeanLogin implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String user = "";
	private String password = "";
	private int[] error = {0};
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setError( int[] error ) {
		this.error= error;
	}
	
	public int[] getError() {
		return error;
	}
	
	public boolean isComplete() {
	    return(hasValue(getUser()) && hasValue(getPassword()));
	}
	
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
}