package ddit.class1.shopping.review;

import java.util.List;

import ddit.class1.shopping.cart.CartVO;
import ddit.class1.shopping.join.CustomerVO;
import ddit.class1.shopping.prod.ProdDAO;
import ddit.class1.shopping.prod.ProdService;
import ddit.class1.shopping.prod.ProdVO;

public class ReviewService {
    private static ReviewService instance = new ReviewService();
    public static ReviewService getInstance() {
        return instance;
    }
    private ReviewService() {}

    private static ReviewDAO dao = ReviewDAO.getInctance();

    //리뷰 전체 출력
    public List<ReviewVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
    }
    
    // selectReviewList -> 로그인한 사용자의 리뷰 리스트를 보여주세요

    // selectReview -> 로그인한 사용자의 리뷰 1건
    public ReviewVO selectReview(int revNo) {
        return dao.selectReview(revNo);
    }
    public int deleteReviewList(int revNo) {
       return dao.deleteReviewList(revNo);
    }
    public List<ReviewVO> selectCusIdReview(String cusId) {
       return dao.selectCusIdReview(cusId);
    }
    
   public static int writeAReview(ReviewVO vo) {
      return dao.writeAReview(vo);
   }
}