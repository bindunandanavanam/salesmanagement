package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.beans.Product;

public interface IProductDAO {
	Product getProductDetails(int Product_Code);
	boolean insertSalesDetails(Product product);
}
