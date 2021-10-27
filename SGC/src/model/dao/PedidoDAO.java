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
import java.sql.ResultSet;
/**
 *
 * @author felip
 */
public class PedidoDAO {
       
    public void salvar(List<Pedido> listaPedido) throws ClassNotFoundException{
        try {
            
            for(int i=0;i<listaPedido.size();i++){   
                
                salvarPedido(listaPedido, i);
                listaPedido.get(i).setId(this.getUltimoId());
                
                if(!listaPedido.get(i).getMoldura().equals("Não")){
                    salvarPedidoMoldura(listaPedido, i);
                }
                
                if(!listaPedido.get(i).getVidro().equals("-1")){
                    salvarPedidoVidro(listaPedido, i);
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar pedido na Classe PedidoDAO :"+ex);
        }
    }
    
    private void salvarPedido(List<Pedido> listaPedido, int i) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido(altura,largura,valor_unitario,tipo,quantidade,descricao)"
                                      + " VALUES(?,?,?,?,?,?)");
                
                stmt.setDouble(1, listaPedido.get(i).getAltura());
                stmt.setDouble(2, listaPedido.get(i).getLargura());
                stmt.setDouble(3, listaPedido.get(i).getValorUnitario());
                stmt.setString(4, listaPedido.get(i).getTipo());
                stmt.setInt(5, listaPedido.get(i).getQuantidade());
                stmt.setString(6, listaPedido.get(i).getDescricao());

                stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em salvarPedido() na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    private void salvarPedidoMoldura(List<Pedido> listaPedido, int i) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        try {
            stmt = con.prepareStatement("INSERT INTO pedido_moldura(id_pedido,id_moldura,ordem_moldura_paspatu)"
                                                + "VALUES(?,?,?)");
                    stmt.setInt(1, listaPedido.get(i).getId());
                    stmt.setString(2, listaPedido.get(i).getMoldura());
                    stmt.setInt(3, 0);
                    stmt.executeUpdate();
            
            int cont = 1;
                for(int j = listaPedido.get(i).getListaPaspatu().size()-1;j>=0;j--){
                    stmt = con.prepareStatement("INSERT INTO pedido_moldura(id_pedido,id_moldura,ordem_moldura_paspatu)"
                                                + "VALUES(?,?,?)");
                    stmt.setInt(1, listaPedido.get(i).getId());
                    stmt.setString(2, listaPedido.get(i).getListaPaspatu().get(i));
                    stmt.setInt(3, cont);
                    cont++;
                    
                    stmt.executeUpdate();
                }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em salvarPedidoMoldura() na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void salvarPedidoVidro(List<Pedido> listaPedido, int i) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido_vidro(id_pedido,id_vidro,entre_vidros)VALUES(?,?,?)");
                stmt.setInt(1, listaPedido.get(i).getId());
                stmt.setInt(2, listaPedido.get(i).getIdVidro());
                String sn = "N";
                if(listaPedido.get(i).isEntreVidros()){
                    sn = "S";
                }
                stmt.setString(3,sn);
                System.out.println("PedidoDAO \n >>>"+listaPedido.get(i).getId());
                System.out.println(">>>"+listaPedido.get(i).getIdVidro());
                System.out.println(">>>"+sn);
                stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em salvarPedidoVidro() na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    private void salvarPedidoEucatex(List<Pedido> listaPedido, int i) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido_eucatex(id_pedido,id_eucatex)VALUES(?,?)");
                stmt.setInt(1, listaPedido.get(i).getId());
                stmt.setInt(2, listaPedido.get(i).getIdEucatex());
    
                stmt.executeUpdate();
   
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em salvarPedidoEucatex() na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    
    private int getUltimoId() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int result = -1;
        try {
            stmt = con.prepareStatement("SELECT id FROM pedido ORDER BY id DESC LIMIT 1");
            rs = stmt.executeQuery();
            
            if(rs.next()){
                result = rs.getInt("id");
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro em getUltimoId() na Classe PedidoDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
            if(result == -1){
                JOptionPane.showMessageDialog(null, "Erro em getUltimoId() na Classe PedidoDAO id -1 registrado no banco");
                System.out.println("Erro em getUltimoId() na Classe PedidoDAO, id -1 registrado no banco");
            }
        }
        return result;
    }
}
