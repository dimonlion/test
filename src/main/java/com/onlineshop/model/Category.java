package com.onlineshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
public class Category implements Comparable<Category>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column
	private String categoryName;

	@Column(length = 1000000000)
	private byte [] categoryPhoto;
	
	@Column(length = 1000000000)
	private String categoryPhotoString;
	
	
	
	public byte[] getCategoryPhoto() {
		return categoryPhoto;
	}

	public void setCategoryPhoto(byte[] categoryPhoto) {
		this.categoryPhoto = categoryPhoto;
	}

	public String getCategoryPhotoString() {
		return categoryPhotoString;
	}

	public void setCategoryPhotoString(String categoryPhotoString) {
		this.categoryPhotoString = categoryPhotoString;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public int compareTo(Category o) {
		
		return (this.categoryName).compareTo(o.categoryName);
	}
	
	
}
