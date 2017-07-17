//import Sub.Data;

//import java.sql.SQLException;


import Sub.Data;

import java.sql.SQLException;

/**
 * Created by burak on 11.07.2017.
 */
public class main {
   public static void main(String [] args) throws SQLException {

       Data data = new Data();
       System.out.println(data.LookingForYatch("2017-01-05","2017-01-08"));
    }

}
