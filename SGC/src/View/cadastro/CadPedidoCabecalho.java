/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.cadastro;

import View.TelaPrincipal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.bean.Endereco;
import model.bean.Nota;
import model.dao.NotaDAO;
import model.document.LimitaCampoSemEspaco;

/**
 *
 * @author Felipe
 */
public class CadPedidoCabecalho extends javax.swing.JInternalFrame {
    private List<String> listaTelefone;
    private List<Endereco> listaEndereco;
    private int idTelCel;
    private int rowContatos;
    private int rowEnderecos;
    private List<Object> dadosResultado; 
    private List<Object> dadosCalculo; 
    private List<String> dadosTemporarios;
    private Nota nota;
    
    private String maskCpf;
    private String maskCnpj;
    private String maskInsc;
    /**
     * Creates new form CadCliente
     * @param dadosRes
     * @param dadosCalc
     * @param listaEnd
     * @param dadosTemp
     * @param listaTel
     */
    public CadPedidoCabecalho(List<Object> dadosRes, List<Object> dadosCalc,List<String> dadosTemp,
                            List<Endereco> listaEnd,List<String> listaTel) {
        initComponents();
        this.idTelCel = 0;
        this.listaEndereco = listaEnd;
        this.listaTelefone = listaTel;
        this.rowContatos = -1;
        this.rowEnderecos = -1;
        this.cboxUf.setSelectedIndex(12);//MG
        this.dadosResultado = dadosRes;
        this.dadosCalculo = dadosCalc;
        this.dadosTemporarios = dadosTemp;
        this.nota = new Nota();
        
        maskCpf = this.edtCpf.getText();
        maskCnpj = this.edtCnpj.getText();
        maskInsc = this.edtInscEstadual.getText();
        
        this.edtEmail.setDocument(new LimitaCampoSemEspaco(50));
        
        getIdNota();
        
        if(!this.dadosTemporarios.isEmpty()){
            setDadosInseridos();
        }
        
        if(!this.listaTelefone.isEmpty()){
            insereListaTelefoneNaTabela();
        }
        
        if(!this.listaEndereco.isEmpty()){
            insereListaEnderecoNaTabela();
        }
    }

    private void getIdNota() {
        NotaDAO nDao = new NotaDAO();
        try {
            this.edtId.setText(nDao.getIdProximaNota());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadPedidoCabecalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getDadosInseridos(){
        this.dadosTemporarios.clear();
        
        this.dadosTemporarios.add(this.edtNome.getText());
        this.dadosTemporarios.add(this.edtEmail.getText());
        this.dadosTemporarios.add(removeMask(this.edtCpf.getText()));
        this.dadosTemporarios.add(removeMask(this.edtCnpj.getText()));
        this.dadosTemporarios.add(removeMask(this.edtInscEstadual.getText()));

        this.dadosTemporarios.add(this.cboxUf.getSelectedIndex()+"");
        this.dadosTemporarios.add(this.edtCidade.getText());
        this.dadosTemporarios.add(this.edtBairro.getText());
        this.dadosTemporarios.add(this.edtRua.getText());
        this.dadosTemporarios.add(this.edtComplemento.getText());
        this.dadosTemporarios.add(this.edtNumero.getText());
        this.dadosTemporarios.add(this.edtReferencia.getText());
    }
    
    public void setDadosInseridos(){
        this.edtNome.setText(this.dadosTemporarios.get(0));
        this.edtEmail.setText(this.dadosTemporarios.get(1));
        
        this.edtCpf.setText(this.dadosTemporarios.get(2));
        this.edtCnpj.setText(this.dadosTemporarios.get(3));
        this.edtInscEstadual.setText(this.dadosTemporarios.get(4));
        
        this.cboxUf.setSelectedIndex(Integer.parseInt(this.dadosTemporarios.get(5)));
        this.edtCidade.setText(this.dadosTemporarios.get(6));
        this.edtBairro.setText(this.dadosTemporarios.get(7));
        this.edtRua.setText(this.dadosTemporarios.get(8));
        this.edtComplemento.setText(this.dadosTemporarios.get(9));
        this.edtNumero.setText(this.dadosTemporarios.get(10));
        this.edtReferencia.setText(this.dadosTemporarios.get(11));
    }
    
    private void insereListaTelefoneNaTabela(){
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaContatos.getModel();
        
        for(int i =0;i<listaTelefone.size();i++){
            String[] vet = listaTelefone.get(i).split(";");
            if(vet.length == 2){
                tableModel.addRow(new Object[]{i+1,vet[0],vet[1]});
            }else{
                tableModel.addRow(new Object[]{i+1,vet[0],""});
            }
            
        }
    
    }
    
    private void insereListaEnderecoNaTabela(){
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaEnderecos.getModel();
       
        for(int i=0;i<this.listaEndereco.size();i++){
            tableModel.addRow(new Object[]{
                this.listaEndereco.get(i).getCidade(),
                this.listaEndereco.get(i).getBairro(),
                this.listaEndereco.get(i).getRua(),
                this.listaEndereco.get(i).getNumero(),
                this.listaEndereco.get(i).getComplemento() 
            });
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        edtCpf = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        edtCnpj = new javax.swing.JFormattedTextField();
        edtInscEstadual = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxUf = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        edtCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edtRua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtComplemento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtReferencia = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEnderecos = new javax.swing.JTable();
        btnAddEndereco = new javax.swing.JButton();
        btnRemoveEndereco = new javax.swing.JButton();
        btnEditEndereco = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaContatos = new javax.swing.JTable();
        edtTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        edtDescricao = new javax.swing.JTextField();
        btnAdicionarNumero = new javax.swing.JButton();
        btnRemoverNumero = new javax.swing.JButton();
        edtCelular = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        edtId = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAvancar = new javax.swing.JButton();
        btnLimparDados = new javax.swing.JButton();
        btnLimparDados2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("NOTA N°");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Nome:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, -1));
        jPanel3.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 241, -1));

        jLabel10.setText("CPF: ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 85, -1, -1));

        try {
            edtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(edtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 105, 101, -1));

        jLabel11.setText("CNPJ: ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 85, -1, -1));

        try {
            edtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCnpjActionPerformed(evt);
            }
        });
        jPanel3.add(edtCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 105, 122, -1));

        try {
            edtInscEstadual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtInscEstadual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtInscEstadualActionPerformed(evt);
            }
        });
        jPanel3.add(edtInscEstadual, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 105, 122, -1));

        jLabel12.setText("Insc. Estadual: ");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 85, -1, -1));

        jLabel13.setText("E-mail: ");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 22, -1, -1));
        jPanel3.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 44, 180, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereços"));

        jLabel2.setText("UF:");

        cboxUf.setModel(new javax.swing.DefaultComboBoxModel<>(this.uf()));
        cboxUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxUfActionPerformed(evt);
            }
        });

        jLabel3.setText("Cidade:");

        jLabel4.setText("Bairro");

        jLabel5.setText("Rua: ");

        jLabel6.setText("Complemento:");

        jLabel7.setText("Numero:");

        jLabel14.setText("Referência:");

        edtReferencia.setColumns(20);
        edtReferencia.setRows(5);
        jScrollPane1.setViewportView(edtReferencia);

        tabelaEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade", "Bairro", "Rua", "Numero", "Complemento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEnderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEnderecosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaEnderecos);

        btnAddEndereco.setBackground(new java.awt.Color(31, 132, 61));
        btnAddEndereco.setText("Adicionar Endereço");
        btnAddEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEnderecoActionPerformed(evt);
            }
        });

        btnRemoveEndereco.setBackground(new java.awt.Color(250, 95, 99));
        btnRemoveEndereco.setText("Remover Endereço");
        btnRemoveEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEnderecoActionPerformed(evt);
            }
        });

        btnEditEndereco.setBackground(new java.awt.Color(68, 144, 196));
        btnEditEndereco.setText("Editar Endereço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(edtRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(cboxUf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(edtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddEndereco)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveEndereco)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditEndereco))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEndereco)
                            .addComponent(btnRemoveEndereco)
                            .addComponent(btnEditEndereco))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Número", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelaContatos);

        try {
            edtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTelefoneActionPerformed(evt);
            }
        });

        jLabel9.setText("Telefone:");

        jLabel15.setText("Descrição");

        btnAdicionarNumero.setBackground(new java.awt.Color(31, 132, 61));
        btnAdicionarNumero.setText("Adicionar");
        btnAdicionarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarNumeroActionPerformed(evt);
            }
        });

        btnRemoverNumero.setBackground(new java.awt.Color(250, 95, 99));
        btnRemoverNumero.setText("Remover");
        btnRemoverNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverNumeroActionPerformed(evt);
            }
        });

        try {
            edtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCelularActionPerformed(evt);
            }
        });

        jLabel16.setText("Celular:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(edtDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverNumero))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarNumero)
                    .addComponent(btnRemoverNumero)
                    .addComponent(edtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        edtId.setEditable(false);
        edtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/share.png"))); // NOI18N
        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnLimparDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/broom.png"))); // NOI18N
        btnLimparDados.setText("Limpar Dados");

        btnLimparDados2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/delete-file_40456.png"))); // NOI18N
        btnLimparDados2.setText("Cancelar Nota");
        btnLimparDados2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDados2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAvancar)
                .addGap(18, 18, 18)
                .addComponent(btnLimparDados)
                .addGap(18, 18, 18)
                .addComponent(btnLimparDados2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvancar)
                    .addComponent(btnLimparDados)
                    .addComponent(btnLimparDados2))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCnpjActionPerformed

    private void edtInscEstadualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtInscEstadualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtInscEstadualActionPerformed

    private void edtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTelefoneActionPerformed

    private void edtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCelularActionPerformed
     
    private boolean isCamposVazios() {//apenas os campos necessários, nome,telefone/celular,e um endereço
        
        if(this.edtNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O Campo 'Nome' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(listaTelefone.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira um número de telefone ou celular para concluir o cadastro", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }else if(this.listaEndereco.isEmpty()){ 
            JOptionPane.showMessageDialog(null, "Insira um endereço para concluir o cadastro", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed

       // if(isCamposVazios()){
            
            getDadosInseridos();
            montarNota();
            
            setVisible(false);
            CadPedido cadPedido = new CadPedido(dadosResultado,dadosCalculo,dadosTemporarios,listaEndereco,listaTelefone,nota);
            TelaPrincipal.desktopPane.add(cadPedido);
            cadPedido.setSize(TelaPrincipal.desktopPane.getWidth(), TelaPrincipal.desktopPane.getHeight());
            cadPedido.setLocation(0,0);
            cadPedido.setVisible(true);
            ((BasicInternalFrameUI)cadPedido.getUI()).setNorthPane(null);
            dispose();
        //}
        
    }//GEN-LAST:event_btnAvancarActionPerformed
    
    
    private void montarNota(){
        this.nota.getCliente().setNome(this.edtNome.getText());
        if(!this.edtCpf.getText().equals(maskCpf)){
            this.nota.getCliente().setCpf(this.edtCpf.getText());
        }
        
        if(!this.edtCnpj.getText().equals(maskCnpj)){
            this.nota.getCliente().setCnpj(this.edtCnpj.getText());
        }
        if(!this.edtInscEstadual.getText().equals(maskInsc)){
            this.nota.getCliente().setInscEstadual(this.edtInscEstadual.getText());
        }
        
        this.nota.getCliente().setEmail(this.edtEmail.getText());
        
        this.nota.getCliente().setListaEndereco(this.listaEndereco);
        this.nota.getCliente().setListaTelefone(this.listaTelefone);//Cada String da lista segue o modelo >> "numero;descricao;"
    }
    
    private String removeMask(String str){
        str = str.replace("(", "");
        str = str.replace(")", "");
        str = str.replace("/", "");
        str = str.replace("-", "");
        str = str.replace(".", "");
        str = str.replace(",", "");
        str = str.replace(" ", "");
        return str;
    }
    
    private void btnAdicionarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarNumeroActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) this.tabelaContatos.getModel();

        String tel = "";
        String cel = "";
        String desc = "";
        String registro = "";
        String aux = "";
        
        aux = this.removeMask(this.edtTelefone.getText());
        if(!aux.isEmpty()){
            tel = this.edtTelefone.getText();
            desc = this.edtDescricao.getText();
            registro = tel+";"+desc+";";
       
            this.listaTelefone.add(registro);
            if(idTelCel == 0){
                idTelCel =1;
            }
            modelTable.addRow(new Object[]{idTelCel,tel,desc});
            idTelCel++;
        }
        
        System.out.println("***");
        aux = this.removeMask(this.edtCelular.getText());
        if(!aux.isEmpty()){
            System.out.println("////");
            cel = this.edtCelular.getText();
            desc = this.edtDescricao.getText();
            registro = cel+";"+desc+";";
            this.listaTelefone.add(registro);
            
            if(idTelCel == 0){
                idTelCel =1;
            }
            
            modelTable.addRow(new Object[]{idTelCel,cel,desc});
            idTelCel++;
        }
        
        this.edtTelefone.setText("");
        this.edtCelular.setText("");
        this.edtDescricao.setText("");
    }//GEN-LAST:event_btnAdicionarNumeroActionPerformed

    private void btnRemoverNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverNumeroActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) this.tabelaContatos.getModel();
        if(this.rowContatos != -1){
            JOptionPane.showMessageDialog(null, "Contato "+modelTable.getValueAt(rowContatos, 1)+" Removido");
            modelTable.removeRow(rowContatos);
            this.listaTelefone.remove(this.rowContatos);
            this.rowContatos = -1;
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir!", "Atenção", JOptionPane.WARNING_MESSAGE);
            
        }
                
    }//GEN-LAST:event_btnRemoverNumeroActionPerformed

    private void tabelaContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatosMouseClicked
        this.rowContatos = this.tabelaContatos.getSelectedRow();
    }//GEN-LAST:event_tabelaContatosMouseClicked

    private boolean isCamposEnderecoVazios(){
        boolean flag = false;
        
        if(this.edtCidade.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Cidade' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtBairro.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, "O Campo 'Bairro' Está Vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtRua.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Rua' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtNumero.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Número' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return flag;
    }
    
    private boolean isCamposEnderecosVazios(){
        boolean flag = false;
        
        if(this.edtCidade.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Cidade' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtBairro.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Bairro' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtRua.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Rua' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else if(this.edtNumero.getText().isEmpty()){
            flag = true;
            JOptionPane.showMessageDialog(null, " O Campo 'Número' está vazio!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        
        return flag;
    }
    private void btnAddEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEnderecoActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) this.tabelaEnderecos.getModel();
        
        if(this.isCamposEnderecosVazios() == false){
            Endereco endereco = new Endereco();
            
            endereco.setUf(this.cboxUf.getSelectedItem().toString());
            endereco.setCidade(this.edtCidade.getText());
            endereco.setBairro(this.edtBairro.getText());
            endereco.setRua(this.edtRua.getText());
            endereco.setComplemento(this.edtComplemento.getText());
            endereco.setNumero(this.edtNumero.getText());
            endereco.setReferencia(this.edtReferencia.getText());
            
            this.listaEndereco.add(endereco);
            
            modelTable.addRow(new Object[]{
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento() 
            });
        }
    }//GEN-LAST:event_btnAddEnderecoActionPerformed

    private void cboxUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxUfActionPerformed

    private void tabelaEnderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEnderecosMouseClicked
        this.rowEnderecos = this.tabelaEnderecos.getSelectedRow();
    }//GEN-LAST:event_tabelaEnderecosMouseClicked
    
    private void limparCamposEndereco(){
        this.cboxUf.setSelectedIndex(12);
        this.edtCidade.setText("Ubá");
        this.edtBairro.setText("");
        this.edtRua.setText("");
        this.edtComplemento.setText("");
        this.edtNumero.setText("");
        this.edtReferencia.setText("");
    }
    private void btnRemoveEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEnderecoActionPerformed
        DefaultTableModel modelTable = (DefaultTableModel) this.tabelaEnderecos.getModel();
        
        if(this.rowEnderecos != -1){
            modelTable.removeRow(this.rowEnderecos);
          
            this.listaEndereco.remove(this.rowEnderecos);
            this.limparCamposEndereco();
            this.rowEnderecos = -1;
        }
    }//GEN-LAST:event_btnRemoveEnderecoActionPerformed

    private void btnLimparDados2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDados2ActionPerformed
        
    }//GEN-LAST:event_btnLimparDados2ActionPerformed

    private String[] uf(){
       return new String[]{"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE",
                            "PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEndereco;
    private javax.swing.JButton btnAdicionarNumero;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnEditEndereco;
    private javax.swing.JButton btnLimparDados;
    private javax.swing.JButton btnLimparDados2;
    private javax.swing.JButton btnRemoveEndereco;
    private javax.swing.JButton btnRemoverNumero;
    private javax.swing.JComboBox<String> cboxUf;
    private javax.swing.JTextField edtBairro;
    private javax.swing.JFormattedTextField edtCelular;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JFormattedTextField edtCnpj;
    private javax.swing.JTextField edtComplemento;
    private javax.swing.JFormattedTextField edtCpf;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtId;
    private javax.swing.JFormattedTextField edtInscEstadual;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextArea edtReferencia;
    private javax.swing.JTextField edtRua;
    private javax.swing.JFormattedTextField edtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaContatos;
    private javax.swing.JTable tabelaEnderecos;
    // End of variables declaration//GEN-END:variables

    public List<String> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<String> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

   
}
