
package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author felip
 */
public class ClienteDAO {
    
    public void salvar(Cliente c){
        try {
            this.salvarClienteNome(c);//unica variável obrigatoria em Cliente
            //variáveis a baixo são opcionais 
            if(!c.getCpf().isEmpty()){
                this.salvarClienteCpf(c);
            }
            if(!c.getCnpj().isEmpty()){
                this.salvarClienteCnpj(c);
            }
            if(!c.getEmail().isEmpty()){
                this.salvarClienteEmail(c);
            }
            if(!c.getIncEstadual().isEmpty()){
                this.salvarClienteInscEstadual(c);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cliente no Banco de Dados :"+ex);
        }
    }
    
    private void salvarClienteNome(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_nome (id,nome) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getNome());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nome do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    
    private void salvarClienteInscEstadual(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_insc_estadual (id,insc_estadual) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getIncEstadual());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Insc. Estadual do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    
    private void salvarClienteCpf(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_cpf (id,cpf) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getCpf());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cpf do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    
    private void salvarClienteCnpj(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_cnpj (id,cnpj) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getCnpj());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cnpj do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    
    private void salvarClienteEmail(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_email (id,email) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getEmail());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Email do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    
    
    public List<Cliente> load() throws ClassNotFoundException{
        List<Cliente> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente_nome");
            
            rs = stmt.executeQuery();
            stmt = null;
            while(rs.next()){
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                
                c.setCpf( this.selectCpf(c.getId(),stmt,con));//faz o select buscando um valor cpf ligado ao id de cliente_nome
                                                     //e seta em c.setCpf
                
                lista.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Load class ClienteDAO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
    
    private String selectCpf(int id,PreparedStatement stmt, Connection con){
        String cpf = "";
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente_cpf WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                return rs.getString("cpf");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cpf;
    }
}
