package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    public static Connection connectionToDatabase(){
        Connection connectToDatabase = null;
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
            connectToDatabase = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookClone","root","Csignit@dev.");
        }catch(Exception e){System.out.println(e);}
        return connectToDatabase;
    }
}
