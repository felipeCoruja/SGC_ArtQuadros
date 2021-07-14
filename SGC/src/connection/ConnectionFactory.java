/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author felip
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_artquadros";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);//retornando uma conexão com BD
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: "+ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if(con!=null){
            try {   
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Sobre carga de CloseConnection(), PreparedStatementWrapper serve para executar os comandos SQL
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt != null){
              stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt,ResultSet rs){
        closeConnection(con, stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
