/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import model.bean.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author felip
 */
public class NotaDAO {
    
    public void salvar(Nota n) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            //salva cliente e suas dependencias como contato, endereço e relações entre eles
            ClienteDAO cDao = new ClienteDAO();
            cDao.salvar(n.getCliente());
            n.getCliente().setId(cDao.getId());//cDao.getId() pega o ultimo id cadastrado na tabela cliente_nome
            
            //salva nota e suas dependencias 
            this.salvarNota(n);
            
            this.salvarRelacaoNotaCliente(n);
            
            //salva pedido e suas dependências como moldura,vidro,eucatex e relações entre os eles
            PedidoDAO pDao = new PedidoDAO();
            pDao.salvar(n.getListaPedido());
            
           
            this.salvarRelacaoNotaPedido(n);
            
        } catch (ClassNotFoundException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void salvarNota(Nota n) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO nota(id,data_entrega,data_da_nota,desconto,"
                                      + "valor_total,valor_entrada,forma_pagamento,descricao)"
                                      + " VALUES(?,?,?,?,?,?,?,?)");
            
            stmt.setInt(1, n.getId());
            stmt.setString(2, n.getDataEntrega());
            stmt.setString(3, n.getDataNota());
            stmt.setInt(4, n.getDesconto());
            stmt.setDouble(5, n.getValorTotal());
            stmt.setDouble(6, n.getValorEntrada());
            stmt.setString(7, n.getFormaPagamento());
            stmt.setString(8, n.getDescricao());
            
            stmt.executeUpdate();
            stmt = null;
            
            //INSERT TABELA nota_status
            stmt = con.prepareStatement("INSERT INTO nota_status(id,status_pagamento) "
                                        + "VALUES(?,?)");
            stmt.setInt(1, n.getId());
            stmt.setString(2, n.getStatusPagamento());
   
            stmt.executeUpdate();
            stmt = null;
            
            //INSERT NA TABELA contador_nota
            stmt = con.prepareStatement("INSERT INTO contador_nota(id) VALUE(?)");
            stmt.setInt(1, n.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro em salvarNota() na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    private void salvarRelacaoNotaCliente(Nota n) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            //INSERT NA TABELA DE RELAÇÃO nota_cliente
            stmt = con.prepareStatement("INSERT INTO nota_cliente(id_nota,id_cliente)VALUES(?,?)");
            stmt.setInt(1, n.getId());
            stmt.setInt(2, n.getCliente().getId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void salvarRelacaoNotaPedido(Nota n) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
    
        
        try {
            
            for(int i=0;i<n.getListaPedido().size();i++){
                //INSERT NA TABELA DE RELAÇÃO nota_pedido
                stmt = con.prepareStatement("INSERT INTO nota_pedido(id_nota,id_pedido)VALUES(?,?)");
                stmt.setInt(1, n.getId());
                stmt.setInt(2, n.getListaPedido().get(i).getId());

                stmt.executeUpdate();
            }
            
        } catch (SQLException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro ao salvar Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    public List<Nota> load() throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Nota> lista = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM nota AS n JOIN nota_status AS ns ON n.id = ns.id ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Nota n = new Nota();
                
                n.setId(rs.getInt("n.id"));
                n.setDataEntrega(rs.getString("data_entrega"));
                n.setDataNota(rs.getString("data_da_nota"));
                n.setDesconto(rs.getInt("desconto"));
                n.setValorTotal(rs.getDouble("valor_total"));
                n.setValorEntrada(rs.getDouble("valor_entrada"));
                n.setFormaPagamento(rs.getString("forma_pagamento"));
                n.setStatusPagamento(rs.getString("status_pagamento"));
                n.setDataEncerramento(rs.getString("data_encerramento"));
                n.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro de Load da Nota na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return lista;
    }
    
    public void updateDataEncerramento(int id, String data) throws ClassNotFoundException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE nota SET data_encerramento = ? WHERE id = ?");
            stmt.setString(1, data);
            stmt.setInt(2, id);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Erro de Update data_encerramento na Classe NotaDAO :"+e);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
    
    public String getIdProximaNota() throws ClassNotFoundException{
        String str = "-1";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM contador_nota ORDER BY id DESC LIMIT 1");
            rs = stmt.executeQuery();
            
            if(rs.next()){
                int ultimoId = rs.getInt("id");
                int proximoId = ultimoId + 1;
                
                if(proximoId <10){
                    str = "00"+proximoId;
                }else if(proximoId <100){
                    str = "0"+proximoId;
                }
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return str;
    }
    
    public List<Object[]> buscarNota(String valueWhere, String value) throws ClassNotFoundException{
        List<Object[]> lista = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT n.id,cn.nome, n.valor_total,n.data_da_nota,n.data_entrega," +
                    "t.numero, ns.status_pagamento, cc.cpf,cnpj.cnpj,cInsc.insc_estadual,cm.email " +
                    "FROM nota AS n left JOIN nota_cliente as nc ON nc.id_nota = n.id " +
                    "left JOIN cliente_nome AS cn ON nc.id_cliente = cn.id " +
                    "left join nota_status AS ns on ns.id = n.id " +
                    "left join telefone as t on t.id = cn.id " +
                    "left join cliente_cpf AS cc ON cc.id = cn.id " +
                    "left join cliente_cnpj AS cnpj ON cnpj.id = cn.id " +
                    "left join cliente_insc_estadual AS cInsc ON cInsc.id = cn.id " +
                    "left join cliente_email AS cm ON cm.id = cn.id " +
                    "where "+valueWhere+" = ?");
           // stmt.setString(1, valueWhere);
            stmt.setString(1, value);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                int cont = -1;
                String tel = "";
                do{
                    if(cont != rs.getInt("n.id")){//para evitar linhas duplicadas por conta do telefone que é multivalorado no Banco de Dados
                        
                    
                        lista.add(new Object[]{rs.getInt("n.id"),rs.getString("cn.nome"),rs.getString("t.numero"),
                                            rs.getString("n.valor_total"),formataData(rs.getString("n.data_da_nota")),
                                            formataData(rs.getString("n.data_entrega")),
                                            rs.getString("ns.status_pagamento")});
                        cont = rs.getInt("n.id");
                        tel = rs.getString("t.numero");
                        
                    }else{
                        Object[] ob = (Object[])lista.get(lista.size()-1);;
                        String aux = ob[2]+"\n "+rs.getString("t.numero");   
                        
                        ob[2] = formataQuebraDeLinha(aux);
                        lista.set(lista.size()-1,ob);
                    }
                    
                }while(rs.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return lista;
    }
    
    private String formataData(String data){
        String[] vet = data.split("-");
        String dataFormatada = vet[2]+" / "+vet[1]+" / "+vet[0];
        return dataFormatada;
    }
    
    private String formataQuebraDeLinha(String aux){
        aux = aux.replaceAll("<html>", "");
        aux = aux.replaceAll("</html>", "");
        
        StringBuilder str = new StringBuilder();
        str.append("<html>");
        str.append(aux.replaceAll("\n", "<br>"));
        str.append("</html>");
        return str.toString();
    }
}
