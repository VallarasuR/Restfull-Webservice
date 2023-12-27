package net.uniq.SpringbootCrudOperation.exception;


import java.util.Date;




public class ExceptionResponse
{
	
	private Date timestamp;
	private String message;
	private String discription;
	
    public ExceptionResponse(Date timestamp, String message, String discription) 
    {
		this.discription=discription;
		this.message=message;
		this.timestamp=timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", discription=" + discription
				+ "]";
	}
    
    
    
    

}
