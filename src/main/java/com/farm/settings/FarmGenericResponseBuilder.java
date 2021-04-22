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
package com.farm.settings;

import org.springframework.http.ResponseEntity;


public class FarmGenericResponseBuilder {

	private boolean isSuccess;
	private String msg;
	private String status;
	private Integer statusCode;
	private Object error;
	private Object data;

	/**
	 * @param isSuccess
	 */
	public FarmGenericResponseBuilder isSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
		return this;
	}

	public FarmGenericResponseBuilder msg(String msg) {
		this.msg = msg;
		return this;
	}

	public FarmGenericResponseBuilder status(String status) {
		this.status = status;
		return this;
	}

	public FarmGenericResponseBuilder statusCode(Integer statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public FarmGenericResponseBuilder error(Object error) {
		this.error = error;
		return this;
	}

	public FarmGenericResponseBuilder data(Object data) {
		this.data = data;
		return this;
	}

	public FarmGenericResponse build() {
		FarmGenericResponse response = new FarmGenericResponse();
		response.setSuccess(isSuccess);
		response.setMsg(msg);
		response.setStatusCode(statusCode);
		response.setStatus(status);
		response.setError(error);
		response.setData(data);
		return response;
	}

	public ResponseEntity<Object> entity() {
		return ResponseEntity.status(statusCode).body(build());
	}
	
	public String json() {
	    return build().toJson();
	  }
}
