import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){

        try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","mystudy"
        ,"1234")){
            log.info(con);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
