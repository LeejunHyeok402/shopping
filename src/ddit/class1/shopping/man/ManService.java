package ddit.class1.shopping.man;

public class ManService {
    private static ManService instance = new ManService();
    public static ManService getInstance() {
        return instance;
    }
    private ManService() {}

    private ManDAO dao = ManDAO.getInstance();

    public ManVO findMan(ManVO vo) {
        return dao.findManId(vo);
    }
}
