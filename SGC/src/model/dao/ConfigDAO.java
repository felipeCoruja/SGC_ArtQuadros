/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Config;
import java.sql.ResultSet;
/**
 *
 * @author Felipe
 */
public class ConfigDAO {
    
    public void salvarConfig(Config c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE config SET vidro_metro_quadrado = ?, eucatex_metro_quadrado = ?,"
                                       + " espelho_metro_quadrado = ?,valor_mao_de_obra = ? where id = 1 ");
            stmt.setDouble(1, c.getVidro_metro());
            stmt.setDouble(2, c.getEucatex_metro());
            stmt.setDouble(3, c.getEspelho_metro());
            stmt.setDouble(4, c.getMao_de_obra());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Config load() throws ClassNotFoundException{
        Config c = new Config();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM config WHERE id = 1");
            
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setVidro_metro(rs.getDouble("vidro_metro_quadrado"));
                c.setEucatex_metro(rs.getDouble("eucatex_metro_quadrado"));
                c.setEspelho_metro(rs.getDouble("espelho_metro_quadrado"));
                c.setMao_de_obra(rs.getDouble("mao_de_obra"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfigDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }
}


