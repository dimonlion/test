package com.onlineshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MailForDelivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mailId;
	
	@Column
	private String mailPerson;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Long getMailId() {
		return mailId;
	}

	public void setMailId(Long mailId) {
		this.mailId = mailId;
	}

	public String getMailPerson() {
		return mailPerson;
	}

	public void setMailPerson(String mailPerson) {
		this.mailPerson = mailPerson;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
