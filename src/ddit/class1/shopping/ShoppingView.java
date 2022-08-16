package ddit.class1.shopping;

import java.util.List; 
import java.util.Scanner;  
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.common.ScannerUtil;
import ddit.class1.shopping.join.CustomerVO;
import ddit.class1.shopping.join.JoinController;
import ddit.class1.shopping.man.ManController;
import ddit.class1.shopping.man.ManVO;
import ddit.class1.shopping.notice.NoticeController;
import ddit.class1.shopping.notice.NoticeVO;
import ddit.class1.shopping.cart.CartController;
import ddit.class1.shopping.cart.CartVO;
import ddit.class1.shopping.prod.ProdController;
import ddit.class1.shopping.prod.ProdVO;
import ddit.class1.shopping.review.ReviewController;
import ddit.class1.shopping.review.ReviewVO;
import ddit.class1.shopping.sign.SignController;
import ddit.class1.shopping.ShoppingApplication;

public class ShoppingView {
	private static ShoppingView instance = new ShoppingView();
	private ShoppingView() {}
	public static ShoppingView getInstance() {
		return instance;
	}

	private Scanner scanner = ScannerUtil.scanner();

	public int init() {
		System.out.println("동묘 온라인에 오신 것을 환영합니다!");
		System.out.print(HomeMenu.HOME.getMenuString());
		return scanner.nextInt();
	}

	public int getMenu() {
		return scanner.nextInt();
	}

	public int join(JoinController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("아이디: ");
		String cusId = scanner.nextLine();
		System.out.print("이름: ");
		String cusNm = scanner.nextLine();
		System.out.print("주소: ");
		String cusAddr = scanner.nextLine();
		System.out.print("전화번호: ");
		String cusPh = scanner.nextLine();
		System.out.print("메일: ");
		String cusMail = scanner.nextLine();
		System.out.print("패스워드: ");
		String cusPw = scanner.nextLine();
		number = controller.join(new CustomerVO(cusId, cusNm, cusAddr, cusPh,cusMail, cusPw));
		if (number == HomeMenu.HOME.getMenu()) {
			System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
		} else {
			System.out.print("회원 가입 실패! 다시 회원가입을 하시겠습니까?(y 또는 n을 입력): ");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.JOIN.getMenu();
			} else {
				number = HomeMenu.HOME.getMenu();
			}
		}
		return number;
	}
	public int login(SignController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("아이디: ");        
		String cusId = scanner.nextLine();
		System.out.print("패스워드: ");
		String cusPw = scanner.nextLine();
		CustomerVO vo = controller.signIn(new CustomerVO(cusId, cusPw));
		if (vo != null) {
			System.out.println(vo.getCusNm() + "님 로그인되었습니다.");
			number = HomeMenu.MAIN.getMenu();
		} else {
			System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	public int Manlogin(ManController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("아이디: ");        
		String manId = scanner.nextLine();
		System.out.print("패스워드: ");
		String manPw = scanner.nextLine();
		ManVO vo = controller.signIn(new ManVO(manId, manPw));
		if (vo != null) {
			System.out.println(vo.getManNm() + "님 로그인되었습니다.");
			number = HomeMenu.MAN_MANU.getMenu();
		} else {
			System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
			number = HomeMenu.HOME.getMenu();
		}
		return number;
	}

	public int getCartList(CartController cartController) {
		List<CartVO> cartVOList = cartController.selectCartList();
		System.out.printf("장바구니번호\t 상품명\t\t색상\t사이즈\t수량\t가격\n\n");
		String tap = "";
		for (CartVO cartVO : cartVOList) {
			if(cartVO.getProdNm().length()<7) {
				tap = "\t";
			}else {
				tap = "";
			}
			System.out.printf("\n %d\t \t %S\t"+tap+" %s\t %s\t%d\t %s\t\n", 
					cartVO.getCartNo(), 
					cartVO.getProdNm(), cartVO.getProdCol(), 
					cartVO.getProdSize(),cartVO.getPurQty(), cartVO.getTotal());
		}
		return HomeMenu.CART2.getMenu();

	}
	public int getProdList(ProdController controller) {
		System.out.printf("상품번호\t수량\t사이즈\t색상\t가격\t상품명\n\n");
		controller.selectProdList("").forEach(ProdVO -> {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n", ProdVO.getProdNo(), ProdVO.getProdQty(), ProdVO.getProdSize(), ProdVO.getProdCol(), ProdVO.getProdPri(), ProdVO.getProdNm());
		});
		return HomeMenu.PROD2.getMenu();
	}
	public int getProdSearch(ProdController controller) {
		// scanner의 nextInt()와 nextLine() 사이의 줄바꿈 특수문자 제거를 해줌
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		};
		String searchWord = scanner.nextLine();
		System.out.printf("상품번호\t수량\t사이즈\t색상\t가격\t상품명\n\n");
		controller.selectProdList(searchWord).forEach(ProdVO -> {
			System.out.printf("%d\t%d\t%s\t%s\t%s\t%s\n", ProdVO.getProdNo(), ProdVO.getProdQty(), ProdVO.getProdSize(), ProdVO.getProdCol(), ProdVO.getProdPri(), ProdVO.getProdNm());
		});
		return HomeMenu.PROD2.getMenu();

	}
	// 상품 삭제
	   public int getProdDelete(ProdController controller) {
	      
	      controller.selectProdList("").forEach(ProdVO -> {
	         System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n", ProdVO.getProdNo(), ProdVO.getProdQty(), ProdVO.getProdSize(),
	               ProdVO.getProdCol(), ProdVO.getProdPri(), ProdVO.getProdNm());
	      });
	      
	      if (scanner.hasNextLine()) {
	         scanner.nextLine();
	      }
	      ;
	      System.out.println("삭제할 제품번호를 입력하세요: ");
	      int prodNo = Integer.parseInt(scanner.nextLine());
	      int resultName = controller.deleteProdDelete(prodNo);
	      if (resultName == 1) {
	         System.out.println("정상적으로 삭제되었습니다.");
	      }
	      return HomeMenu.MAN_PROD_MANAGEMENT.getMenu();
	   }
	// 공지사항 삭제
	   public int getNoticeDelete(NoticeController controller) {
		   controller.selectNoticeList("").forEach(NoticeVO->{
				String tap = "";
				String tap2 = "";
				if(NoticeVO.getNotiTitle().length()<15) {
					tap = "\t";
				}else {
					tap = "";
				}
				if(NoticeVO.getNotiTitle().length()<7&&NoticeVO.getNotiTitle().length()>0) {
					tap2 = "\t";
				}else {
					tap2 = "";
				}
				
				System.out.printf("%d\t%s"+tap+tap2+"\t%s\n\t\t\t\t등록일: %s\n\n",NoticeVO.getNotiNo(),NoticeVO.getNotiTitle(),NoticeVO.getNotiCont(),NoticeVO.getNotiDate());
			});
	      if (scanner.hasNextLine()) {
	         scanner.nextLine();
	      }
	     
	      System.out.println("\n삭제할 제품번호를 입력하세요: ");
	      int noticeNo = Integer.parseInt(scanner.nextLine());
	      int resultName = controller.noticeDelete(noticeNo);
	      if (resultName == 1) {
	         System.out.println("정상적으로 삭제되었습니다.");
	      }
	      return HomeMenu.MAN_PROD_MANAGEMENT.getMenu();
	   }
	public int getNoticeList(NoticeController controller) {
		controller.selectNoticeList("").forEach(NoticeVO->{
			String tap = "";
			String tap2 = "";
			if(NoticeVO.getNotiTitle().length()<15) {
				tap = "\t";
			}else {
				tap = "";
			}
			if(NoticeVO.getNotiTitle().length()<7&&NoticeVO.getNotiTitle().length()>0) {
				tap2 = "\t";
			}else {
				tap2 = "";
			}
			
			System.out.printf("%d\t%s"+tap+tap2+"\t%s\n\t\t\t\t등록일: %s\n\n",NoticeVO.getNotiNo(),NoticeVO.getNotiTitle(),NoticeVO.getNotiCont(),NoticeVO.getNotiDate());
		});

		return HomeMenu.MAIN.getMenu();
	}
	public int getCustomerInfo(JoinController controller) {
		CustomerVO customer = controller.findCustomer();
		System.out.printf("고객번호: %d\n", customer.getCusNo());
		System.out.printf("아이디: %s\n", customer.getCusId());
		System.out.printf("이름: %s\n", customer.getCusNm());
		System.out.printf("주소: %s\n", customer.getCusAddr());
		System.out.printf("휴대전화번호: %s\n", customer.getCusPh());
		System.out.printf("메일: %s\n", customer.getCusMail());
		return HomeMenu.CUSTOMER.getMenu();
	}

	public int modifyInfo(JoinController controller, HomeMenu menu) {
		scanner.nextLine();
		int resultName = controller.modifyInfo(scanner.nextLine(), menu);
		if (resultName == 1) {
			System.out.println("정상적으로 수정되었습니다.");
		}
		return HomeMenu.CUSTOMER.getMenu();
	}

	public int changePassword(JoinController controller) {
		scanner.nextLine();
		String newPassword = scanner.nextLine();
		System.out.print("비밀번호 확인을 위해 다시 한번 입력해주세요: ");
		String confirmPassword = scanner.nextLine();
		if (newPassword.equals(confirmPassword)) {
			controller.modifyPassword(confirmPassword);
			System.out.println("비밀번호가 변경되었습니다.");
		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 변경을 취소합니다.");
		}
		return HomeMenu.CUSTOMER.getMenu();
	}
	public int prodInsert(ProdController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("제품이름: ");
		String prodNm = scanner.nextLine();
		System.out.print("제품사이즈: ");
		String prodSize = scanner.nextLine();
		System.out.print("제품색깔: ");
		String prodCol = scanner.nextLine();
		System.out.print("제품가격: ");
		int prodPri = scanner.nextInt();
		scanner.nextLine();
		System.out.print("제품수량: ");
		int prodQty = scanner.nextInt();    
		scanner.nextLine();
		number = controller.prodInsert(new ProdVO(prodNm, prodSize, prodCol, prodPri, prodQty));
		if (number == HomeMenu.MAN_MANU.getMenu()) {
			System.out.println("제품이 등록되었습니다.");
		} else {
			System.out.print("제품등록이 실패했습니다.다시등록하실경우 Y를 아닐경우 N을 입력해주세요.");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.MAN_PROD_MANAGEMENT.getMenu();
			} else {
				number = HomeMenu.MAN_MANU.getMenu();
			}
		}
		return number;
	}
	public int	noticeInsert(NoticeController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("공지사항 제목을 입력하여 주십시오(약 300자 이내): ");
		String noticeTitle = scanner.nextLine();
		System.out.print("공지사항 내용을 입력하여 주십시오(약 300자 이내): ");
		String noticeCont = scanner.nextLine();     
		number = controller.noticeInsert(new NoticeVO(noticeTitle, noticeCont));
		if (number == HomeMenu.MAN_MANU.getMenu()) {
			System.out.println("공지사항이 등록되었습니다.");
		} else {
			System.out.print("공지사항등록이 실패했습니다.다시등록하실경우 Y를 아닐경우 N을 입력해주세요.");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.MAN_PROD_MANAGEMENT.getMenu();
			} else {
				number = HomeMenu.MAN_MANU.getMenu();
			}
		}
		return number;
	}
	public int getDeleteList(CartController cartController) {
		// 장바구니 전체를 출력
		List<CartVO> cartVOList = cartController.selectCartList();
		System.out.printf("장바구니번호\t 상품명\t\t색상\t사이즈\t수량\t가격\n\n");
		String tap = "";
		for (CartVO cartVO : cartVOList) {
			if(cartVO.getProdNm().length()<7) {
				tap = "\t";
			}else {
				tap = "";
			}
			System.out.printf("\n %d\t \t %S\t"+tap+" %s\t %s\t %d\t%s\t\n", 
					cartVO.getCartNo(), 
					cartVO.getProdNm(), cartVO.getProdCol(), 
					cartVO.getProdSize(), cartVO.getPurQty(), cartVO.getTotal());
		}

		System.out.print("\n삭제할 장바구니번호를 입력해주세요: ");
		int cartNo = scanner.nextInt();
		CartVO cartVO = cartController.selectCart(cartNo);

		
		int delResult = cartController.deleteCartList(cartNo);

		System.out.println("상품이 삭제되었습니다.");

		return HomeMenu.MAIN.getMenu();
	}
	//결제 : 장바구니의 날짜가 null이면 sysdate로 변경 
	//	 (sysdate 값이 들어간 장바구니 컬럼은 구매목록임)
	public int paymentCart(CartController controller) {
		CustomerVO session = ShoppingApplication.getSession();
		int number;

		number = controller.paymentCart();
		return HomeMenu.MAIN.getMenu();
	}

	public int paymentProd(ProdController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print("결제하시겠습니까? 결제하시려면 1을 아니면 2를 입력하세요: ");
		int pay = scanner.nextInt();
		if(pay == 1) {
			number = controller.paymentProd();
			System.out.println("장바구니에 담긴 상품이 결제되었습니다.");
			return HomeMenu.PAYSYS.getMenu();
		} else if(pay == 2){
			System.out.println("결제가 취소되었습니다.");
			return  HomeMenu.MAIN.getMenu();
		} else {
			System.out.println("결제가 취소되었습니다.");
			return HomeMenu.MAIN.getMenu();
		}
	}

	public int getPurchaseList(CartController cartController) {
		List<CartVO> cartVOList = cartController.selectPurchaseList();
		int total = 0;
		String tap = "";
		String sum = "";
		System.out.printf("상품명\t\t색상\t사이즈\t상품가격\n");
		for (CartVO cartVO : cartVOList) {
			if(cartVO.getProdNm().length() < 6) {
				tap = "\t";
			}else {
				tap = "";
			}
			System.out.printf("\n%s\t"+tap+"%s\t %s\t %s\t\n",
					cartVO.getProdNm(), cartVO.getProdCol(), cartVO.getProdSize(), cartVO.getProdPri());
			total += Integer.parseInt(cartVO.getProdPri());
			sum = String.valueOf(total);
			
		}

		System.out.println("\n \t 총 구매 가격: " + sum);

		return HomeMenu.MAIN.getMenu();
	}
	//리뷰 작성
	public int getWriteAReview(CartController cartController, ReviewController reviewController) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		List<CartVO> cartVOList = cartController.selectPurchaseList();

		String sum = "";
		int prodNo = 0;
		System.out.printf("구매번호 회원번호\t상품이름\t색상\t사이즈\t상품가격\n");
		for (CartVO cartVO : cartVOList) {
			System.out.printf("\n %d\t %d\t %S\t %s\t %s\t %s\t\n", cartVO.getCartNo(), cartVO.getCusNo(),
					cartVO.getProdNm(), cartVO.getProdCol(), cartVO.getProdSize(), cartVO.getProdPri());
		}

		CustomerVO session = ShoppingApplication.getSession();

		System.out.print("리뷰를 작성할 상품의 구매번호를 입력해주세요: ");
		int cartNo = scanner.nextInt();

		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}

		System.out.print("리뷰의 제목은 무엇으로 할까요?: ");
		String revTitle = scanner.nextLine();
		System.out.print("\n리뷰의 내용을 입력해주세요: ");
		String revCont = scanner.nextLine();
		for (CartVO cartVO : cartVOList) {
			if(cartVO.getCartNo()==cartNo) {
				prodNo = cartVO.getProdNo();
			}
		}

		number = reviewController.writeAReview(new ReviewVO(cartNo, revTitle, revCont,prodNo, session.getCusNo()));
		System.out.println("리뷰가 정상 등록되었습니다 ( ´ ▽ ` )ﾉ");
		return HomeMenu.MAN_REV_MANAGEMENT.getMenu();
	}
	//리뷰 목록
	public int getReviewList(ReviewController reviewController) {
		System.out.printf("리뷰번호\t제목\t\t내용\t\t\t\t\t\t작성날짜\t\t\t\t고객이름\t\t상품명\n\n");
		reviewController.selectReviewList("").forEach(ReviewVO -> {
			String tap = "";
			String tap2 = ""; 
			if(ReviewVO.getRevTitle().length() < 6) {
				tap = "\t";
			}else {
				tap = "";
			}
			
			if(ReviewVO.getRevCont().length() < 35) {
				tap2 = "\t";
			}else {
				tap2 = "";
			}
			System.out.printf("%d\t%s"+tap+"\t%s"+tap2+"\t%s\t\t%s\t\t%s\n", ReviewVO.getRevNo(), ReviewVO.getRevTitle(),
					ReviewVO.getRevCont(), ReviewVO.getRevDt(), ReviewVO.getCusNm(), ReviewVO.getProdNm());
		});
		return HomeMenu.MAN_REV_MANAGEMENT.getMenu();
	}
	//리뷰 삭제
	public int getDeleteReview(ReviewController reviewController) {
		String cusId = SignController.session.getCusId();
		System.out.println("cusId : " + cusId);

		List<ReviewVO> reviewVOList = reviewController.selectCusIdReview(cusId);

		for (ReviewVO reviewVO : reviewVOList) {
			System.out.printf("리뷰번호\t제목\t내용\t작성날자\t장바구니번호\t상품번호\n\n");
			System.out.printf("\n %d\t\t %s\t %s\t %s\t %d\t %d\t\t\n", 
					reviewVO.getRevNo(),reviewVO.getRevTitle(), reviewVO.getRevCont(), 
					reviewVO.getRevDt(), reviewVO.getCartNo(), reviewVO.getProdNo()
					);
		}

		System.out.print("삭제할 리뷰목록를 입력해주세요: ");
		int reviewNo = scanner.nextInt();
		ReviewVO reviewVO = reviewController.selectReview(reviewNo);

		System.out.printf("\n %d\t %s\t %s\t %d\t %d\t %d\t %s\t\n", reviewVO.getRevNo(), reviewVO.getRevCont(),
				reviewVO.getRevDt(), reviewVO.getCusNo(), reviewVO.getCartNo(), reviewVO.getProdNo(),
				reviewVO.getRevTitle());

		int delResult = reviewController.deleteReviewList(reviewNo);

		System.out.println("상품이 삭제되었습니다.");

		return HomeMenu.MAIN.getMenu();
	}
	//상품 추가
	public int getAddToCart(CartController cartController, ProdController controller) {
		int number;
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}

		System.out.print("\n추가할 상품번호를 입력해주세요: ");
		CustomerVO session = ShoppingApplication.getSession();
		int prodNo = scanner.nextInt();
		System.out.print("상품수량을 입력해주세요: ");
		int purQty = scanner.nextInt();

		number = cartController.addToCart(new CartVO(prodNo, purQty, session.getCusNo()));

		if (number == HomeMenu.PROD2.getMenu()) {
			System.out.println("상품이 담겼습니다 ٩(๑❛ワ❛๑)");
		} else {
			System.out.print("상품 담기 실패했어요..ᴛ.ᴛ 다시 담을까요? 'y' OR 'n' 입력해주세요.");
			String inputFlag = scanner.nextLine();
			if (inputFlag.equalsIgnoreCase("y")) {
				number = HomeMenu.PROD2.getMenu();
			} else {
				number = HomeMenu.PROD2.getMenu();
			}
		}
		return number;
	}
	//장바구니 전체를 출력
	   public int getSelectPurList(CartController Controller) {
	      
	      List<CartVO> cartVOList = Controller.selectPurList("");
	      int sum = 0;
	      String tap = "";
	      String tap2= "";
	      String tap3 = "";
	      System.out.printf("회원이름\t상품이름\t\t\t색상\t\t        사이즈   \t\t수량      상품가격\t회원주소\n");
	      for (CartVO cartVO : cartVOList) {
	         if(cartVO.getProdNm().length() <6) {
	            tap = "\t";
	         }
	         else {
	            tap = "";
	         }
	         if(cartVO.getProdCol().length()<7) {
	            tap2 = "\t";
	         }else {
	            tap2 = "";
	         }
	         if(cartVO.getProdSize().length()+cartVO.getProdCol().length()>5) {
	            tap3 ="\t";
	         }else {
	            tap3 = "";
	         }
	         System.out.printf("\n %s\t %s\t\t"+tap+"%s\t "+tap2+"\t%s\t"+tap3+"%d\t%d\t %s\n", cartVO.getCusNm(), cartVO.getProdNm(),
	               cartVO.getProdCol(), cartVO.getProdSize(), cartVO.getPurQty(),cartVO.getSumPri(),cartVO.getCusAddr());
	         sum += cartVO.getSumPri();
	      }
	      System.out.println("\n총 매출: "+sum+"원");
	      return  HomeMenu.MAN_MANU.getMenu();
	   
	}   
}
