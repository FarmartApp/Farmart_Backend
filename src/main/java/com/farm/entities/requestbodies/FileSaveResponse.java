/*
Copyright [2020] [Apptimus Tech (Pvt) Ltd.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * 
 */
package com.farm.entities.requestbodies;

import java.io.Serializable;


public class FileSaveResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String imageUrl;
	private String error;
	private boolean isImageValid;
	/**
	 * 
	 */
	public FileSaveResponse() {
		super();
	}
	/**
	 * @param imageUrl
	 * @param error
	 * @param isImageValid
	 */
	public FileSaveResponse(String imageUrl, String error, boolean isImageValid) {
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
