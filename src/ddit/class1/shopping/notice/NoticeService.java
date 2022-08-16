package ddit.class1.shopping.notice;

import java.util.List;

import ddit.class1.shopping.prod.ProdVO;

public class NoticeService {
    private static NoticeService instance = new NoticeService();
    public static NoticeService getInstance() {
        return instance;
    }
    private NoticeService() {}

    private NoticeDAO dao = NoticeDAO.getInstance();

    public List<NoticeVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
    }

    public NoticeVO findByNoticeNo(int noticeNo) {
        return dao.findByNoticeNo(noticeNo);
    }
    public int noticeInsert(NoticeVO vo) {
        return dao.noticeInsert(vo);
     }
    public int noticeDelete(int prodNo) {
    	return dao.noticeDelete(prodNo);
    }
}