
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
