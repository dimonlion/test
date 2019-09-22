package com.onlineshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
//@Proxy(lazy = false)
public class Photos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long photoId;
	
	@Column(length = Integer.MAX_VALUE)
	private byte [] photoData;
	
	@Column(length = Integer.MAX_VALUE)
	private String photoDataString;

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public byte[] getPhotoData() {
		return photoData;
	}

	public void setPhotoData(byte[] photoData) {
		this.photoData = photoData;
	}

	public String getPhotoDataString() {
		return photoDataString;
	}

	public void setPhotoDataString(String photoDataString) {
		this.photoDataString = photoDataString;
	}
	
	
}
