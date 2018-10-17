package entity;

import java.io.Serializable;


/**
 * 返回结果封装
 * @author Mindy
 *
 */
public class Result implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3859394503550346799L;

	private boolean success; 
	
	private String message;
	
	

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
	
	

}
