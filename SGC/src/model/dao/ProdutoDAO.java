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
import java.sql.ResultSet;
/**
 *
 * @author Felipe
 */
public class ProdutoDAO {
    
    public void save(Produto p) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id = -1;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto(descricao,data_chegada,tipo) "
                                        + "VALUES(?,?,?)");
            
            stmt.setString(1, p.getDescricao());
            stmt.setString(2, p.getDataChegada());
            stmt.setString(3, p.getTipo());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT id FROM produto ORDER BY id DESC LIMIT 1");
            rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getInt("id");
            }
            stmt = con.prepareStatement("INSERT INTO produto_preco(id,preco_custo,preco_venda)"
                                        + " VALUES(?,?,?)");
            stmt.setInt(1, id);
            stmt.setDouble(2, p.getPrecoCusto());
            stmt.setDouble(3, p.getPrecoVenda());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"Erro ao salvar dados na classe ProdutoDAO "+e);
        }finally{
          ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
}
