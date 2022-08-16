package ddit.class1.shopping.man;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.join.CustomerVO;

public class ManController {
    private static ManController instance = new ManController();
    public static ManController getInstance() {
        return instance;
    }
    private ManController() {}

    private ManService service = ManService.getInstance();

    private ManVO sessionMan = ShoppingApplication.getManSession();

    public ManVO signIn(ManVO vo) {
        ManVO man = service.findMan(vo);
        if (man == null) {
            return null;
        }
        sessionMan.setManId(man.getManId());
        sessionMan.setManNm(man.getManNm());
        return man;
    }
    public int signOut() {
        // 세션 초기화
        sessionMan.invalidate();
        return HomeMenu.HOME.getMenu();
    }
}