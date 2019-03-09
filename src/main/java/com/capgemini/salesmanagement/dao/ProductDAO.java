package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

import com.capgemini.salesmanagement.beans.Product;

public class ProductDAO implements IProductDAO {
	Product product=new Product();
	public Product getProductDetails(int Product_Code) {
		product.setProduct_code(Product_Code);
		int c=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from product where product_code=?");
			ps.setInt(1, product.getProduct_code());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product.setProduct_code(rs.getInt(1));
				product.setProduct_name(rs.getString(2));
				product.setProduct_category(rs.getString(3));
				product.setProduct_description(rs.getString(4));
				product.setProduct_price(rs.getInt(5));
				c=1;
			} else {
				c=0;
				
			}

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c==1)
		return product;
		else
			return null;
		
	}

	public boolean insertSalesDetails(Product product) {
		int x=0;
		Random r=new Random();
		int sales=Math.abs(r.nextInt());
		int res=product.getQuantity()*product.getProduct_price();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bindu","root","root");
			PreparedStatement ps= con.prepareStatement("insert into sales(product_code,quantity,sales_date,line_total) values(?,?,?,?)");
			//ps.setInt(1,sales);
			ps.setInt(1,product.getProduct_code() );
			ps.setInt(2, product.getQuantity());
			ps.setDate(3,Date.valueOf(LocalDate.now()));
			ps.setInt(4, res);
			System.out.println(res);
			 x=ps.executeUpdate();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if(x==1)
		return true;
		else 
			return false;

	}
	

}
