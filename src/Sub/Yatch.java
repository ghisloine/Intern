package Sub;
import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by burak on 14.07.2017.
 */
public class Yatch extends Data{
    @Override
    public Connection baglanti() {
        return super.baglanti();
    }
    public HashMap<String, ArrayList<String>> Yatches(ArrayList<String> Yatch_Info){
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        Statement statement = null;
        String Name = null;
        String Length = null;
        String Price = null;
        String Capacity = null;
        String WC = null;
        String Brand = null;
        if (baglanti() == null){
            //System.out.println("Trying For Connect");
            baglanti();
        }
        try{
            statement = baglanti().createStatement();
            for (String s : Yatch_Info) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Yatch_Info WHERE Name ='" + s + "'");
                while (resultSet.next()) {
                    Name = resultSet.getString("Name");
                    Length = resultSet.getString("Length");
                    Price = resultSet.getString("Price");
                    Capacity = resultSet.getString("Capacity");
                    WC = resultSet.getString("WC");
                    Brand = resultSet.getString("Brand");
                    ArrayList<String>Yatch_Bilgi = new ArrayList<String>();
                    Yatch_Bilgi.add(Length +"\t"+Price+"\t"+Capacity+"\t"+WC+"\t"+Brand);
                    map.put(Name,Yatch_Bilgi);
                    }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()){
            String key = entry.getKey();
            List<String>values = entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values ="+ values);
        }
        return map;



    }

}
