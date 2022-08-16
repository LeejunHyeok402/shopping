package ddit.class1.shopping.cart;

import ddit.class1.shopping.Home; 
import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.join.CustomerVO;

import java.security.Provider.Service;
import java.util.List;

public class CartController {
	private static CartController instance = new CartController();
	//카트 정보를 가져올 세션
	private CartVO session2 = ShoppingApplication.getCartSession();

	public static CartController getInstance() {
		return instance;
	}

	private CartController() {
	}

	private CartService cartService = CartService.getInstance();

	// session은 현재 로그인한 사용자

	// selectCartList -> 로그인한 사용자의 장바구니 리스트를 보여주세요
	public List<CartVO> selectCartList() {
		CustomerVO session = ShoppingApplication.getSession();
		return cartService.selectCartList(session.getCusNo());
	}
	   public List<CartVO> selectPurList(String cusNm) {
		      return cartService.selectPurList(cusNm);
		   }
	//구매 내역
	public List<CartVO> selectPurchaseList() {
		CustomerVO session = ShoppingApplication.getSession();
		return cartService.selectPurchaseList(session.getCusNo());
	}

	// selectCart -> 로그인한 사용자의 장바구니 1건
	public CartVO selectCart(int cartNo) {
		return cartService.selectCart(cartNo);
	}

	//장바구니 삭제
	public int deleteCartList(int cartNo) {
		//		CartVO delete = ShoppingApplication.getDelete();
		return cartService.deleteCartList(cartNo);
	}
	// 장바구니 추가
	public int addToCart(CartVO vo) {
		try {
			if (cartService.addToCart(vo) == 1) {
				return HomeMenu.PROD2.getMenu();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 담기 실패 ᴛ.ᴛ");
			return HomeMenu.PROD2.getMenu();
		}
		return HomeMenu.PROD2.getMenu();
	}


	public int paymentCart() {
		CustomerVO session = ShoppingApplication.getSession();
		return cartService.paymentCart(session.getCusNo());
	}
}

