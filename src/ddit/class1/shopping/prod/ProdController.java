package ddit.class1.shopping.prod;

import java.util.List;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.cart.CartService;
import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.join.CustomerVO;

public class ProdController {
	private static ProdController instance = new ProdController();
	public static ProdController getInstance() {
		return instance;
	}
	private ProdController() {}

	private ProdService service = ProdService.getInstance();

	public List<ProdVO> selectProdList(String searchWord) {
		return service.findAll(searchWord);
	}
	public int deleteProdDelete(int prodNo) {
		return service.prodDelete(prodNo);
	}

	public int prodInsert(ProdVO vo) {

		try {
			if(service.prodInsert(vo) == 1) {
				return HomeMenu.MAN_MANU.getMenu();
			}
		} catch (Exception e) {
			System.out.println("알수 없는 오류가 발생하였습니다");
			return HomeMenu.MAN_MANU.getMenu();
		}
		return HomeMenu.MAN_MANU.getMenu();
	}
	
	public int paymentProd() {
		CustomerVO session = ShoppingApplication.getSession();
		return service.paymentProd(session.getCusNo());
	}
}
