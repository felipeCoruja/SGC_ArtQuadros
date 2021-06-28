
package model.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Moldura;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author felip
 */
public class MolduraDAO {
    /*Metodo responsável por salvar todos os dados de moldura, dados estão separados em mais de uma tabela*/
    public void salvar(Moldura m) throws ClassNotFoundException {
        salvarTabelaMoldura(m);//tabela principal de moldura
        salvarTabelaMolduraPreco(m);//tabela de valores da moldura
    }
    
    private void salvarTabelaMoldura(Moldura m)throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();//pegando a conexão com o BD
        PreparedStatement stmt = null;//instanciando o preparador de comandos SQL

        try {
            //Passando o comando de INSERT para inserir na tabela moldura
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO moldura"
                    + "(id,cor,descricao,material,quant_metros,comprimento_vara,largura_vara)"
                    + "VALUES(?,?,?,?,?,?,?)");// passando variaveis '?' no lugar dos VALUES

            //Passando os valores de VALUES
            stmt.setInt(1,m.getId());//Primeiro parâmetro se refere a variável -> '?' na respectiva ordem
            stmt.setString(2, m.getCor());
            stmt.setString(3, m.getDescricao());
            stmt.setString(4, m.getMareial());
            stmt.setDouble(5, m.getQuantMetros());
            stmt.setDouble(6, m.getComprimentoVara());
            stmt.setDouble(7, m.getLarguraVara());

            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)


        } catch (SQLException e) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados no banco, classe MolduraDAO: "+e);
        }finally{//A CONEXÃO É FECHADA NO finally POIS ASSIM TEMOS CERTEZA QUE ELA IRÁ SER FECHADA
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void salvarTabelaMolduraPreco(Moldura m) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();// Pegando a conexão com BD
        PreparedStatement stmt = null;//instanciando o preparador de comandos SQL
        
        try {//passando o comando INSET com variáveis dentro de VALUES(?,?,?)
           stmt = (PreparedStatement) con.prepareStatement("INSERT INTO moldura_preco(id,preco_custo,preco_venda)"
                   + "VALUES(?,?,?)");
           
           //Passando os valores das variáveis Respectivamente
           stmt.setInt(1, m.getId());
           stmt.setDouble(2, m.getPrecoCusto());
           stmt.setDouble(3, m.getPrecoVenda());
           
           stmt.executeUpdate();//executando o comando SQL. 
                                //Metodo executeUpdate é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
        } catch (SQLException e) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null,"Erro em salvarTabelaMolduraPreco: "+e);
        }finally{//FECHANDO A CONEXÃO NO FINALLY PARA TER CERTEZA DE QUE ELA SERÁ FECHADA
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public List<Moldura> load() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();//pegando a conexão com o BD
        PreparedStatement stmt = null;// Preparador de comandos SQL
        ResultSet rs = null;// Variavel onde irei jogar o resultado do SELECT
        List<Moldura> lista = new ArrayList<>();
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM moldura AS m"
                                                + "JOIN moldura_preco AS mp ON m.id = mp.id");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Moldura m = new Moldura();
                m.setId(rs.getInt("moldura.id"));
                m.setCor(rs.getString("cor"));
                m.setDescricao(rs.getString("descricao"));
                m.setQuantMetros(rs.getDouble("quant_metros"));
                m.setComprimentoVara(rs.getDouble("comprimento_vara"));
                m.setLarguraVara(rs.getDouble("largura_vara"));
                m.setPrecoCusto(rs.getDouble("preco_custo"));
                m.setPrecoVenda(rs.getDouble("preco_venda"));
                
                lista.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MolduraDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de Load classe MolduraDAO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
}
