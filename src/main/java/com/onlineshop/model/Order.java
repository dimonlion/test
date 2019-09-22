package com.onlineshop.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name = "Orders", //
uniqueConstraints = { @UniqueConstraint(columnNames = "Order_Num") })
public class Order implements Serializable {
 
    private static final long serialVersionUID = -2576670215015463100L;
 
    private Long id;
    private Date orderDate;
    private Long orderNum;
    private Double amount;
 
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID", length = 50)
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
  
    @Column(name = "Order_Date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }
 
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
 
    @Column(name = "Order_Num", nullable = false)
    public Long getOrderNum() {
        return orderNum;
    }
 
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
 
    @Column(name = "Amount", nullable = false)
    public Double getAmount() {
        return amount;
    }
 
    public void setAmount(Double amount) {
        this.amount = amount;
    }
 
    @Column(name = "Customer_Name", length = 255, nullable = false)
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    @Column(name = "Customer_Address", length = 255, nullable = false)
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
 
    @Column(name = "Customer_Email", length = 128, nullable = false)
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
    @Column(name = "Customer_Phone", length = 128, nullable = false)
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
}