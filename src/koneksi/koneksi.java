package koneksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Personal
 */
public class koneksi {
    private static Connection mysqlkonek;
    public static Connection getKoneksi() throws SQLException{
        if(mysqlkonek==null){
            new Driver();
            mysqlkonek=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kasirrestoran", "root", "");
        }
        return mysqlkonek;
    }

    public static class getkoneksi {

        public getkoneksi() {
        }
    }
}
