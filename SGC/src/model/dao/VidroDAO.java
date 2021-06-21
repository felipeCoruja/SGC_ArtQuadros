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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Vidro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author felip
 */
public class VidroDAO {
    
    public void salvar(Vidro v) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO vidro (id,tipo,altura_chapa,comprimento_chapa,"
                                      + "espessura_vidro,quant_chapas,preco_custo)"
                                      + " VALUES(?,?,?,?,?,?,?)");
            
            stmt.setInt(1, v.getId());
            stmt.setString(2, v.getTipo());
            stmt.setDouble(3, v.getAlturaChapa());
            stmt.setDouble(4, v.getComprimentoChapa());
            stmt.setInt(5, v.getEspessuraChapa());
            stmt.setInt(6, v.getQuantidadeChapas());
            stmt.setDouble(7, v.getPrecoCusto());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Vidro no Banco de Dados :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
                                
    public List<Vidro> load() throws ClassNotFoundException{
        List<Vidro> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM vidro");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Vidro v = new Vidro();
                v.setId(rs.getInt("id"));
                v.setTipo(rs.getString("tipo"));
                v.setAlturaChapa(rs.getDouble("altura_chapa"));
                v.setComprimentoChapa(rs.getDouble("comprimento_chapa"));
                v.setEspessuraChapa(rs.getInt("espessura_chapa"));
                v.setQuantidadeChapas(rs.getInt("quant_chapas"));
                v.setPrecoCusto(rs.getDouble("preco_custo"));
                
                lista.add(v);
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro no Load de Vidro Classe VidroDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
}
