package com.cabapp.pro.dto;

import java.util.Objects;

import org.springframework.stereotype.Component;


@Component
public class EmailDetails {
   
	public EmailDetails(String recipient, String msgBody, String subject) {
		super();
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
	}
	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String recipient;
    private String msgBody;
    private String subject;
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "EmailDetails [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(msgBody, recipient, subject);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailDetails other = (EmailDetails) obj;
		return Objects.equals(msgBody, other.msgBody) && Objects.equals(recipient, other.recipient)
				&& Objects.equals(subject, other.subject);
	}
	
}
