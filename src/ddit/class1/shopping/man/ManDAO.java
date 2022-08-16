package ddit.class1.shopping.man;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.join.CustomerVO;

public class ManDAO {
    private static ManDAO instance = new ManDAO();
    public static ManDAO getInstance() {
        return instance;
    }
    private ManDAO() {}

    private JdbcTemplate template = ShoppingApplication.getTemplate();

    public ManVO findManId(ManVO vo) {
        try {
            return template.queryForObject("SELECT MAN_NO, MAN_NM, MAN_ID, MAN_PW FROM MAN WHERE MAN_ID = ? AND MAN_PW = ?", new BeanPropertyRowMapper<>(ManVO.class),vo.getManId(),vo.getManPw());
        } catch (DataAccessException e) {
            return null;
        }
    }
}