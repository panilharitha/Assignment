package pwc.com.au.assignment.dto.addressbook;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ObjectResponse implements Serializable {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = -4880979420548255420L;
	private String message;
	private HttpStatus status;


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ObjectCreateResponse [message=" + message + ", status=" + status + "]";
	}

}
