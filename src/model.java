import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class model {
Connection conn = null;
    public void databaseConector(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DatabaseLoginData.DBURL + ":" + DatabaseLoginData.port + "/" + DatabaseLoginData.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    DatabaseLoginData.user, DatabaseLoginData.password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
