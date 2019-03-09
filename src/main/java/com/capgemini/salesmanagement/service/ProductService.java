package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class ProductService implements IProductService {
	Product product = new Product();
	IProductDAO iProductDAO = new ProductDAO();

	public Product getProductDetails(int Product_Code) {

		product=iProductDAO.getProductDetails(Product_Code);
		return product;
	}

	public boolean insertSalesDetails(Product product) {
		boolean b=iProductDAO.insertSalesDetails(product);
		return b;
	}

}
