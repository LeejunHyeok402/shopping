package ddit.class1.shopping.prod;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ddit.class1.shopping.ShoppingApplication;
import ddit.class1.shopping.join.CustomerVO;

import java.util.List;

public class ProdDAO {
    private static ProdDAO instance = new ProdDAO();
    public static ProdDAO getInstance() {
        return instance;
    }
    private ProdDAO() {}

    private JdbcTemplate template = ShoppingApplication.getTemplate();

    public List<ProdVO> findAll(String searchWord) { 
        return template.query("SELECT PROD_NO,PROD_NM, PROD_SIZE, PROD_COL, PROD_PRI, PROD_QTY FROM PROD WHERE PROD_NM like '%' || ? || '%'", new BeanPropertyRowMapper<>(ProdVO.class), searchWord);
    }

    public ProdVO findByProdNo(int prodNo) { 
        return template.queryForObject("SELECT PROD_NO,PROD_NM, PROD_SIZE, PROD_COL, PROD_PRI, PROD_QTY FROM PROD WHERE PROD_NO = ?", new BeanPropertyRowMapper<>(ProdVO.class), prodNo);
    }
    
    public int prodInsert(ProdVO vo) {
    	  
        return template.update("INSERT INTO PROD (PROD_NO, PROD_NM,PROD_SIZE, PROD_COL, PROD_PRI, PROD_QTY) VALUES (prod_seq.nextVal, ?, ?, ?, ?, ?)", vo.getProdNm(), vo.getProdSize(), vo.getProdCol(), vo.getProdPri(), vo.getProdQty());
     }
    public int prodDelete(int prodNo) {
    	return template.update("delete from prod where prod_no = ?", prodNo);
    }
    //결제 (장바구니에 담긴 수량 만큼 재고 감소)
    public int paymentProd(int cusNo) {
    	return template.update("CALL PROC_UPDATE(?)",cusNo);
    }
}