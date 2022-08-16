package ddit.class1.shopping;

import ddit.class1.shopping.cart.CartController; 
import ddit.class1.shopping.common.HomeMenu; 
import ddit.class1.shopping.common.MenuNotFoundException;
import ddit.class1.shopping.join.JoinController;
import ddit.class1.shopping.man.ManController;
import ddit.class1.shopping.notice.NoticeController;
import ddit.class1.shopping.prod.ProdController;
import ddit.class1.shopping.review.ReviewController;
import ddit.class1.shopping.sign.SignController;

public class Home {
	private JoinController joinController = JoinController.getInstance();
	private ProdController prodController = ProdController.getInstance();
	private SignController signController = SignController.getInstance();
	private CartController cartController = CartController.getInstance();
	private NoticeController noticeController = NoticeController.getInstance();
	private ManController manController = ManController.getInstance();
	private ShoppingView view = ShoppingView.getInstance();
	   private ReviewController reviewController = ReviewController.getInstance();

	public void initialize() {
		home(view.init());
	}
	private void home(int number) {
		loop:
			while (true) {
				try {
					HomeMenu menu = HomeMenu.findMenu(number);
					System.out.print(menu.getMenuString());
					switch (menu) {
					case HOME:
					case MAIN:
					case CUSTOMER:
					case CUSTOMER_MODIFY_INFO:
					case MAN_REV_MANAGEMENT:
					case CART2:
					case PROD2:
					case MYPAGE:
						number = view.getMenu();
						break;
					
					case PROD:
						number = view.getProdList(prodController);
						break;
					case MAN_PROD_MANAGEMENT:
					case MAN_NOTICE_MANAGEMENT:
					case MAN_MANU:
						number = view.getMenu();
						break;                    
					case LOGIN_MAN:
						number = view.Manlogin(manController);
						break;
					case MAN_PROD_INSERT:
						number = view.prodInsert(prodController);
						break;
					case MAN_PROD_DELETE:
						number = view.getProdDelete(prodController);
						break;
					case MAN_NOTI_INSERT:
						number = view.noticeInsert(noticeController);
						break;
					case MAN_NOTI_DELETE:
						number = view.getNoticeDelete(noticeController);
						break;
					case JOIN:
						number = view.join(joinController);
						break;
					case LOGIN:
						number = view.login(signController);
						break;
					case LOGOUT:
						number = signController.signOut();
						break;

					case PROD_SEARCH:
						number = view.getProdSearch(prodController);
						break;
					case NOTICE_LIST:
						number = view.getNoticeList(noticeController);
						break;
					case PURCHASE_LIST:
						number = view.getPurchaseList(cartController);
						break;
					case CUSTOMER_INFO:
						number = view.getCustomerInfo(joinController);
						break;
					case MODIFY_NAME:
					case MODIFY_ADDRESS:
					case MODIFY_PHONE:
						number = view.modifyInfo(joinController, menu);
						break;
					case CUSTOMER_MODIFY_PASSWORD:
						number = view.changePassword(joinController);
						break;
					case CART:
						number = view.getCartList(cartController);
						break;
					case PAYMENT:
						number = view.paymentProd(prodController);
						break;
					case PAYSYS:
						number = view.paymentCart(cartController);
						break;
					case DELETE_CART_PROD:
						number = view.getDeleteList(cartController);
						break;
					case ADD_TO_CART:
						number = view.getAddToCart(cartController, prodController);
						break;
					case MAN_REV_DELETE:
						number = view.getDeleteReview(reviewController);
						break;
					case REVIEW_LIST:
						number = view.getReviewList(reviewController);
						break;
					case WRITE_A_REVIEW:
						number = view.getWriteAReview(cartController, reviewController);
						break;
					case MAN_CART_PAYMENT:
		                  number = view.getSelectPurList(cartController);
		                  break;
					case QUIT:
						break loop;
					}
				} catch (MenuNotFoundException e) {
					System.out.println(e.getMessage());
					System.out.print(HomeMenu.HOME.getMenuString());
				}
				System.out.println();


			}
	}
}