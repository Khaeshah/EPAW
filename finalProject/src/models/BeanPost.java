package models;

import java.io.Serializable;


public class BeanPost implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id = 0;
	private String author = "";
	private String title = "";
	private String content = "";
	private String place = "";
	private String eventime= "";
	private String interest= "";


	private int likes = 0;
	private String postime ="";
	
	/* Logic Functions */
	


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public String getEventime() {
		return eventime;
	}

	public void setEventime(String eventime) {
		this.eventime = eventime;
	}

	public String getPostime() {
		return postime;
	}

	public void setPostime(String postime) {
		this.postime = postime;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	/*Check if all the fields are filled correctly */
	public boolean isComplete() {
	    return(hasValue(getAuthor()) &&
	           hasValue(getContent()));
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
}


