
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
            
            stmt.setInt(0, c.getId());
            stmt.setString(1, c.getNome());
            
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
            stmt = con.prepareStatement("INSERT INTO cliente_nome (id,insc_estadual) VALUES(?,?)");
            
            stmt.setInt(0, c.getId());
            stmt.setString(1, c.getIncEstadual());
            
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
            stmt = con.prepareStatement("INSERT INTO cliente_nome (id,cpf) VALUES(?,?)");
            
            stmt.setInt(0, c.getId());
            stmt.setString(1, c.getCpf());
            
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
            stmt = con.prepareStatement("INSERT INTO cliente_nome (id,cnpj) VALUES(?,?)");
            
            stmt.setInt(0, c.getId());
            stmt.setString(1, c.getCnpj());
            
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
            stmt = con.prepareStatement("INSERT INTO cliente_nome (id,email) VALUES(?,?)");
            
            stmt.setInt(0, c.getId());
            stmt.setString(1, c.getEmail());
            
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
            stmt = con.prepareStatement("SELECT * FROM cliente_nome AS cNome JOIN cliente_cpf AS cCpf ON cNome.id = cCpf.id "
                                        + "JOIN cliente_cnpj AS cCnpj ON cNome.id = cCnpj.id "
                                        + "JOIN cliente_email AS cEmail ON cNome.id = cEmail.id "
                                        + "JOIN cliente_insc_estadual AS cInsc ON cNome.id = cInsc.id");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("cliente_nome.id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setCnpj(rs.getString("cnpj"));
                c.setEmail(rs.getString("email"));
                c.setIncEstadual(rs.getString("insc_estadual"));
                
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
}
