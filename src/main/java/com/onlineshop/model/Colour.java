package com.onlineshop.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;



@Entity
//@Proxy(lazy = false)
public class Colour {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long colourId;
	
	@Column
	private String colourName;

	@Column(length = 1000000000)
	private byte [] colourMainPhoto;
	
	@Column(length = 1000000000)
	private String colourMainPhotoString;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany( cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Photos> colourPhotos;
	
	
	
	public Set<Photos> getColourPhotos() {
		return colourPhotos;
	}

	public void setColourPhotos(Set<Photos> colourPhotos) {
		this.colourPhotos = colourPhotos;
	}

	public byte[] getColourMainPhoto() {
		return colourMainPhoto;
	}

	public void setColourMainPhoto(byte[] colourMainPhoto) {
		this.colourMainPhoto = colourMainPhoto;
	}

	public String getColourMainPhotoString() {
		return colourMainPhotoString;
	}

	public void setColourMainPhotoString(String colourMainPhotoString) {
		this.colourMainPhotoString = colourMainPhotoString;
	}

	public Long getColourId() {
		return colourId;
	}

	public void setColourId(Long colourId) {
		this.colourId = colourId;
	}

	public String getColourName() {
		return colourName;
	}

	public void setColourName(String colourName) {
		this.colourName = colourName;
	}
	
	
}
