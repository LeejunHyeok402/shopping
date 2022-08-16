package ddit.class1.shopping.join;

import ddit.class1.shopping.ShoppingApplication; 
import ddit.class1.shopping.common.HomeMenu;

public class JoinController {
   private static JoinController instance = new JoinController();
   public static JoinController getInstance() {
      return instance;
   }
   private JoinController() {}
   
   private JoinService service = JoinService.getInstance();
   private CustomerVO session = ShoppingApplication.getSession();
   
   public JoinController(JoinService service) {
      this.service = service;
   }
   
   public CustomerVO findCustomer() {
      return service.findCustomer(session.getCusId());
   }
   
   public int join(CustomerVO vo) {
      
   try {
                  if(service.join(vo) == 1) {
            return HomeMenu.HOME.getMenu();
            }
         } catch (Exception e) {
            System.out.println("알수 없는 오류가 발생하였습니다");
            return HomeMenu.HOME.getMenu();
      }
      return HomeMenu.HOME.getMenu();
   }
   public int modifyInfo(String modifyData, HomeMenu menu) {
      CustomerVO vo = new CustomerVO();
      vo.setCusId(session.getCusId());
      switch (menu) {
      case MODIFY_NAME:
         vo.setCusNm(modifyData);
         break;
      case MODIFY_ADDRESS:
         vo.setCusAddr(modifyData);
         break;
      case MODIFY_PHONE:
         vo.setCusPh(modifyData);
         break;
      }
      return service.modifyInfo(vo, menu);
   }
   public int modifyPassword(String password) {
      CustomerVO vo = new CustomerVO();
      vo.setCusId(session.getCusId());
      vo.setCusPw(password);
      return service.modifyPassword(vo);
   }
}