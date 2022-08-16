package ddit.class1.shopping.join;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;

public class JoinDAO {
    private static JoinDAO instance = new JoinDAO();
    public static JoinDAO getInstance() {
        return instance;
    }
    private JoinDAO() {}

    private JdbcTemplate template = ShoppingApplication.getTemplate();

    public CustomerVO findCustomer(String cusId) {
        return template.queryForObject("SELECT CUS_NO,CUS_ID,CUS_PW ,CUS_NM, CUS_ADDR, CUS_PH ,CUS_MAIL FROM CUSTOMER WHERE CUS_ID = ?", new BeanPropertyRowMapper<>(CustomerVO.class), cusId);
    }

    public int join(CustomerVO vo) {
        return template.update("INSERT INTO CUSTOMER (CUS_NO, CUS_ID,CUS_PW, CUS_NM, CUS_ADDR, CUS_PH, CUS_MAIL) VALUES (user_seq.nextVal, ?, ?, ?, ?, ?, ?)", vo.getCusId(), vo.getCusPw(), vo.getCusNm(), vo.getCusAddr(), vo.getCusPh(),vo.getCusMail());
    }

    public int modifyName(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET CUS_NM = ? WHERE CUS_ID = ?", vo.getCusNm(), vo.getCusId());
    }

    public int modifyAddr(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET CUS_ADDR = ? WHERE CUS_ID = ?", vo.getCusAddr(), vo.getCusId());
    }

    public int modifyPhone(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET CUS_PH = ? WHERE CUS_ID = ?", vo.getCusPh(), vo.getCusId());
    }

    public int modifyPassword(CustomerVO vo) {
        return template.update("UPDATE CUSTOMER SET CUS_PW = ? WHERE CUS_ID = ?", vo.getCusPw(), vo.getCusId());
    }
}