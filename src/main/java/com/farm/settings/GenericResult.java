
package com.farm.settings;


public class GenericResult {
	private boolean isSuccess;
	private String msg;
	private String status;
	private Integer statusCode;
	private Object data;
	private Object error;

	/**
	 * @param isSuccess
	 * @param msg
	 * @param status
	 * @param statusCode
	 * @param data
	 * @param error
	 */
	public GenericResult(boolean isSuccess, String msg, String status, Integer statusCode, Object data, Object error) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.error = error;
	}

	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the error
	 */
	public Object getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Object error) {
		this.error = error;
	}

}
