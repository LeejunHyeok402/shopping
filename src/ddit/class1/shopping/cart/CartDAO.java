package ddit.class1.shopping.cart;

import ddit.class1.shopping.ShoppingApplication;  
import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CartDAO {
	private static CartDAO instance = new CartDAO();
	public static CartDAO getInstance() {
		return instance;
	}
	private CartDAO() {}

	private JdbcTemplate template = ShoppingApplication.getTemplate();


	// selectCartList -> 로그인한 사용자의 장바구니 리스트를 보여주세요
	public List<CartVO> selectCartList(int cusNo) {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT  C.CART_NO");
		builder.append("     ,   C.PROD_NO");
		builder.append("     ,   C.CUS_NO");
		builder.append("     ,   P.PROD_NM");
		builder.append("     ,   P.PROD_COL");
		builder.append("     ,   P.PROD_SIZE");
		builder.append("     ,   C.PUR_QTY");
		builder.append("     ,   P.PROD_PRI*C.PUR_QTY as total");
		builder.append(" FROM CART C, PROD P");
		builder.append(" WHERE C.PROD_NO = P.PROD_NO AND C.PUR_DT IS NULL AND C.CUS_NO = ?");
		return template.query(builder.toString(), new BeanPropertyRowMapper<>(CartVO.class), cusNo);
	}
	// selectCart -> 로그인한 사용자의 장바구니 1건
	public CartVO selectCart(int cartNo) {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT  C.CART_NO");
		builder.append("     ,   C.PROD_NO");
		builder.append("     ,   C.CUS_NO");
		builder.append("     ,   P.PROD_NM");
		builder.append("     ,   P.PROD_COL");
		builder.append("     ,   P.PROD_SIZE");
		builder.append("     ,   P.PROD_PRI");
		builder.append(" FROM CART C, PROD P");
		builder.append(" WHERE C.PROD_NO = P.PROD_NO AND C.CART_NO = ?");
		return template.queryForObject(builder.toString(), new BeanPropertyRowMapper<>(CartVO.class), cartNo);
	}

	// 구매내역
	public List<CartVO> selectPurchaseList(int cusNo) {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT  C.CART_NO");
		builder.append("     ,   C.PROD_NO");
		builder.append("     ,   C.CUS_NO");
		builder.append("     ,   P.PROD_NM");
		builder.append("     ,   P.PROD_COL");
		builder.append("     ,   P.PROD_SIZE");
		builder.append("     ,   P.PROD_PRI");
		builder.append("     ,   SUM(C.PUR_QTY*P.PROD_PRI) TOTAL");
		builder.append(" FROM CART C, PROD P");
		builder.append(" WHERE C.PROD_NO = P.PROD_NO AND C.CUS_NO = ? AND C.PUR_DT IS NOT NULL");
		builder.append(" GROUP BY C.CART_NO, C.PROD_NO, C.CUS_NO, P.PROD_NM, P.PROD_COL, P.PROD_SIZE, P.PROD_PRI");
		return template.query(builder.toString(), new BeanPropertyRowMapper<>(CartVO.class), cusNo);
	}
	//관리자주문내역
	   public List<CartVO> selectPurList(String cusNm) {
	      StringBuilder builder = new StringBuilder();
	      builder.append(" select c.cus_nm ");
	      builder.append("      , c.cus_addr ");
	      builder.append("      , ca.pur_qty ");
	      builder.append("      , p.prod_nm ");
	      builder.append("      , p.prod_col ");
	      builder.append("      , p.prod_size ");
	      builder.append("      , p.prod_pri ");
	      builder.append("      , p.prod_pri  * ca.pur_qty as sum_pri");
	      builder.append(" from customer c, cart ca, prod p");
	      builder.append(" where c.cus_no = ca.cus_no");
	      builder.append(" and ca.prod_no = p.prod_no");
	      builder.append(" and c.cus_Nm  like '%' || ? || '%'");
	      builder.append(" and ca.pur_dt is not null ");
	      return template.query(builder.toString(), new BeanPropertyRowMapper<>(CartVO.class), cusNm);
	   }
	public int deleteCartList(int cartNo) {
		StringBuilder builder = new StringBuilder();
		String query = " DELETE FROM CART WHERE CART_NO = ?";
		return template.update(query, cartNo);
	}

	public int addToCart(CartVO vo) {
		return template.update("INSERT INTO CART (CART_NO, PROD_NO, CUS_NO, PUR_QTY) VALUES (prod_seq.nextVal, ?, ?, ?)", vo.getProdNo(), vo.getCusNo(), vo.getPurQty());
	}

	//결제 : 장바구니의 날짜가 null이면 sysdate로 변경 (sysdate 값이 들어간 장바구니 컬럼은 구매목록임)
	public int paymentCart(int cusNo) {
		return template.update("UPDATE CART SET PUR_DT = SYSDATE WHERE CUS_NO = ? AND PUR_DT IS NULL",cusNo);
	}

}
