/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;
/**
 *
 * @author felip
 */
public class FornecedorDAO {
    
    public void salvar(Fornecedor f) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(" INSERT INTO fornecedor(cnpj,nome,descricao)VALUES(?,?,?)");
            
            stmt.setString(1, f.getCnpj());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getDescricao());
            
            stmt.executeUpdate();
            
            if(!f.getEmail().isEmpty()){
                stmt = con.prepareStatement("INSERT INTO fornecedor_email(cnpj,email) VALUES(?,?)");
                stmt.setString(1, f.getCnpj());
                stmt.setString(2, f.getEmail());
                
                stmt.executeUpdate();
            }
            
            if(!f.getListaEndereco().isEmpty()){
                this.salvarEndereco(f);
            }
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Fornecedor, Classe FornecedorDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void salvarEndereco(Fornecedor f) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        int idEndereco = -1;
        EnderecoDAO eDao = new EnderecoDAO();
        try {
            for(int i=0;i<f.getListaEndereco().size();i++){
                
                stmt = con.prepareStatement("INSERT INTO endereco (uf,cidade,bairro,rua,complemento,numero,referencia)"
                                          + " VALUES(?,?,?,?,?,?,?)");
               //id AUTO INCREMENTADO
                stmt.setString(1, f.getListaEndereco().get(i).getUf());
                stmt.setString(2, f.getListaEndereco().get(i).getCidade());
                stmt.setString(3, f.getListaEndereco().get(i).getBairro());
                stmt.setString(4, f.getListaEndereco().get(i).getRua());
                stmt.setString(5, f.getListaEndereco().get(i).getComplemento());
                stmt.setString(6, f.getListaEndereco().get(i).getNumero());
                stmt.setString(7, f.getListaEndereco().get(i).getReferencia());
                 
                stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
                
             
                //TABELA DE RELACIONAMENTO CLIENTE-ENDEREÇO
                idEndereco = eDao.getUltimoId();//pega o ID que foi inserido com auto incremento
                
                stmt = con.prepareStatement("INSERT INTO fornecedor_endereco(idFornecedor,idEndereco)VALUES(?,?)");
                stmt.setString(1, f.getCnpj());
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
    
    //Está retornando o Objeto Fornecedor incompleto, sem Endereço e sem Telefones
    public List<Fornecedor> load() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fornecedor> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM fornecedor AS f JOIN fornecedor_email AS fm ON f.cnpj = fm.cnpj");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                
                f.setCnpj(rs.getString("fornecedor.cnpj"));
                f.setNome(rs.getString("nome"));
                f.setDescricao(rs.getString("descricao"));
                f.setEmail(rs.getString("email"));
                
                lista.add(f);
            }
        } catch (SQLException e) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro no Load, Classe FornecedorDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }
    public String[] getNomeFornecedor() throws ClassNotFoundException{
        String[] listId = null;
        int i = 0;
        List<Fornecedor> listaMoldura = this.load();
        String str = "Não;";
        
        for(int j = 0; j <listaMoldura.size();j++){
            str = str+listaMoldura.get(j).getNome()+";";
        }
       
        listId = str.split(";");
        return listId;
    }
}
