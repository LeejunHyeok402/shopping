package ddit.class1.shopping;

import oracle.jdbc.pool.OracleDataSource;   
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import ddit.class1.shopping.join.CustomerVO;
import ddit.class1.shopping.man.ManVO;
import ddit.class1.shopping.cart.CartVO;

import java.sql.SQLException;

public class ShoppingApplication {
    private static CustomerVO session = new CustomerVO();
    private static ManVO sessionMan = new ManVO();
    private static JdbcTemplate template = new JdbcTemplate();
    private static CartVO delete = new CartVO();
    private static CartVO session2 = new CartVO();
    
    public static void main(String[] args) {
        new Home().initialize();
    }
    public static CartVO getCartSession() {
    	return session2;
    }
    public static CartVO getDelete() {
    	return delete;
    }
    public static CustomerVO getSession() {
        return session;
    }
    public static ManVO getManSession() {
        return sessionMan;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@192.168.142.8:1521:xe");
            dataSource.setUser("shopping");
            dataSource.setPassword("java");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
