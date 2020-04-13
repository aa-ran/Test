package org.kh.product.view;

import java.util.ArrayList;
import java.util.Scanner;

import org.kh.product.controller.PruductController;
import org.kh.product.model.vo.Product;

public class ProductMenu {

	private Scanner sc;
	private PruductController pController;

	public ProductMenu() {
		sc = new Scanner(System.in);
		pController = new PruductController();
	}

	public void Mainmenu() {

		do {
			System.out.println("─────[제품관리 프로그램]────");
			// C R U D (게시판 읽어오고, 수정하고, 삭제하고, 검색하는 것 )
			// Create, Read, Update, Delete
			System.out.println("1.제품정보 전체조회");
			System.out.println("2.제품 이름으로 검색 ");
			System.out.println("3.제품등록");
			System.out.println("4.제품정보 수정");
			System.out.println("5.제품정보삭제");
			System.out.println("0.프로그램 종료");
			System.out.print("선택 > ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				pController.selectAll();
				break;
			case 2:
				pController.selectOne(this.selectProductName());
				break;
			case 3:
				pController.insertProduct(this.inputProduct());
				break;
			case 4:
				pController.updateProduct(this.modifyProduct());
				break;
			case 5:
				pController.deleteProduct(this.selectProductName());
				break;
			case 0:
				System.out.println("정말 종료하시겠습니까? (y/n)");
				
				if(sc.next().charAt(0) == 'y') {
					System.out.println("시스템을 종료합니다.");
					return;
				}else {
					System.out.println("메뉴를 다시 선택해주시기 바랍니다.");
				}
			}
		} while (true);
	}
	
	public void displayProductList(ArrayList<Product>list) {
		System.out.println("조회된 전체 제품 정보입니다.");
		System.out.println("제품 아이디 / 제품이름 /  제품 가격  / 기타정보");
		for(Product product : list) {
			System.out.println(product.toString());
		}
	}
	
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : " + message);
	}
	
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 처리 성공 : " + message);
		
	}
	
	public void displayProduct(Product product) {
		System.out.println(product.toString());
	}
	
	public String selectProductName() {
		System.out.print("제품명 > ");
		return sc.next();
	}
	
	public Product inputProduct() {
		Product product = new Product();
		
		System.out.print("제품 아이디 >");
		product.setpId(sc.next());
		System.out.print("제품 이름 > ");
		product.setPtName(sc.next());
		System.out.print("제품 가격 > ");
		product.setPrice(sc.nextInt());
		System.out.print("기타정보 > ");
		product.setdescription(sc.next());
		return product;
	}
	
	public Product modifyProduct() {
		Product product = new Product();
		System.out.println("수정할 제품 정보를 입력하세요.");
		System.out.print("변경할 제품 이름 > ");
		product.setPtName(sc.next());
		
		System.out.print("제품 아이디>");
		product.setpId(sc.next());
		System.out.print("제품 가격 > ");
		product.setPrice(sc.nextInt());
		System.out.print("제품 정보 > ");
		product.setdescription(sc.next());
		return product;
	}
	
}
