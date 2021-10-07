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
            stmt = con.prepareStatement("INSERT INTO vidro (tipo,altura_chapa,comprimento_chapa,"
                                      + "espessura_chapa,quant_chapas,preco_custo)"
                                      + " VALUES(?,?,?,?,?,?)");
            
            stmt.setString(1, v.getTipo());
            stmt.setDouble(2, v.getAlturaChapa());
            stmt.setDouble(3, v.getComprimentoChapa());
            stmt.setInt(4, v.getEspessuraChapa());
            stmt.setInt(5, v.getQuantidadeChapas());
            stmt.setDouble(6, v.getPrecoCusto());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(VidroDAO.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(VidroDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro no Load de Vidro Classe VidroDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
    
    public String[] getTiposVidro() throws ClassNotFoundException{
        String[] listId = null;
        int i = 0;
        List<Vidro> listaMoldura = this.load();
        String str = "Não;";
        
        for(int j = 0; j <listaMoldura.size();j++){
            str = str+listaMoldura.get(j).getTipo()+" |"+listaMoldura.get(j).getId()+";";
        }
       
        listId = str.split(";");
        return listId;
    }
}
