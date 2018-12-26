
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lentt
 */
public class JDBCMgKirjasto {
  String driver = "org.sqlite.JDBC";
    String url = "jdbc:sqlite:MgKirjasto.db";
    
    Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("JDBCMgKirjasto");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url);
        con.setAutoCommit(true);
        System.out.println("JDBCMgKirjasto get connection");
        return con;
    }
    
    void putData(String sql) throws ClassNotFoundException, SQLException {
       System.out.println("JDBCMgKirjasto putData1"); 
       Connection con = getConnection();
       System.out.println("JDBCMgKirjasto putData2");
        Statement state = con.createStatement();
        System.out.println("JDBCMgKirjasto putData3");
        state.executeUpdate(sql);
        System.out.println("JDBCMgKirjasto putData4");
        state.close();
       System.out.println("JDBCMgKirjasto putData5");
    }
    
    public Statement state;
    public ResultSet getData(String sql) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        state = con.createStatement();
        ResultSet rset = state.executeQuery(sql);
        System.out.println("JDBCMgKirjasto getData");
        return rset;
    }
}
