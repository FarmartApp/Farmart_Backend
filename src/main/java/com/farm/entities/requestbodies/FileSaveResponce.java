
package com.farm.entities.requestbodies;

import java.io.Serializable;


public class FileSaveResponce implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String imageUrl;
	private String error;
	private boolean isImageValid;
	/**
	 * 
	 */
	public FileSaveResponce() {
		super();
	}
	/**
	 * @param imageUrl
	 * @param error
	 * @param isImageValid
	 */
	public FileSaveResponce(String imageUrl, String error, boolean isImageValid) {
		super();
		this.imageUrl = imageUrl;
		this.error = error;
		this.isImageValid = isImageValid;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the isImageValid
	 */
	public boolean isImageValid() {
		return isImageValid;
	}
	/**
	 * @param isImageValid the isImageValid to set
	 */
	public void setImageValid(boolean isImageValid) {
		this.isImageValid = isImageValid;
	}
	
	
	

}
