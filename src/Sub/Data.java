package Sub;

import java.sql.*;

import java.util.*;

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
    public ArrayList<String> LookingForYatch(String GoDATE, String TurnDATE){

        Statement statement = null;
        Statement statementYatchName;
        int b = 0,c = 0,d = 0,e = 0;
        String a;
        ArrayList<Integer> StartDate = new ArrayList<Integer>();
        ArrayList<Integer> EndDate = new ArrayList<Integer>();
        ArrayList<String> YatchName = new ArrayList<String>();
        ArrayList<String> Temp = new ArrayList<String>();


        if (connection == null){
            System.out.println("Tryin' For Connect !!!");
            baglanti();
        }
        try{
            statement = connection.createStatement();
            //statementQuest = connection.createStatement();
            statementYatchName = connection.createStatement();
            //Rezerve Edilen Gidiş Tarihini Çevirir
            ResultSet resultSet = statement.executeQuery("SELECT *, TO_DAYS(StartDate) FROM  Reservation");
            while (resultSet.next()){
                b = resultSet.getInt("TO_DAYS(StartDate)" );
                StartDate.add(b);
            }
            ResultSet resultSet1 = statementYatchName.executeQuery("SELECT * FROM Yatch_Info");
            while (resultSet1.next()){
                a = resultSet1.getString("Name");
                YatchName.add(a);
            }
            ResultSet resultSet2 = statement.executeQuery("SELECT TO_DAYS('"+GoDATE +"')");
            while (resultSet2.next()){
                d = resultSet2.getInt("TO_DAYS('"+  GoDATE +"')" );
            };
            ResultSet resultSet3 = statement.executeQuery("SELECT TO_DAYS('" + TurnDATE + "')");
            while (resultSet3.next()){
                e = resultSet3.getInt("TO_DAYS('" +  TurnDATE + "')" );
            };
            ResultSet resultSet4= statement.executeQuery("SELECT *, TO_DAYS(EndDate) FROM  Reservation");
            while (resultSet4.next()){
                c = resultSet4.getInt("TO_DAYS(EndDate)" );
                EndDate.add(c);
            };
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
            //Comparing 2 ArrayList
        }catch (Exception f){
            System.out.println(f);
        }
        YatchName.removeAll(Temp);
        System.out.println(YatchName.toString());
        return YatchName;



    }

}
