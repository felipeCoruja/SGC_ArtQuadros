/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;
import model.bean.Endereco;
import model.dao.ClienteDAO;

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
        dao.salvar(c);
        
        System.exit(0);
    }
    
}
