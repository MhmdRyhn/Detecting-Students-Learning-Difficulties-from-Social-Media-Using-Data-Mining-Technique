import java.sql.*;
import javax.swing.*;


public class ConnectDb {
    private static Connection con=null;
    
    public static Connection conDb() throws InstantiationException, IllegalAccessException{
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver connected");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/datamining","root","");
            System.out.println("database connected");
            return con;
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
