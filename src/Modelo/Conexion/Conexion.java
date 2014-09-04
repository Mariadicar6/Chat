
package Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private final String URL = "jdbc:sqlserver://localhost;databaseName=";
    private final String Name = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String User = "sa";                   // Modificar nombre de usuario de su servidor 
    private final String Password ="123";       // Modificar password se su servidor
    private String Db = "";

    public Conexion(String Db) {
        this.Db = Db;

    }

    public Conexion() {
        this.Db = "Chat";

    }

    public Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(Name).newInstance();
            cn=DriverManager.getConnection(URL + Db, User, Password);
            

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("Error en la conexion"+ex.getMessage());
        }

        return cn;
        
    }

}
