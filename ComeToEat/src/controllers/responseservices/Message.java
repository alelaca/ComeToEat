package controllers.responseservices;

public class Message {
	
	private MessageType messageType;
	private String messageDescription;
	
	public Message(){}
	
	public Message(MessageType messageType, String messageDescription) {
		super();
		this.messageType = messageType;
		this.messageDescription = messageDescription;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}
	
	
}
