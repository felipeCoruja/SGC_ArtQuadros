
package model.dao;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.SQLException;
import model.bean.Moldura;
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
        PreparedStatementWrapper stmt = null;//instanciando o preparador de comandos SQL

        try {
            //Passando o comando de INSERT para inserir na tabela moldura
            stmt = (PreparedStatementWrapper) con.prepareStatement("INSERT INTO moldura"
                    + "(id,cor,descricao,material,quant_metros,comprimento_vara,largura_vara)"
                    + "VALUES(?,?,?,?,?,?,?)");// passando variaveis '?' no lugar dos VALUES

            //Passando os valores de VALUES
            stmt.setInt(0,m.getId());//Primeiro parâmetro se refere a variável -> '?' na respectiva ordem
            stmt.setString(1, m.getCor());
            stmt.setString(2, m.getDescricao());
            stmt.setString(3, m.getMareial());
            stmt.setDouble(4, m.getQuantMetros());
            stmt.setDouble(5, m.getComprimentoVara());
            stmt.setDouble(6, m.getLarguraVara());

            stmt.executeUpdate();// Executando o comando INSERT, metodo executeUpdate()
                                //é responsável pelos comandos DML(INSERT,UPDATE,DELETE)


        } catch (SQLException e) {
        }finally{//A CONEXÃO É FECHADA NO finally POIS ASSIM TEMOS CERTEZA QUE ELA IRÁ SER FECHADA
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void salvarTabelaMolduraPreco(Moldura m) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();// Pegando a conexão com BD
        PreparedStatementWrapper stmt = null;//instanciando o preparador de comandos SQL
        
        try {//passando o comando INSET com variáveis dentro de VALUES(?,?,?)
           stmt = (PreparedStatementWrapper) con.prepareStatement("INSERT INTO moldura_preco(id,preco_custo,preco_venda)"
                   + "VALUES(?,?,?)");
           
           //Passando os valores das variáveis Respectivamente
           stmt.setInt(0, m.getId());
           stmt.setDouble(1, m.getPrecoCusto());
           stmt.setDouble(2, m.getPrecoVenda());
           
           stmt.executeUpdate();//executando o comando SQL. 
                                //Metodo executeUpdate é responsável pelos comandos DML(INSERT,UPDATE,DELETE)
        } catch (SQLException e) {
        }finally{//FECHANDO A CONEXÃO NO FINALLY PARA TER CERTEZA DE QUE ELA SERÁ FECHADA
            ConnectionFactory.closeConnection(con,stmt);
        }
    
    }
}
