
package travel.and.tourism;

import java.sql.*;
  
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///travelandtourism","root","Ramukavitha@6");
            s=c.createStatement();
            
        }catch(Exception e){
           e.printStackTrace(); 
        }
    }
    
}
