package ddit.class1.shopping.notice;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.prod.ProdVO;

import java.util.List;

public class NoticeDAO {
    private static NoticeDAO instance = new NoticeDAO();
    public static NoticeDAO getInstance() {
        return instance;
    }
    private NoticeDAO() {}

    private JdbcTemplate template = ShoppingApplication.getTemplate();

    public List<NoticeVO> findAll(String searchWord) { 
        return template.query("select Noti_no,noti_cont,noti_date,noti_title from notice ", new BeanPropertyRowMapper<>(NoticeVO.class));
    }
    public NoticeVO findByNoticeNo(int noticeNo) { 
        return template.queryForObject("SELECT Noti_no,noti_cont,noti_date,noti_title FROM PROD WHERE PROD_NO = ?", new BeanPropertyRowMapper<>(NoticeVO.class), noticeNo);
    }
    public int noticeInsert(NoticeVO vo) {
        return template.update("INSERT INTO NOTICE (NOTI_NO, NOTI_CONT,NOTI_TITLE,MAN_NO) VALUES (NOTICE_seq.nextVal, ?, ?, 1)", vo.getNotiCont(), vo.getNotiTitle());
    }
    public int noticeDelete(int noticeNo) {
    	return template.update("delete from NOTICE where NOTI_no = ?", noticeNo);
    }
}