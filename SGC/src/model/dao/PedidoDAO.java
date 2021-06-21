/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import model.bean.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class PedidoDAO {
    
    public void salvar(Pedido p) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido(id,altura,largura,valor_unitario,tipo,quantidade)"
                                      + " VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setDouble(2, p.getAltura());
            stmt.setDouble(3, p.getLargura());
            stmt.setDouble(4, p.getValorUnitario());
            stmt.setString(5, p.getTipo());
            stmt.setInt(6, p.getQuantidade());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar pedido na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
