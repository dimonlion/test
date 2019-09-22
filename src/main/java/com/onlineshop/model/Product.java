package com.onlineshop.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;


//@Proxy(lazy = false)
@Entity

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column
	private String productName;
	
	@Column
	private String productCategory;
	
	@Column
	private String productMaterial;
	
	@Column(length = 3000)
	private String productDescription;
	
	@Column
	private String productSize;
	
	@Column
	private String productParameters;
	
	@Column
	private Double productPrice;
	
	@Column(length = 1000000000)
	private byte [] productPhoto;
	
	@Column(length = 1000000000)
	private String productPhotoString;
	
	@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinTable(name = "product_tocolour",joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn(name = "colour_id"))
	private List<Colour> productColours;
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public List<Colour> getProductColours() {
		return productColours;
	}
	public void setProductColours(List<Colour> productColours) {
		this.productColours = productColours;
	}
	public byte[] getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(byte[] productPhoto) {
		this.productPhoto = productPhoto;
	}
	public String getProductPhotoString() {
		return productPhotoString;
	}
	public void setProductPhotoString(String productPhotoString) {
		this.productPhotoString = productPhotoString;
	}
	
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductParameters() {
		return productParameters;
	}
	public void setProductParameters(String productParameters) {
		this.productParameters = productParameters;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public String getProductMaterial() {
		return productMaterial;
	}
	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	
}
