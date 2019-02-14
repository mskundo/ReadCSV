package com.wallmart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name="Product")
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@CsvBindByName(column="Id")
	private String id;
	@CsvBindByName(column="Product Name")
	@Column
	private String productName;
	@CsvBindByName(column="Price")
	@Column
	private String price;
	@CsvBindByName(column="Amount")
	@Column
	private String quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Product(String id, String productName, String price, String quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
	
	
}
