package ddit.class1.shopping.prod;

import java.util.List;

import ddit.class1.shopping.join.CustomerVO;

public class ProdService {
    private static ProdService instance = new ProdService();
    public static ProdService getInstance() {
        return instance;
    }
    private ProdService() {}

    private ProdDAO dao = ProdDAO.getInstance();

    public List<ProdVO> findAll(String searchWord) {
        return dao.findAll(searchWord);
    }

    public ProdVO findByProdNo(int prodNo) {
        return dao.findByProdNo(prodNo);
    }
    public int prodInsert(ProdVO vo) {
        return dao.prodInsert(vo);
     }
    public int prodDelete(int prodNo) {
    	return dao.prodDelete(prodNo);
    }
    public int paymentProd(int cusNo) {
    	return dao.paymentProd(cusNo);
    }
}