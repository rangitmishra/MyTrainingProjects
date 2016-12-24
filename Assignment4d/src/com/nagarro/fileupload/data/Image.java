/*
 * Class name: Image
 * Version info:
 * Copyright notice:
 * Author info: ranjeetmishra
 * Creation date: 02September2016
 * Last updated by: ranjeetmishra
 * Last updated date: 02September2016
 * Description: Image Class stores information of an image
 */
package com.nagarro.fileupload.data;

import java.sql.Blob;
/**
 * @author ranjeetmishra
 * @version 1.8
 * @since  2016-09-03
 */
public class Image {

	private int imageId;                                 //a unique image id to all image
	private int size;                                         //size of image
	private String imageName;                  //name of image  
	private Blob originalImage;                  //image itself
	private User user;                                    //owner of image 
	
	/**
	 * 
	 * @return int This returns unique id of image
	 */
	public int getImageId() {
		return imageId;
	}
	
	/**
	 * 
	 * @param imageId This sets a unique id of image
	 * @return void
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	
	/**
	 * 
	 * @return int This returns the sizeof an image
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 
	 * @param size This sets the size of an image
	 * @return void
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * 
	 * @return String This returns the name of an image
	 */
	public String getImageName() {
		return imageName;
	}
	
	/**
	 * 
	 * @param imageName This sets the name of an image
	 * @return void
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	/**
	 * 
	 * @return User This returns the user associated with the image
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * 
	 * @param user This sets the user associated with image
	 * @return void
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 
	 * @return Blob This returns the image itself
	 */
	public Blob getOriginalImage() {
		return originalImage;
	}
	
	/**
	 * @param originalImage This sets the image
	 * @return void
	 */
	public void setOriginalImage(Blob originalImage) {
		this.originalImage = originalImage;
	}

}
