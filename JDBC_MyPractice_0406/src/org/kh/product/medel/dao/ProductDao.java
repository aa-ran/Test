package org.kh.product.medel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.kh.product.model.vo.Product;

public class ProductDao {
	public ProductDao() {
	}

	public ArrayList<Product> selectAll() {
		ArrayList<Product> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM PRODUCT";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "product", "product");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Product>();

			while (rset.next()) {
				Product product = new Product();
				product.setpId(rset.getString("PRODUCT_ID"));
				product.setPtName(rset.getString("P_NAME"));
				product.setPrice(rset.getInt("PRICE"));
				product.setdescription(rset.getString("DESCRIPTION"));
				list.add(product);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Product selectOne(String pName) {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM PRODUCT WHERE P_NAME LIKE '%'||?||'%'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "product", "product");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pName);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				product = new Product();
				product.setpId(rset.getString("PRODUCT_ID"));
				product.setPtName(rset.getString("P_NAME"));
				product.setPrice(rset.getInt("PRICE"));
				product.setdescription(rset.getString("DESCRIPTION"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	public int insertProduct(Product product) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO PRODUCT VALUES(?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "product", "product");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getpId());
			pstmt.setString(2, product.getPtName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getdescription());
			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int updateProduct(Product product) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE PRODUCT SET PRODUCT_ID = ?, PRICE = ?, DESCRIPTION = ? WHERE P_NAME = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "product", "product");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, product.getpId());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getdescription());
			pstmt.setString(4, product.getPtName());
			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteProduct(String pName) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM PRODUCT WHERE P_NAME = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "product", "product");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pName);
			result = pstmt.executeUpdate();

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
