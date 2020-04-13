package org.kh.product.controller;

import java.util.ArrayList;

import org.kh.product.medel.dao.ProductDao;
import org.kh.product.model.vo.Product;
import org.kh.product.view.ProductMenu;

public class PruductController {
	public PruductController() {
	}
	
	public void selectAll() {
		ProductMenu menu = new ProductMenu();
		ArrayList<Product>list = new ProductDao().selectAll();
		
		if(!list.isEmpty()) {
			menu.displayProductList(list);
		}else {
			menu.displayError("제품 조회 실패");
		}
	}
	
	public void selectOne(String pId) {
		ProductMenu menu = new ProductMenu();
		Product product = new ProductDao().selectOne(pId);
		
		if(product != null) {
			menu.displayProduct(product);
		}else {
			menu.displayError(pId + "해당 제품 정보 조회 실패 ");
		}
	}
	
	public void insertProduct(Product product) {
		ProductMenu menu = new ProductMenu();
		int result = new ProductDao().insertProduct(product);
		
		if(result > 0) {
			menu.displaySuccess("제품 등록이 성공했습니다.");
		}else {
			menu.displayError("제품등록 실패");
		}
	}
	
	public void updateProduct(Product product) {
		ProductMenu menu = new ProductMenu();
		int result = new ProductDao().updateProduct(product);
		
		if(result > 0) {
			menu.displaySuccess("제품 정보가 변경되었습니다.");
		}else {
			menu.displayError("제품 정보 변경 실패");
		}
	}
	
	public void deleteProduct(String pName) {
		ProductMenu menu = new ProductMenu();
		int result = new ProductDao().deleteProduct(pName);
		
		if(result > 0) {
			menu.displaySuccess("제품 삭제를 성공했습니다.");
		}else {
			menu.displayError("제품 삭제 실패");
		}
	}
}
