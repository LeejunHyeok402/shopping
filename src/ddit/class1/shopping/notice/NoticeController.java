package ddit.class1.shopping.notice;

import java.util.List;

import ddit.class1.shopping.common.HomeMenu;
import ddit.class1.shopping.prod.ProdVO;

public class NoticeController {
    private static NoticeController instance = new NoticeController();
    public static NoticeController getInstance() {
        return instance;
    }
    private NoticeController() {}

    private NoticeService service = NoticeService.getInstance();

    public List<NoticeVO> selectNoticeList(String searchWord) {
        return service.findAll(searchWord);
    }
    public int noticeInsert(NoticeVO vo) {
        
 	   try {
 	                  if(service.noticeInsert(vo) == 1) {
 	            return HomeMenu.MAN_MANU.getMenu();
 	            }
 	         } catch (Exception e) {
 	            System.out.println("알수 없는 오류가 발생하였습니다");
 	            return HomeMenu.MAN_MANU.getMenu();
 	      }
 	      return HomeMenu.MAN_MANU.getMenu();
 	   }
    public int noticeDelete(int noticeNo) {
    	return service.noticeDelete(noticeNo);
    }
}