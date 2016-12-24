package com.nagarro.fileupload.data;

import java.util.HashSet;
import java.util.Set;



public class User {
	private int userId;
	private String userName;
	private String password;
	private Set<Image> images = new HashSet<Image>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public void addImages(Image image)
	{
		image.setUser(this);
		images.add(image);
	}



}