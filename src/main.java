import Sub.Data;

import java.sql.SQLException;

/**
 * Created by burak on 11.07.2017.
 */
public class main {
    public static void main(String [] args) throws SQLException {
        Data data = new Data();
        data.UserList();
        System.out.println(data.UserList());
        data.UpdatingServer();
    }
}
