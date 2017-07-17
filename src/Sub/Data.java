package Sub;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * Created by burak on 11.07.2017.
 */
public class Data {
    private Connection connection;
    public Connection baglanti(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Succesfull");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Charter","root","toor");
        } catch (Exception e) {
            System.out.println("Baglantı Basarısız");
            e.printStackTrace();
        }
        return connection;
    }
    private ArrayList<String> UserList(){
        ArrayList<String> liste = new ArrayList<String>();
        String a;
        if (connection == null){
            System.out.println("Not Connected Database,Connecting...");
            baglanti();
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()){
                a =  resultSet.getString("name")+ " " +resultSet.getString("özellik") + "  " + resultSet.getString("time");
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
            statement.executeUpdate("INSERT INTO  User Values('Aysel','Muzeyyen','1968-02-13')");
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
    public ArrayList<String> LookingForYatch(String GoDATE,String TurnDATE){
        Statement statement = null;
        Statement statementQuest = null;
        System.out.println("Yatch Search");
        System.out.println("When Do You Want To Go???");
        //Scanner sc = new Scanner(System.in);
        //GoDATE = "2017-01-01";
        System.out.println("When Do You Want To Back");
        //TurnDATE = "2017-01-05";
        int b = 0,c = 0,d = 0,e = 0;
        String a;
       // String Quest = "TO_DAYS(' +  i + "')";
        ArrayList<Integer> StartDate = new ArrayList<Integer>();
        ArrayList<Integer> EndDate = new ArrayList<Integer>();
        ArrayList<String> YatchName = new ArrayList<String>();
        ArrayList<String> Temp = new ArrayList<String>();
        HashSet<String> Conteiner = new HashSet<>();


        if (connection == null){
            System.out.println("Tryin' For Connect !!!");
            baglanti();
        }
        try{
            statement = connection.createStatement();
            statementQuest = connection.createStatement();
            //Rezerve Edilen Gidiş Tarihini Çevirir
            ResultSet resultSet = statement.executeQuery("SELECT *, TO_DAYS(StartDate) FROM  Reservation");
            //Bakılacak Olan Günü Çevirir

            //Bakılacak Olan Dönüş Gününü Çevirir
            //Rezerve Edilmiş Dönüş Gününü Çevirir

            while (resultSet.next()){
                a = resultSet.getString("Yatch_Name");
                b = resultSet.getInt("TO_DAYS(StartDate)" );
                YatchName.add(a);
                StartDate.add(b);
            }
            System.out.println("-------------");
            ResultSet resultSet2 = statement.executeQuery("SELECT TO_DAYS('"+GoDATE +"')");
            while (resultSet2.next()){
                d = resultSet2.getInt("TO_DAYS('"+  GoDATE +"')" );
            };
            System.out.println("+++++++++++++++++");
            ResultSet resultSet3 = statement.executeQuery("SELECT TO_DAYS('" + TurnDATE + "')");
            while (resultSet3.next()){
                e = resultSet3.getInt("TO_DAYS('" +  TurnDATE + "')" );
            };
            System.out.println("====================");
            ResultSet resultSet4= statement.executeQuery("SELECT *, TO_DAYS(EndDate) FROM  Reservation");
            while (resultSet4.next()){
                c = resultSet4.getInt("TO_DAYS(EndDate)" );
                EndDate.add(c);
            };
            System.out.println("-------------------");
            //Burda Hata Var
            System.out.println("+++++++++++++++++++++");
            /*for (int q = 0;q<StartDate.size();q++){
                if (d < StartDate.get(q)){
                    if (StartDate.get(q) == e || e < StartDate.get(q)){
                        Temp.add("Başarılı  " + YatchName.get(q) + " Teknesi Müsaittir");
                        Conteiner.add(YatchName.get(q));
                        System.out.println("Başarılı  " + YatchName.get(q) + " Teknesi Müsaittir");
                    }else {
                        System.out.println("Diğer Duruma Geçiyorum");
                    }
                }if (EndDate.get(q) == d || d>EndDate.get(q)){
                    Temp.add("Başarılı  " + YatchName.get(q) + " Teknesi Müsaittir");
                    Conteiner.add(YatchName.get(q));
                    System.out.println("Başarılı      " + YatchName.get(q) + " Teknesi Sizin İçin Müsaittir");
                }
            }*/
            for(int r = 0;r<StartDate.size();r++){
                if (d<=StartDate.get(r) && (EndDate.get(r)<=e && e>=StartDate.get(r))){
                    Temp.add(YatchName.get(r));
                }
                if (d<=StartDate.get(r) && e>=EndDate.get(r)){
                    Temp.add(YatchName.get(r));
                }
                if (e>=EndDate.get(r) && (d>=StartDate.get(r) && d<=EndDate.get(r))){
                    Temp.add(YatchName.get(r));
                }
                if ((d>=StartDate.get(r) && d<=EndDate.get(r)) || (e >= StartDate.get(r) && e<= EndDate.get(r))){
                    Temp.add(YatchName.get(r));
                }
            }

        }catch (Exception f){
            System.out.println(f);
        }
        return Temp;



    }

}
