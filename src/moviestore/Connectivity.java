
package moviestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connectivity {
   static java.sql.Connection connection;
       static String path =  "Database/moviestore.accdb";
       
           public static Connection openConnection(){
               
               
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection("jdbc:ucanaccess://"+ path);
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return connection;
                    }
           
     
        }
 

