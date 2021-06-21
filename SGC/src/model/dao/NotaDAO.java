/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import model.bean.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author felip
 */
public class NotaDAO {
    
    public void salvar(Nota n) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO nota(id,data_entrega,data_da_nota,desconto,"
                                      + "valor_total,valor_entrada,forma_pagamento)"
                                      + " VALUES(?,?,?,?,?,?,?)");
            
            stmt.setInt(1, n.getId());
            stmt.setString(2, n.getDataEntrega());
            stmt.setString(3, n.getDataNota());
            stmt.setInt(4, n.getDesconto());
            stmt.setDouble(5, n.getValorTotal());
            stmt.setDouble(6, n.getValorEntrada());
            stmt.setString(7, n.getFormaPagamento());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Nota> load() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Nota> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM nota AS n JOIN nota_status AS ns ON n.id = ns.id ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Nota n = new Nota();
                
                n.setId(rs.getInt("nota.id"));
                n.setDataEntrega(rs.getString("data_entrega"));
                n.setDataNota(rs.getString("data_da_nota"));
                n.setDesconto(rs.getInt("desconto"));
                n.setValorTotal(rs.getDouble("valor_total"));
                n.setValorEntrada(rs.getDouble("valor_entrada"));
                n.setFormaPagamento(rs.getString("forma_pagamento"));
                n.setStatusPagamento(rs.getString("status_pagamento"));
                n.setDataEncerramento(rs.getString("data_encerramento"));
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
    
    public void updateDataEncerramento(int id, String data) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE nota SET data_encerramento = ? WHERE id = ?");
            stmt.setString(1, data);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro de Update data_encerramento na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}
