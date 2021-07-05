/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class EnderecoDAO {
    public int getUltimoId() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = -1;
        
        try {
            stmt = con.prepareStatement("SELECT id FROM endereco ORDER BY id DESC LIMIT 1");
            rs = stmt.executeQuery();
            id = rs.getInt("id");
        } catch (SQLException e) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao carregar id de endereco no Banco de Dados :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        if(id == -1){
            System.out.println("ERRO NA FUNÇÃO getUltimoId() em EnderecoDAO");
            JOptionPane.showMessageDialog(null, "Erro ao carregar id de endereco no Banco de Dados");
        }
        return id;
    }
    
}
