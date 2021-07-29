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
import java.util.ArrayList;
import java.util.List;
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
            
            stmt = con.prepareStatement("INSERT INTO produto_fornecedor(id_produto,id_fornecedor)VALUES(?,?)");
            stmt.setInt(1, id);
            stmt.setString(2, p.getFornecedorCnpj());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"Erro ao salvar dados na classe ProdutoDAO "+e);
        }finally{
          ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List load() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto AS p LEFT JOIN produto_preco AS pc ON p.id = pc.id");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setTipo(rs.getString("tipo"));
                p.setDescricao(rs.getString("descricao"));
                p.setDataChegada(rs.getString("data_chegada"));
                p.setDataVenda(rs.getString("data_venda"));
                p.setPrecoCusto(rs.getDouble("preco_custo"));
                p.setPrecoVenda(rs.getDouble("preco_venda"));
                
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro fazer o load dos dados na classe ProdutoDAO "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
}
