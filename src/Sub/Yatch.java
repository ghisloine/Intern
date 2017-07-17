package Sub;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by burak on 14.07.2017.
 */
public class Yatch extends Data{
    @Override
    public Connection baglanti() {
        return super.baglanti();
    }

    public ArrayList Yatches(String Yatch_Name){
        Statement statement = null;
        ArrayList<String> Yatch_Info = new ArrayList<String>();
        System.out.println("Here Your Yatches");
        String Name = null;
        String Length = null;
        String Price = null;
        String Capacity = null;
        String WC = null;
        String Brand = null;
        if (baglanti() == null){
            System.out.println("Trying For Connect");
            baglanti();
        }
        try{
            statement = baglanti().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Yatch_Info WHERE Name ='"+ Yatch_Name+"'");
            while (resultSet.next()){
              Name = resultSet.getString("Name");
              Length = resultSet.getString("Length");
                Price = resultSet.getString("Price");
                Capacity = resultSet.getString("Capacity");
                WC = resultSet.getString("WC");
                Brand = resultSet.getString("Brand");
            }
            Yatch_Info.add(Name);
            Yatch_Info.add(Length);
            Yatch_Info.add(Price);
            Yatch_Info.add(Capacity);
            Yatch_Info.add(WC);
            Yatch_Info.add(Brand);

        }catch (Exception e){
            System.out.println(e);
        }

        for (int i = 0;i<Yatch_Info.size();i++){
            System.out.println(Yatch_Info.get(i));
        }

        return Yatch_Info;



    }

}
