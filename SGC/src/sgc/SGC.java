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
        
        c.setId(50);
        c.setNome("JO10A7");
        c.setCpf("94400661A");
        c.setEmail("AAoao197@gmail.com");
        List<String> lista = c.getListaTelefone();
        lista.add("A119-0132");
        lista.add("A449-0192");  
        c.setListaTelefone(lista);
        
        Endereco e = new Endereco();
        
        e.setBairro("AAa bernadete2");
        e.setRua("mary martins 2");
        e.setComplemento("sem coAAmpento2");
        e.setNumero("AA5B");
        c.getListaEndereco().add(e);
        
        Endereco en = new Endereco();
        
        en.setBairro("saBBta");
        en.setRua("maurBBy ");
        en.setComplemento("seBm ");
        en.setNumero("2BBBC");
        
        c.getListaEndereco().add(en);
        
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(c);
        
        System.exit(0);
    }
    
}
