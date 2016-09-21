package controllers.responseservices;

public class ResponseRegisterUser{

	private Message message;
	private Boolean result;
	private String  token;
	
	public ResponseRegisterUser(Message message, Boolean result, String token) {
		this.message = message;
		this.result  = result;
		this.token   = token;
	}

	public ResponseRegisterUser() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	
}
