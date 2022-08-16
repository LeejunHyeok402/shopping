package ddit.class1.shopping.sign;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.join.CustomerVO;

public class SignDAO {
    private static SignDAO instance = new SignDAO();
    public static SignDAO getInstance() {
        return instance;
    }
    private SignDAO() {}

    private JdbcTemplate template = ShoppingApplication.getTemplate();

    public CustomerVO findCusId(CustomerVO vo) {
        try {
            return template.queryForObject("SELECT CUS_NO, CUS_ID, CUS_PW, CUS_NM, CUS_ADDR, CUS_MAIL, CUS_PH FROM CUSTOMER WHERE CUS_ID = ? AND CUS_PW = ?", new BeanPropertyRowMapper<>(CustomerVO.class), vo.getCusId(), vo.getCusPw());
        } catch (DataAccessException e) {
            return null;
        }
    }
}