/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.busca.BuscarCliente;
import View.busca.BuscarFornecedor;
import View.busca.BuscarNota;
import View.cadastro.CadCliente;
import View.cadastro.CadCliente;
import View.cadastro.CadEucatex;
import View.cadastro.CadMoldura;
import View.cadastro.CadPedido;
import View.cadastro.CadPedidoFinal;
import View.cadastro.CadProduto;
import View.cadastro.CadVidro;
import View.home.Home;
import java.awt.Color;
import view.orcamento.Orcamento;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author felip
 */
public class TelaPrincipal extends javax.swing.JFrame {
    private Home home;
    private BuscarNota buscarNota;
    private CadCliente cadCliente;
    private CadEucatex cadEucatex;
    private CadMoldura cadMoldura;
    private CadVidro   cadVidro;
    private CadPedido  cadPedido;
    private CadPedidoFinal cadPedidoFinal;
    private CadProduto cadProduto;
    private Orcamento orcamento;
    private BuscarCliente buscarCliente;
    private BuscarFornecedor buscarFornecedor;
       
    Color azul = new java.awt.Color(51,164,235);
    Color black = Color.BLACK;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(){
        initComponents();
       
        
        
        home = new Home();
        
        
        this.setExtendedState(MAXIMIZED_BOTH);//PARA ABRIR A TELA PRINCIPAL MAXIMIZADA
        
        try {
            home.setMaximum(true);//para abrir o jInternalFrame Orcamento maximizado
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        this.menuHome.setForeground(azul);
        this.desktopPane.add(home);
        this.desktopPane.moveToFront(home);
        home.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        home.setLocation(0,0);
        ((BasicInternalFrameUI)this.home.getUI()).setNorthPane(null);//CODIGO PARA ESCONDER A BARRA SUPERIOR DO jInternalFrame
        home.setVisible(true);
    }
    
    public void destruirTelasExistentes(){
        desktopPane.removeAll();
        
        if(home != null){
            home.dispose();
            home = null;
        }else if(buscarNota != null){
            buscarNota.dispose();
            buscarNota = null;
        }else if(cadCliente != null){
            cadCliente.dispose();
            cadCliente = null;
        }else if(cadEucatex != null){
            cadEucatex.dispose();
            cadEucatex = null;
        }else if(cadMoldura != null){
            cadMoldura.dispose();
            cadMoldura = null;
        }else if(cadPedido != null){
            cadPedido.dispose();
            cadPedido = null;
        }else if(cadPedidoFinal != null){
            cadPedidoFinal.dispose();
            cadPedidoFinal = null;
        }else if(cadProduto != null){
            cadProduto.dispose();
            cadProduto = null;
        }else if(cadVidro != null){
            cadVidro.dispose();
            cadVidro = null;
        }else if(orcamento != null){
            orcamento.dispose();
            orcamento = null;
        }else if(buscarCliente != null){
            buscarCliente.dispose();
            buscarCliente = null;
        }else if(buscarFornecedor != null){
            buscarFornecedor.dispose();
            buscarFornecedor = null;
        }
    }
    
    private void setMenuOpaqueAll(Color cor){
       
        this.menuHome.setForeground(cor);
        this.menuNota.setForeground(cor);
        this.menuOrcamento.setForeground(cor);
        this.menuBusca.setForeground(cor);
        this.menuCadastro.setForeground(cor);
        this.menuEstoque.setForeground(cor);
        this.menuCaixa.setForeground(cor);
        this.menuConfiguracoes.setForeground(cor);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            
        } catch (InstantiationException ex) {
           
        } catch (IllegalAccessException ex) {
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuHome = new javax.swing.JMenu();
        menuNota = new javax.swing.JMenu();
        itemMenuNota = new javax.swing.JMenuItem();
        itemMenuFinalizarNota = new javax.swing.JMenuItem();
        menuOrcamento = new javax.swing.JMenu();
        menuBusca = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        menuEstoque = new javax.swing.JMenu();
        menuCaixa = new javax.swing.JMenu();
        menuConfiguracoes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(1200, 750));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        menuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/home.png"))); // NOI18N
        menuHome.setText("Home");
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
            }
        });
        menuBar.add(menuHome);

        menuNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/New_File_36861.png"))); // NOI18N
        menuNota.setText("Nota");

        itemMenuNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1492616984-7-docs-document-file-data-google-suits_83406.png"))); // NOI18N
        itemMenuNota.setText("Criar Nota");
        itemMenuNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuNotaActionPerformed(evt);
            }
        });
        menuNota.add(itemMenuNota);

        itemMenuFinalizarNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/file-complete256_25223.png"))); // NOI18N
        itemMenuFinalizarNota.setText("Finalizar");
        itemMenuFinalizarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFinalizarNotaActionPerformed(evt);
            }
        });
        menuNota.add(itemMenuFinalizarNota);

        menuBar.add(menuNota);

        menuOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/business-color_calculator_icon-icons.com_53466.png"))); // NOI18N
        menuOrcamento.setText("Orçamento");
        menuOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOrcamentoMouseClicked(evt);
            }
        });
        menuBar.add(menuOrcamento);

        menuBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/preview_search_find_locate_1551.png"))); // NOI18N
        menuBusca.setText("Busca");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1492616984-7-docs-document-file-data-google-suits_83406.png"))); // NOI18N
        jMenuItem1.setText("Nota");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuBusca.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/search user.png"))); // NOI18N
        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuBusca.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/user-male-icon_34332.png"))); // NOI18N
        jMenuItem3.setText("Fornecedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuBusca.add(jMenuItem3);

        menuBar.add(menuBusca);

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1486564412-plus_81511.png"))); // NOI18N
        menuCadastro.setText("Cadastro");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/add user.png"))); // NOI18N
        jMenuItem4.setText("Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/user-male-icon_34332.png"))); // NOI18N
        jMenuItem5.setText("Fornecedor");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem5);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/framework_theapplication_2896.png"))); // NOI18N
        jMenu1.setText("Materia Prima");

        jMenuItem7.setText("Moldura");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Eucatex");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Vidro");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        menuCadastro.add(jMenu1);

        menuBar.add(menuCadastro);

        menuEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/drawer_115243.png"))); // NOI18N
        menuEstoque.setText("Estoque");
        menuBar.add(menuEstoque);

        menuCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/cash_icon-icons.com_51090.png"))); // NOI18N
        menuCaixa.setText("Caixa");
        menuBar.add(menuCaixa);

        menuConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/settings.png"))); // NOI18N
        menuConfiguracoes.setText("Configurações");
        menuBar.add(menuConfiguracoes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuNotaActionPerformed
        
        this.setMenuOpaqueAll(black);
        this.menuNota.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadCliente = new CadCliente();
        TelaPrincipal.desktopPane.add(cadCliente);
        cadCliente.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadCliente.setLocation(0,0);
        this.cadCliente.setVisible(true);
        ((BasicInternalFrameUI)this.cadCliente.getUI()).setNorthPane(null);
    }//GEN-LAST:event_itemMenuNotaActionPerformed

    private void itemMenuFinalizarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFinalizarNotaActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuBusca.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.buscarNota = new BuscarNota();
        TelaPrincipal.desktopPane.add(buscarNota);
        buscarNota.setSize(TelaPrincipal.desktopPane.getWidth(), TelaPrincipal.desktopPane.getHeight());
        buscarNota.setLocation(0,0);
        this.buscarNota.setVisible(true);
        ((BasicInternalFrameUI)this.buscarNota.getUI()).setNorthPane(null);
    }//GEN-LAST:event_itemMenuFinalizarNotaActionPerformed

    private void menuOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOrcamentoMouseClicked
        this.setMenuOpaqueAll(black);
        this.menuOrcamento.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.orcamento = new Orcamento();
        TelaPrincipal.desktopPane.add(orcamento);
        orcamento.setSize(TelaPrincipal.desktopPane.getWidth(), TelaPrincipal.desktopPane.getHeight());
        orcamento.setLocation(0,0);
        this.orcamento.setVisible(true);
        ((BasicInternalFrameUI)this.orcamento.getUI()).setNorthPane(null);
    }//GEN-LAST:event_menuOrcamentoMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuBusca.setForeground(azul);
        
        this.destruirTelasExistentes();
        buscarCliente = new BuscarCliente();
        
        TelaPrincipal.desktopPane.add(buscarCliente);
        TelaPrincipal.desktopPane.moveToFront(buscarCliente);
        buscarCliente.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        buscarCliente.setLocation(0,0);
        ((BasicInternalFrameUI)this.buscarCliente.getUI()).setNorthPane(null);//CODIGO PARA ESCONDER A BARRA SUPERIOR DO jInternalFrame
        buscarCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        this.setMenuOpaqueAll(black);
        this.menuBusca.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.buscarFornecedor = new BuscarFornecedor();
        
        TelaPrincipal.desktopPane.add(buscarFornecedor);
        TelaPrincipal.desktopPane.moveToFront(buscarFornecedor);
        buscarFornecedor.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        buscarFornecedor.setLocation(0,0);
        ((BasicInternalFrameUI)this.buscarFornecedor.getUI()).setNorthPane(null);//CODIGO PARA ESCONDER A BARRA SUPERIOR DO jInternalFrame
        buscarFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        this.setMenuOpaqueAll(black);
        this.menuHome.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.home = new Home();
        
        TelaPrincipal.desktopPane.add(home);
        TelaPrincipal.desktopPane.moveToFront(home);
        home.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        home.setLocation(0,0);
        ((BasicInternalFrameUI)this.home.getUI()).setNorthPane(null);//CODIGO PARA ESCONDER A BARRA SUPERIOR DO jInternalFrame
        home.setVisible(true);
    }//GEN-LAST:event_menuHomeMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuBusca.setForeground(azul);
        
        this.destruirTelasExistentes();
        
        this.buscarNota = new BuscarNota();
        
        TelaPrincipal.desktopPane.add(buscarNota);
        buscarNota.setSize(TelaPrincipal.desktopPane.getWidth(),TelaPrincipal.desktopPane.getHeight());
        buscarNota.setLocation(0,0);
        ((BasicInternalFrameUI)this.buscarNota.getUI()).setNorthPane(null);
        buscarNota.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuCadastro.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadCliente = new CadCliente();
        TelaPrincipal.desktopPane.add(cadCliente);
        cadCliente.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadCliente.setLocation(0,0);
        this.cadCliente.setVisible(true);
        ((BasicInternalFrameUI)this.cadCliente.getUI()).setNorthPane(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        /*
        this.setMenuOpaqueAll(black);
        this.menuCadastro.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadFornecedor = new CadFornecedor();
        TelaPrincipal.desktopPane.add(cadFornecedor);
        cadFornecedor.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadFornecedor.setLocation(0,0);
        this.cadFornecedor.setVisible(true);
        ((BasicInternalFrameUI)this.cadFornecedor.getUI()).setNorthPane(null);
        */
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuCadastro.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadMoldura = new CadMoldura();
        TelaPrincipal.desktopPane.add(cadMoldura);
        cadMoldura.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadMoldura.setLocation(0,0);
        this.cadMoldura.setVisible(true);
        ((BasicInternalFrameUI)this.cadMoldura.getUI()).setNorthPane(null);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuCadastro.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadEucatex = new CadEucatex();
        TelaPrincipal.desktopPane.add(cadEucatex);
        cadEucatex.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadEucatex.setLocation(0,0);
        this.cadEucatex.setVisible(true);
        ((BasicInternalFrameUI)this.cadEucatex.getUI()).setNorthPane(null);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        this.setMenuOpaqueAll(black);
        this.menuCadastro.setForeground(azul);
        
        this.destruirTelasExistentes();
        this.cadVidro = new CadVidro();
        TelaPrincipal.desktopPane.add(cadVidro);
        cadVidro.setSize(desktopPane.getWidth(),desktopPane.getHeight());
        cadVidro.setLocation(0,0);
        this.cadVidro.setVisible(true);
        ((BasicInternalFrameUI)this.cadVidro.getUI()).setNorthPane(null);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemMenuFinalizarNota;
    private javax.swing.JMenuItem itemMenuNota;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBusca;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JMenu menuEstoque;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuNota;
    private javax.swing.JMenu menuOrcamento;
    // End of variables declaration//GEN-END:variables
}
