/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgc;

import model.bean.Cliente;
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
        
        c.setId(12);
        c.setNome("felipe");
        c.setCpf("12946670685");
        c.setEmail("felipemdb2@gmail.com");
        
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(c);
    }
    
}
