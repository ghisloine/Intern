package Sub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by burak on 17.07.2017.
 */
public class Update extends Data{
    @Override
    public Connection baglanti() {
        return super.baglanti();
    }
    public boolean InsertingDb(String Name, String StartDate, String EndDate, String EndDestination, String Cap_TCK, String User_TCKNO) throws SQLException {
        //Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = baglanti().prepareStatement("INSERT INTO Reservation (Yatch_Name,StartDate,EndDate,EndDestination,Captain_TCKNO,User_TCKNO) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,Name);
            preparedStatement.setString(2,StartDate);
            preparedStatement.setString(3,EndDate);
            preparedStatement.setString(4,EndDestination);
            preparedStatement.setString(5,Cap_TCK);
            preparedStatement.setString(6,User_TCKNO);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Hata");
            System.out.println(e);
            return false;
        }finally {
            preparedStatement.close();
            baglanti().close();

        }
        return true;

    }

}
