package ddit.class1.shopping.review;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.cart.CartVO;
import ddit.class1.shopping.join.CustomerVO;
import ddit.class1.shopping.prod.ProdVO;

public class ReviewDAO {
   private static ReviewDAO instance = new ReviewDAO();
   public static ReviewDAO getInctance() {
      return instance;
   }
   private ReviewDAO() {}
   
   private JdbcTemplate template = ShoppingApplication.getTemplate();
   
   public List<ReviewVO> findAll(String searchWord) { 
       return template.query("SELECT  r.rev_no ,r.rev_title,r.rev_cont , R.rev_dt , C.cus_nm, CA.cart_no,P.prod_nm from review R,customer C,prod P,cart CA where C.cus_no = R.cus_no and R.cart_no =CA.cart_no and CA.prod_no = P.prod_no and p.prod_nm like '%' || ? || '%'", new BeanPropertyRowMapper<>(ReviewVO.class), searchWord);
   }

   // 삭제
   public ReviewVO findRevNo(int revNo) {  
      return template.queryForObject("select rev_no, rev_title, rev_cont, rev_dt, cus_no, cart_no, prod_no from review where rev_no = ?", new BeanPropertyRowMapper<>(ReviewVO.class), revNo);
   }

    public ReviewVO selectReview(int revNo) {  
       return template.queryForObject("SELECT "
                 + "     r.rev_no "
              + "     , r.rev_title "
                 + "     , r.rev_cont"
                 + "     , R.rev_dt"
                 + "     , C.cus_nm"
                 + "     , CA.cart_no"
                 + "     , P.prod_nm "
                 + "     from review R,customer C,prod P,cart CA where C.cus_no = R.cus_no and R.cart_no =CA.cart_no and CA.prod_no = P.prod_no and r.rev_no like '%' "
                 + " || ?"
                 + " || '%'", new BeanPropertyRowMapper<>(ReviewVO.class), revNo);
    }
    
    public List<ReviewVO> selectCusIdReview(String cusId) {  
       return template.query("SELECT "
             + "     r.rev_no "
             + "     , r.rev_title "
             + "     , r.rev_cont"
             + "     , R.rev_dt"
             + "     , C.cus_nm"
             + "     , CA.cart_no"
             + "     , P.prod_nm "
             + "     from review R,customer C,prod P,cart CA where C.cus_no = R.cus_no and R.cart_no =CA.cart_no and CA.prod_no = P.prod_no and C.cus_id = ?", new BeanPropertyRowMapper<>(ReviewVO.class), cusId);
    }
    public int insertReview(ReviewVO vo) {                                                                                             
        return template.update("INSERT INTO CUSTOMER (rev_no,rev_title, rev_cont, rev_dt, cus_no, cart_no, prod_no) VALUES (user_seq.nextVal, ?, ?, ?, ?, ?, ?)",vo.getRevTitle(), vo.getRevCont(), vo.getRevDt(), vo.getCusNo(), vo.getCartNo(), vo.getProdNo());
    }
   public int deleteReviewList(int revNo) {
     StringBuilder builder = new StringBuilder();
      String query = " DELETE FROM REVIEW WHERE REV_NO = ?";
      return template.update(query, revNo);
   }
   
   public int writeAReview(ReviewVO vo) {
       return template.update("INSERT INTO REVIEW (REV_NO, REV_CONT, CUS_NO, CART_NO, PROD_NO, REV_TITLE) VALUES (user_seq.nextVal, ?, ?, ?, ?, ?)", vo.getRevCont(), vo.getCusNo(), vo.getCartNo(), vo.getProdNo(),vo.getRevTitle());
   }

}