package com.capgemini.salesmanagement;

import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;
import com.capgemini.salesmanagement.userexception.ProductIDException;
import com.capgemini.salesmanagement.userexception.QuauntityException;

/**
 * Hello world!
 *
 */
public class App 
{
	static Product product =new Product();
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
        System.out.println( "enter the choice" );
        
        System.out.println("1.Prodct info \n 2. Calculate total cost for each product based on quantity "
        		+ "\n 3. Store the sales details and display the final Bill");
        	Scanner sc=new Scanner(System.in);
        	System.out.println("enter product code");
        	int productCode=sc.nextInt();
        	System.out.println("enter the quantity");
        	int quantity=sc.nextInt();
        	
        	if(quantity>0){
        	IProductService iProductService =new ProductService();
        	
          product =	iProductService.getProductDetails(productCode);
          if(product!=null){
        	  product.setQuantity(quantity);
        	  System.out.println("Product Code: "+product.getProduct_code());
        	  System.out.println("Product Name: "+product.getProduct_name());
        	  System.out.println("Product Category: "+product.getProduct_category());
        	  System.out.println("Product Description: "+product.getProduct_description());
        	  System.out.println("Line Total(Rs.): "+product.getProduct_price());
        	  System.out.println(product.getQuantity());
        	boolean b=  iProductService.insertSalesDetails(product);
        	  if(b==true){
            	  System.out.println(product.getProduct_price()*product.getQuantity());
              }
          }
          else{
        	 try {
				throw new ProductIDException();
			} catch (ProductIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
        	}
        	else{
        		try {
					throw new QuauntityException();
				} catch (QuauntityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        		sc.close();
        }
    }
