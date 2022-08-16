package ddit.class1.shopping.review;

import java.util.List;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.cart.CartService;
import ddit.class1.shopping.cart.CartVO;
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.join.CustomerVO;
import ddit.class1.shopping.prod.ProdController;
import ddit.class1.shopping.prod.ProdService;
import ddit.class1.shopping.prod.ProdVO;

public class ReviewController {
    private static ReviewController instance = new ReviewController();
    public static ReviewController getInstance() {
        return instance;
    }
    private ReviewController() {}
    private ReviewService service = ReviewService.getInstance();

    //장바구니 출력
    public List<ReviewVO> selectReviewList(String  searchWord) {
        return service.findAll(searchWord);
    }
    
   // session은 현재 로그인한 사용자
    // selectReviewList -> 로그인한 사용자의 리뷰 리스트를 보여주세요
    private ReviewService reviewService = ReviewService.getInstance();

   // selectReview -> 삭제할 대상 1건
   public ReviewVO selectReview(int revNo) {
      return reviewService.selectReview(revNo);
   }
   //사용자가 입력한 리뷰목록 N건
    public List<ReviewVO> selectCusIdReview(String cusId) {
       return reviewService.selectCusIdReview(cusId);
    }
   // 리뷰 삭제
    public int deleteReviewList(int revNo) {
       return reviewService.deleteReviewList(revNo);
    }
    
   // 리뷰 작성
   public int writeAReview(ReviewVO vo) {
      try {
         if (ReviewService.writeAReview(vo) == 1) {
            return HomeMenu.PROD.getMenu();
         }
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("리뷰 작성 실패.. ᴛ.ᴛ");
         return HomeMenu.PROD.getMenu();
      }
      return HomeMenu.PROD.getMenu();
   }

    
}