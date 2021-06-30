/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgc;

import View.cadastro.CadMoldura;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Endereco;
import model.bean.Moldura;
import model.dao.ClienteDAO;
import model.dao.MolduraDAO;

/**
 *
 * @author felip
 */
public class SGC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* Cliente c = new Cliente();
        // c = dao.load(11);
        
        c.setId(22);
        c.setNome("aLICE.");
        c.setCpf("2222222222");
        c.setEmail("alicizi@gmail.com");
        List<String> lista = c.getListaTelefone();
        lista.add("2222-2212");
        lista.add("2222-2213");  
        c.setListaTelefone(lista);
        
        Endereco e = new Endereco();
        
        
        e.setBairro("Bairro Numero 22");
        e.setRua("Joaquim pereira 2");
        e.setComplemento("sem ");
        e.setNumero("2 2");
        c.getListaEndereco().add(e);
        
        Endereco en = new Endereco();
        
     
        en.setBairro("Sonho meu.");
        en.setRua("Pereira joaquim2 ");
        en.setComplemento("mes  .");
        en.setNumero("221");
        
        c.getListaEndereco().add(en);
        
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(c);*/
       Moldura m = new Moldura();
       
       m.setId("028-1011");
            m.setPrecoCusto(5.0);
            m.setPrecoVenda(12.0);
            m.setLarguraVara(3.0);
            m.setQuantMetros(160.0);
            m.setComprimentoVara(1.80);
            MolduraDAO dao = new MolduraDAO();
            try {
                dao.salvar(m);
                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar moldura em CadMoldura :"+ex);
                Logger.getLogger(CadMoldura.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        System.exit(0);
    }
    
}
