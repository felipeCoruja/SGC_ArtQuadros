/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.bean.Eucatex;
/**
 *
 * @author felip
 */
public class EucatexDAO {
    
    public void salvar(Eucatex e) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO eucatex (tipo,altura_chapa,comprimento_chapa,"
                                      + "quant_chapas,preco_custo)"
                                      + " VALUES(?,?,?,?,?)");
            
            
            stmt.setString(1, e.getTipo());
            stmt.setDouble(2, e.getAlturaChapa());
            stmt.setDouble(3, e.getComprimentoChapa());
            stmt.setInt(4, e.getQuantidadeChapas());
            stmt.setDouble(5, e.getPrecoCusto());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EucatexDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Eucatex no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
                                
    public List<Eucatex> load() throws ClassNotFoundException{
        List<Eucatex> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM eucatex");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Eucatex e = new Eucatex();
                e.setId(rs.getInt("id"));
                e.setTipo(rs.getString("tipo"));
                e.setAlturaChapa(rs.getDouble("altura_chapa"));
                e.setComprimentoChapa(rs.getDouble("comprimento_chapa"));
                e.setQuantidadeChapas(rs.getInt("quant_chapas"));
                e.setPrecoCusto(rs.getDouble("preco_custo"));
                
                lista.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EucatexDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no Load de Eucatex Classe EucatexDAO :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
    
    public void delete(int id) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM eucatex WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(EucatexDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro no Delete de Eucatex Classe EucatexDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
            
    
    }
    
    public String[] getTiposEucatex() throws ClassNotFoundException{
        String[] listId = null;
        int i = 0;
        List<Eucatex> listaEucatex = this.load();
        String str = "Não;";
        
        for(int j = 0; j <listaEucatex.size();j++){
            str = str+listaEucatex.get(j).getTipo()+" #"+listaEucatex.get(j).getId()+";";
        }
       
        listId = str.split(";");
        return listId;
    }
}
