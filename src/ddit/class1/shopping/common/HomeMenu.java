package ddit.class1.shopping.common;

import java.util.Scanner;

public enum HomeMenu {
    HOME(-1, "1.로그인\t9.관리자로그인\t2.회원가입\t0.프로그램 종료\n메뉴를 선택하세요: "),
    NOTICE_LIST(11,"공지사항\n"),
    QUIT(0, "프로그램을 종료합니다!\n이용해주셔서 감사합니다~\n"),
    MAIN(10, "4.온라인 샵\t8.장바구니\t21.마이페이지\t7.리뷰\t11.공지사항\t3.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    MYPAGE(21, "6.회원정보\t5.구매내역\t10.이전메뉴\t3.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요:"),
    JOIN(2, "회원가입에 필요한 정보를 입력합니다.\n"),
    PROD(4, ""),
    PROD2(51,"42.상품 검색\t43.상품담기\t8.장바구니\t10.이전메뉴\t3.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    PURCHASE_LIST(5, "구매내역\n"),
    ORDER(5, "구매내역\n"),
    CUSTOMER(6, "61.개인정보확인\t62.개인정보수정\t63.패스워드변경\t10.이전메뉴\t3.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    LOGIN(1, "아이디와 비밀번호를 입력하세요.\n"),
    LOGIN_MAN(9, "아이디와 비밀번호를 입력하세요.\n"),
    LOGOUT(3, "로그아웃 되었습니다!\n"),
    PROD_LIST(41, "상품번호\t수량\t사이즈\t색상\t가격\t상품명\n\n"),
    PROD_SEARCH(42, "검색할 상품명을 입력하세요: "),
    CUSTOMER_INFO(61, "개인정보 확인\n"),
    CUSTOMER_MODIFY_INFO(62, "621.이름\t622.주소\t623.휴대전화번호\t6.이전메뉴\n수정할 항목을 선택하세요: "),
    MODIFY_NAME(621, "이름 수정\n변경할 이름을 입력하세요: "),
    MODIFY_ADDRESS(622, "주소 수정\n변경할 주소를 입력하세요: "),
    MODIFY_PHONE(623, "휴대전화번호 수정\n변경할 휴대전화번호를 입력하세요: "),
    CUSTOMER_MODIFY_PASSWORD(63, "패스워드 변경\n변경할 패스워드를 입력하세요: "),
   MAN_MANU(91, "92.제품관리\t93.공지사항관리\t94.주문내역\t3.로그아웃\n메뉴를 선택하세요:"),
   MAN_PROD_MANAGEMENT(92,"95.제품등록\t96.제품삭제\t91.이전메뉴\n메뉴를 선택하세요:"),//이전메뉴설정
   MAN_NOTICE_MANAGEMENT(93,"13.공지사항등록\t14.공지사항삭제\t91.이전메뉴\n메뉴를 선택하세요:"),//이전메뉴설정
   MAN_PROD_INSERT(95,"제품등록창\n"),
   MAN_PROD_DELETE(96,"제품삭제창\n"),
   MAN_NOTI_INSERT(13,"공지사항등록창\n"),
   MAN_NOTI_DELETE(14,"공지사항삭제창\n"),
   MAN_CART_PAYMENT(94, ""),
   CART(8,""),
    CART2(81, "82.결제\t83.선택 상품 삭제\t10.이전메뉴\t3.로그아웃\t0.프로그램 종료\n메뉴를 선택하세요: "),
    DELETE_CART_PROD(83, ""),
   PAYMENT(82, ""),
   PAYSYS(555,""),
   ADD_TO_CART(43, ""),
   MAN_REV_MANAGEMENT(7, "71.리뷰목록\t72.리뷰등록\t73.리뷰삭제\t10.이전메뉴\n메뉴를 선택하세요:"),
   MAN_REV_DELETE(73,"리뷰삭제\n"),
   REVIEW_LIST(71,"리뷰목록\n"),
   WRITE_A_REVIEW(72, "리뷰등록\n");

	
    private final int menu;
    private final String menuString;

    HomeMenu(int menu, String menuString) {
        this.menu = menu;
        this.menuString = menuString;
    }

    public int getMenu() {
        return menu;
    }

    public String getMenuString() {
        return menuString;
    }

    public static HomeMenu findMenu(int number) throws MenuNotFoundException {
        for (HomeMenu menu: values()) {
            if (menu.getMenu() == number) {
                return menu;
            }
        }
        throw new MenuNotFoundException("선택하신 메뉴가 없습니다.");
    }
    public void display(Scanner scanner) {

    }
}