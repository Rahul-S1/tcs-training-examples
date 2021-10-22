package com.tcs.streams1;

public class MobileList 
{
   private String mobilename;
   private String company;
   private double price;
   
   
   public MobileList() {
	super();
	// TODO Auto-generated constructor stub
}

public MobileList(String mobilename, String company, double price) 
   {
	super();
	this.mobilename = mobilename;
	this.company = company;
	this.price = price;
}

public String getMobilename() {
	return mobilename;
}

public void setMobilename(String mobilename) {
	this.mobilename = mobilename;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "MobileList [mobilename=" + mobilename + ", company=" + company + ", price=" + price + "]";
}


   
   
   
   
}
