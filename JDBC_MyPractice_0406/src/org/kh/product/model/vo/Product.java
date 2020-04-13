package org.kh.product.model.vo;

public class Product {
	private String pId;
	private String ptName;
	private int price;
	private String description;
	
	public Product() {
	}
	public Product(String pId, String ptName, int price, String description) {
		super();
		this.pId = pId;
		this.ptName = ptName;
		this.price = price;
		this.description = description;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getPtName() {
		return ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.pId + "," + this.ptName + "," + this.price + "원," + this.description;
	}
}
