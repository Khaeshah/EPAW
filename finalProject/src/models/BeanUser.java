package models;

import java.io.Serializable;

import encryption.encryptionUtils;


public class BeanUser implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String user = "";
	private String mail = "";
	private String password = "";
	private String confirmPassword = "";
	private String description = "";
	private String phoneNumber = "";
	private String url = "";
	private boolean is_admin = false;
	private encryptionUtils md5 = new encryptionUtils();
	
	/*  Control which parameters have been correctly filled */
	private int[] error = {0,0}; 
	
	/* Getters */
	public String getUser(){
		return user;
	}
	
	public String getMail() {
		return mail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public int[] getError() {
		return error;
	}
	
	public void setError(int[] error) {
		this.error = error;
	}
	
	/*Setters*/
	public void setUser(String user){
		this.user=user;
		
	}
	
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public void setPassword(String password){
		this.password = md5.encrypt(password);
	}
	
	public void setConfirmPassword(String password){
		this.confirmPassword = this.password;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	
	/* Logic Functions */
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete() {
	    return(hasValue(getUser()) &&
	           hasValue(getMail()) && 
	           hasValue(getPassword())
	           && 
	           hasValue(getConfirmPassword()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
}


