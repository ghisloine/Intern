package Sub;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by burak on 11.07.2017.
 */
public class Data {
    private Connection connection;
    public Connection baglanti(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Succesfull");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Example","root","toor");
        } catch (Exception e) {
            System.out.println("Baglantı Basarısız");
            e.printStackTrace();
        }
        return connection;
    }
    public ArrayList<String> UserList(){
        ArrayList<String> liste = new ArrayList<String>();
        String a;
        if (connection == null){
            System.out.println("Not Connected Database,Connecting...");
            baglanti();
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pet");
            while (resultSet.next()){
                a =  resultSet.getString("name")+ " " +resultSet.getString("owner") + "  " + resultSet.getString("species");
                liste.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;

    }
    public void UpdatingServer() throws SQLException {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO  pet Values('Aysel','Muzeyyen','human','f','1968-02-13',NULL)");
            System.out.println("Ekleme Başarılı");
            this.UserList();
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("EKLEME BAŞARISIZ !");
        }
        finally {
            if (statement != null){
                statement.close();

            }
        }


    }

}
