package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.beans.Product;

public interface IProductService {
	Product getProductDetails(int Product_Code);
	boolean insertSalesDetails(Product product);
}
