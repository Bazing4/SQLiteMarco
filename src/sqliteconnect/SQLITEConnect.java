
package sqliteconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marco
 */
public class SQLITEConnect {


    public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");

    Connection connection = null;
    try
    {

      connection = DriverManager.getConnection("jdbc:sqlite:TeamMembers.sqlite");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);

      ResultSet rs = statement.executeQuery("select * from Members");
      while(rs.next())
      {
        System.out.println("ID = " + rs.getInt("ID")); 
        System.out.println("First Name = " + rs.getString("First_Name"));
        System.out.println("Last Name = " + rs.getString("Last_Name"));
        System.out.println("Job Title = " + rs.getString("Job_Title"));
      }
    }
    catch(SQLException e)
    {
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        System.err.println(e);
      }
    }
    }
    
}
