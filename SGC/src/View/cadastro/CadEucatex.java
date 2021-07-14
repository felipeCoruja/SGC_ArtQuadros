/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.cadastro;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Eucatex;
import model.dao.EucatexDAO;

/**
 *
 * @author Felipe
 */
public class CadEucatex extends javax.swing.JInternalFrame {

  
    private List<Eucatex> listaEucatex;
    private int row;
    
    public CadEucatex() {
        initComponents();
        try {
            this.listaEucatex = new EucatexDAO().load();
             this.loadTabela();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadEucatex.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        this.row = -1;
    }
    private boolean isCamposPreenchidos(){
        boolean flag = true;
        
        if(this.edtTipo.getText().isEmpty()){
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo 'Tipo' não foi preenchido","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }else if(this.edtAlturaChapa.getText().isEmpty()){
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo 'Altura Chapa' não foi preenchido","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }else if(this.edtComprimentoChapa.getText().isEmpty()){
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo 'Comprimento Chapa' não foi preenchido","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }else if(this.edtPrecoCusto.getText().isEmpty()){
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo 'Preço Custo' não foi preenchido","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }else if(this.spinQtdChapa.getValue().equals(0)){
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo 'Quantidade Chapas' não foi preenchido","ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return flag;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        edtTipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinQtdChapa = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        edtAlturaChapa = new javax.swing.JFormattedTextField();
        edtComprimentoChapa = new javax.swing.JFormattedTextField();
        edtPrecoCusto = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setText("Tipo");

        jLabel4.setText("Altura Chapa");

        jLabel6.setText("Preço Custo");

        jLabel7.setText("m²");

        jLabel9.setText("Quantidade Chapas");

        jLabel14.setText("m");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1486564412-plus_81511.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/diskette.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/lixo.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel15.setText("m");

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/broom.png"))); // NOI18N
        btnLimpar.setText("Limpar Campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Fornecedor");

        edtAlturaChapa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        edtComprimentoChapa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        edtPrecoCusto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Comprimento Chapa", "Altura Chapa", "Quantidade", "Preço Custo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Comprimento Chapa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(spinQtdChapa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(edtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(edtAlturaChapa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addGap(31, 31, 31)
                                        .addComponent(edtComprimentoChapa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtAlturaChapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(edtComprimentoChapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(edtPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(spinQtdChapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addGap(30, 30, 30))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cadastro de Eucatex");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    
    private void loadTabela() throws ClassNotFoundException{
        DefaultTableModel modelTable = (DefaultTableModel) this.tabela.getModel();
        modelTable.setNumRows(0);
        
        
        for(Eucatex e: this.listaEucatex){
            modelTable.addRow(new Object[]{
                e.getId(),
                e.getTipo(),
                e.getComprimentoChapa(),
                e.getAlturaChapa(),
                e.getQuantidadeChapas(),
                e.getPrecoCusto()
            });
        
        }
        
    }
    
    private void limparCampos(){
        this.edtTipo.setText("");
        this.edtAlturaChapa.setText("");
        this.edtComprimentoChapa.setText("");
        this.edtPrecoCusto.setText("");
        this.spinQtdChapa.setValue(0);
    }
    
    private String formatoStringDouble(String str){
        Pattern pattern = Pattern.compile("[.^]");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            str = str.replace(".", "");
        }
        str = str.replace(",", ".");
        return str;
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(isCamposPreenchidos()){
            Eucatex e = new Eucatex();
            String aux = "";
            
            aux = formatoStringDouble(this.edtAlturaChapa.getText());
            e.setAlturaChapa(Double.parseDouble(aux));
            
            aux = formatoStringDouble(this.edtAlturaChapa.getText());
            e.setComprimentoChapa(Double.parseDouble(aux));
            
            aux = formatoStringDouble(this.edtPrecoCusto.getText());
            e.setPrecoCusto(Double.parseDouble(aux));
            
            e.setTipo(this.edtTipo.getText());
            e.setQuantidadeChapas(Integer.parseInt(this.spinQtdChapa.getValue().toString()));
            
            EucatexDAO eDao = new EucatexDAO();
            try {
                eDao.salvar(e);
                this.listaEucatex = eDao.load();
                this.loadTabela();
                this.limparCampos();
                
                JOptionPane.showMessageDialog(null, "Salvo Com Sucesso!");
                
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Eucatex em CadEucatex :"+ex);
                Logger.getLogger(CadEucatex.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) this.tabela.getModel();
        try {
            if(this.row != -1){
                int value = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir o registro: "
                    +modelTable.getValueAt(this.row,0)+" "+modelTable.getValueAt(this.row,1), "ATENÇÂO",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
                if(value == JOptionPane.YES_OPTION){
                    EucatexDAO eDao = new EucatexDAO();
                    int id = (int) modelTable.getValueAt(row, 0);
                    eDao.delete(id);
                    modelTable.removeRow(this.row);
                    this.row = -1;
                    JOptionPane.showMessageDialog(null, "Deletado Com Sucesso!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir");
            }
            
           
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar registro!");
        }
           
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        this.row =  this.tabela.getSelectedRow();
    }//GEN-LAST:event_tabelaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField edtAlturaChapa;
    private javax.swing.JFormattedTextField edtComprimentoChapa;
    private javax.swing.JFormattedTextField edtPrecoCusto;
    private javax.swing.JTextField edtTipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinQtdChapa;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
