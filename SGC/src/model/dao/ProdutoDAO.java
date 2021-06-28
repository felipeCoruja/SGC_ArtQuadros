/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Felipe
 */
public class ProdutoDAO {
    
    public void save(Produto p) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto(id,descricao,data_chegada,data_venda,tipo) "
                                        + "VALUES(?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getDataChegada());
            stmt.setString(4, p.getDataVenda());
            stmt.setString(5, p.getTipo());
            
            stmt.executeUpdate();
            stmt = null;
            
            stmt = con.prepareStatement("INSERT INTO produto_preco(id,preco_custo,preco_venda)"
                                        + " VALUES(?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setDouble(2, p.getPrecoCusto());
            stmt.setDouble(3, p.getPrecoVenda());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"Erro ao salvar dados na classe ProdutoDAO "+e);
        }
    }
}
