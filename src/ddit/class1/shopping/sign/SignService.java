package ddit.class1.shopping.sign;

import ddit.class1.shopping.join.CustomerVO;

public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public CustomerVO findUser(CustomerVO vo) {
        return dao.findCusId(vo);
    }
}
