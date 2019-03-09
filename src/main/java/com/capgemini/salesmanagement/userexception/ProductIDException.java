package com.capgemini.salesmanagement.userexception;

@SuppressWarnings("serial")
public class ProductIDException extends Exception {
	public ProductIDException() {
		System.out.println("Product ID ia not valid");
	}
}
