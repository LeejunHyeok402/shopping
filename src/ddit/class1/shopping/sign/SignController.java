package ddit.class1.shopping.sign;

import ddit.class1.shopping.ShoppingApplication; 
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.join.CustomerVO;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();

    public static CustomerVO session = ShoppingApplication.getSession();

    public CustomerVO signIn(CustomerVO vo) {
        CustomerVO custom = service.findUser(vo);
        if (custom == null) {
            return null;
        }
        session.setCusNo(custom.getCusNo());
        session.setCusId(custom.getCusId());
        session.setCusNm(custom.getCusNm());
        return custom;
    }
    public int signOut() {
        // 세션 초기화
        session.invalidate();
        return HomeMenu.HOME.getMenu();
    }
}