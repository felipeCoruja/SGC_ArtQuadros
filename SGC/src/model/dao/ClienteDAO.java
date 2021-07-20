
package model.dao;

import connection.ConnectionFactory;
import model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        int id;
        try {
            this.salvarClienteNome(c);//unica variável obrigatoria para o cadastro em Cliente É o nome e telefone
            //variáveis a baixo são opcionais 
            id = this.getId();//pega o ultimo id do ultimo cliente no BD cadastrado na linha a cima
            c.setId(id);
            if(!c.getCpf().isEmpty()){
                this.salvarClienteCpf(c);
            }
            if(!c.getCnpj().isEmpty()){
                this.salvarClienteCnpj(c);
            }
            if(!c.getEmail().isEmpty()){
                this.salvarClienteEmail(c);
            }
            if(!c.getInscEstadual().isEmpty()){
                this.salvarClienteInscEstadual(c);
            }
            if(!c.getListaTelefone().isEmpty()){
                this.salvarTelefone(c);
            }
            if(!c.getListaEndereco().isEmpty()){
                this.salvarEndereco(c);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cliente no Banco de Dados :"+ex);
        }
    }
    
    /*Salva na tabela cliente_nome*/
    private void salvarClienteNome(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_nome (nome) VALUES(?)");
        
            stmt.setString(1, c.getNome());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nome do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    //Salva na tabela cliente_inc_estadual
    private void salvarClienteInscEstadual(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente_insc_estadual (id,insc_estadual) VALUES(?,?)");
            
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getInscEstadual());
            
            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Insc. Estadual do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    //salva em cliente_cpf
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cpf do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    //salva cliente_cnpj
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Cnpj do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    //salva em cliente_email
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Email do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
    //SALVANDO A LISTA DE NUMEROS TELEFONICOS NA TABELA TELEFONE
    private void salvarTelefone(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String aux = "";
        String[] vet = null;
        
        try {
            for(int i=0;i<c.getListaTelefone().size();i++){//inserindo todos os numeros da lista referente ao cliente
                stmt = con.prepareStatement("INSERT INTO telefone (id,numero,descricao) VALUES(?,?,?)");
                stmt.setInt(1, c.getId());
                
                aux = c.getListaTelefone().get(i);
                vet = aux.split(";");
                String numero = vet[0];
                stmt.setString(2, numero);
                
                String descricao = vet[1];
                stmt.setString(3, descricao);
                
                stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Telefone do Cliente no Banco de Dados :"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    //Salva na tabela de endereco
    private void salvarEndereco(Cliente c) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        int idEndereco = -1;
        EnderecoDAO eDao = new EnderecoDAO();
        try {
            for(int i=0;i<c.getListaEndereco().size();i++){
                
                stmt = con.prepareStatement("INSERT INTO endereco (uf,cidade,bairro,rua,complemento,numero,referencia)"
                                          + " VALUES(?,?,?,?,?,?,?)");
               //id AUTO INCREMENTADO
                stmt.setString(1, c.getListaEndereco().get(i).getUf());
                stmt.setString(2, c.getListaEndereco().get(i).getCidade());
                stmt.setString(3, c.getListaEndereco().get(i).getBairro());
                stmt.setString(4, c.getListaEndereco().get(i).getRua());
                stmt.setString(5, c.getListaEndereco().get(i).getComplemento());
                stmt.setString(6, c.getListaEndereco().get(i).getNumero());
                stmt.setString(7, c.getListaEndereco().get(i).getReferencia());
                 
                stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
                
             
                //TABELA DE RELACIONAMENTO CLIENTE-ENDEREÇO
                idEndereco = eDao.getUltimoId();//pega o ID que foi inserido com auto incremento
                
                stmt = con.prepareStatement("INSERT INTO cliente_endereco(idCliente,idEndereco)VALUES(?,?)");
                stmt.setInt(1, c.getId());
                stmt.setInt(2, idEndereco);
                
                stmt.executeUpdate();

                                
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Endereço do Cliente no Banco de Dados :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /*Classe load para quando já se sabe o ID da pessoa cadastrada*/
    public Cliente load(int id) throws ClassNotFoundException{
        Cliente c = new Cliente();
        Connection con = ConnectionFactory.getConnection();//pegando a conexão com o BD
        PreparedStatement stmt = null;// preparador de SQL
        ResultSet rs = null;//Variável onde se joga o resultado do SELECT
        
        try {//procurando registro de nome com esse ID
            //SELECT NOME
            stmt = con.prepareStatement("SELECT * FROM cliente_nome WHERE id = ? ");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
 
            if(rs.next()){//Se houver algum registro com esse ID execute
                c.setNome(rs.getString("nome"));
                JOptionPane.showMessageDialog(null, "Load Nome feito "+c.getNome());
                
                //Agora que sabemos que há um cadastro de um campo obrigatório(nome) com esse ID 
                //procuramos outros registros com esse ID
                
                //SELECT CPF
                stmt = con.prepareStatement("SELECT * FROM cliente_cpf WHERE id = ? ");
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if(rs.next()){//se houver algum registro com esse ID execute
                    c.setCpf(rs.getString("cpf"));
                    JOptionPane.showMessageDialog(null, "Load cpf feito "+ c.getCpf());
                }
                //SELECT EMAIL
                stmt = con.prepareStatement("SELECT * FROM cliente_email WHERE id = ? ");
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if(rs.next()){//se houver algum registro com esse ID execute
                    c.setEmail(rs.getString("email"));
                    JOptionPane.showMessageDialog(null, "Load email feito "+ c.getEmail());
                }
                
                //SELECT INSC ESTADUAL
                stmt = con.prepareStatement("SELECT * FROM cliente_insc_estadual WHERE id = ? ");
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if(rs.next()){//se houver algum registro com esse ID execute
                    c.setInscEstadual(rs.getString("insc_estadual"));
                    JOptionPane.showMessageDialog(null, "Load insc estadual feito "+ c.getInscEstadual());
                }
                
                //SELECT CNPJ
                stmt = con.prepareStatement("SELECT * FROM cliente_cnpj WHERE id = ? ");
                stmt.setInt(1, id);
                rs = stmt.executeQuery();
                if(rs.next()){//se houver algum registro com esse ID execute
                    c.setCnpj(rs.getString("cnpj"));
                    JOptionPane.showMessageDialog(null, "Load cnpj feito "+ c.getCnpj());
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Load classe ClienteDAO: "+ex);
        }finally{//FECHANDO A CONEXÃO COM O BD NO finally PARA TER CERTEZA QUE SERÁ FECHADA NO FINAL
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return c;
    }
     
    private int getId() throws ClassNotFoundException{
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT id FROM cliente_nome ORDER BY id DESC LIMIT 1;");
            rs = stmt.executeQuery();
            rs.next();
            id = rs.getInt("id");
            JOptionPane.showMessageDialog(null, "ID>>"+id);
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar ID :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return id;
    }
     
}
