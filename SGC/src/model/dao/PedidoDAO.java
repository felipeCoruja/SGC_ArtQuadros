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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class PedidoDAO {
       
    public void salvar(List<Pedido> listaPedido) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            for(int i=0;i<listaPedido.size();i++){   
                
                stmt = con.prepareStatement("INSERT INTO pedido(id,altura,largura,valor_unitario,tipo,quantidade)"
                                      + " VALUES(?,?,?,?,?,?,?)");
                stmt.setInt(1, listaPedido.get(i).getId());
                stmt.setDouble(2, listaPedido.get(i).getAltura());
                stmt.setDouble(3, listaPedido.get(i).getLargura());
                stmt.setDouble(4, listaPedido.get(i).getValorUnitario());
                stmt.setString(5, listaPedido.get(i).getTipo());
                stmt.setInt(6, listaPedido.get(i).getQuantidade());
                stmt.setString(7, listaPedido.get(i).getDescricao());

                stmt.executeUpdate();
                stmt = null;
                
                int cont = 1;
                for(int j = listaPedido.get(i).getListaPaspatu().size()-1;j>=0;j--){
                    stmt = con.prepareStatement("INSERT INTO pedido_moldura(id_pedido,id_moldura,ordem_moldura_paspatu)"
                                                + "VALUES(?,?,?)");
                    stmt.setInt(1, listaPedido.get(i).getId());
                    stmt.setString(2, listaPedido.get(i).getMoldura());
                    stmt.setInt(3, cont);
                    cont++;
                    
                    stmt.executeUpdate();
                }
                
                stmt = con.prepareStatement("INSERT INTO pedido_vidro(id_pedido,id_vidro,entre_vidros)VALUES(?,?,?)");
                stmt.setInt(1, listaPedido.get(i).getId());
                stmt.setInt(2, listaPedido.get(i).getIdVidro());
                String sn = "N";
                if(listaPedido.get(i).isEntreVidros()){
                    sn = "S";
                }
                stmt.setString(3,sn);
                stmt.executeUpdate();
                
                
                stmt = con.prepareStatement("INSERT INTO pedido_eucatex(id_pedido,id_eucatex)VALUES(?,?)");
                stmt.setInt(1, listaPedido.get(i).getId());
                stmt.setInt(2, listaPedido.get(i).getIdEucatex());
    
                stmt.executeUpdate();
   
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar pedido na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
