package ddit.class1.shopping.cart;

import java.util.List; 

import ddit.class1.shopping.join.CustomerVO;

public class CartService {
	private static CartService instance = new CartService();
	public static CartService getInstance() {
		return instance;
	}
	private CartService() {}

	private CartDAO cartDAO = CartDAO.getInstance();

	// selectCartList -> 로그인한 사용자의 장바구니 리스트를 보여주세요
	public List<CartVO> selectCartList(int cusNo) {
		return cartDAO.selectCartList(cusNo);
	}
	//관리자 주문내역
	   public List<CartVO> selectPurList(String cusNm) {
	      return cartDAO.selectPurList(cusNm);
	   }
	// selectCart -> 로그인한 사용자의 장바구니 1건
	public CartVO selectCart(int cartNo) {
		return cartDAO.selectCart(cartNo);
	}
	public List<CartVO> selectPurchaseList(int cusNo) {
		return cartDAO.selectPurchaseList(cusNo);
	}

	public int deleteCartList(int cartNo) {
		return cartDAO.deleteCartList(cartNo);
	}

	public int addToCart(CartVO vo) {
		return cartDAO.addToCart(vo);
	}

	//결제 
	public int paymentCart(int cusNo) {
		return cartDAO.paymentCart(cusNo);
	}
}