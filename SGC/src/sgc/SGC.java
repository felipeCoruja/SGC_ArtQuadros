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
        Cliente c = new Cliente();
        // c = dao.load(11);
        
        c.setId(108);
        c.setNome("aLIkCE.");
        c.setCpf("222922222");
        c.setEmail("aliczi@g7ail.com");
        List<String> lista = c.getListaTelefone();
        lista.add("2722-2212;felipe CAsa;");
        lista.add("2282-2213;whatsapp;");  
        c.setListaTelefone(lista);
        
        Endereco e = new Endereco();
        
        
        e.setBairro("Bairrmero 22");
        e.setRua("Joaqim pereira 2");
        e.setComplemento("sm ");
        e.setNumero("8 2");
        c.getListaEndereco().add(e);
        
        Endereco en = new Endereco();
        
     
        en.setBairro("Sono meu.");
        en.setRua("Perei joaquim2 ");
        en.setComplemento("me  .");
        en.setNumero("821");
        
        c.getListaEndereco().add(en);
        
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(c);
       Moldura m = new Moldura();
       /*
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
        */
        System.exit(0);
    }
    
}
