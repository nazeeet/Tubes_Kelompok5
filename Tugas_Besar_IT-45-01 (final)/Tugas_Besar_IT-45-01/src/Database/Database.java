
package Database;

import static Database.Database.User;
import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    static final String URL ="jdbc:mysql://localhost/pbo";
    static final String User = "root";
    static final String Pass = "";
    public static Connection connect;
    public static Statement stat;
    public static ResultSet result;
    
    
    public void connect() throws SQLException {
        connect = DriverManager.getConnection(URL, User,Pass);
        stat = (Statement) connect.createStatement();
    }
    
    public void update(String query){
        try{
            stat.executeUpdate(query);  
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
      public ResultSet getData(String q){
        try{
           result = stat.executeQuery(q);
        } catch (SQLException e){
           System.out.println(e.getMessage());
        }
        return result;
    }
      
       public void disconnect(){
        try{
            connect.close();
        } catch(SQLException e){
             System.out.println(e.getMessage());
        }
    }
       
       public ArrayList<User> selectUser(){
           ArrayList<User>  Users = new ArrayList<>(); 
           Database db = new Database();
           String query = " SELECT * FROM User";
           ResultSet rs = db.getData(query);
           
           
        try {
            while(rs.next()){
                Users.add(new User(rs.getString("id"), rs.getString("Nama"), rs.getString("Email"), rs.getString("Password"), rs.getString("Role")));
            }
            return Users;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
       
}
