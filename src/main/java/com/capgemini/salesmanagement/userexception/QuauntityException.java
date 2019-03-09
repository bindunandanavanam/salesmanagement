package com.capgemini.salesmanagement.userexception;

@SuppressWarnings("serial")
public class QuauntityException extends Exception {
	public QuauntityException() {
		System.out.println("Enter quantity greater than zero");
	}

}
