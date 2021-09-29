/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.orcamento;

import View.TelaPrincipal;
import static View.TelaPrincipal.desktopPane;
import View.cadastro.CadPedidoCabecalho;
import java.awt.Color;
import static java.awt.Color.black;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.bean.Config;
import model.bean.Moldura;
import model.dao.ConfigDAO;
import model.dao.EucatexDAO;
import model.dao.MolduraDAO;
import model.dao.VidroDAO;

/**
 *
 * @author felip
 */
public class Orcamento extends javax.swing.JInternalFrame {

    private int rowPasp;
    private int row;
    private List<String> listaPasp;
    private Object[] valorDoUltimoCalculo;
    private Object[] dadosDoUltimoCalculo;
    private List<Object> dadosDeResultado;// todos os resultados do calculo feito
    private List<Object> dadosDeCalculo; // todos os dados de configurações necessários para o calculo de um pedido

    public Orcamento() {
        initComponents();
        
        
        this.dadosDeResultado = new ArrayList<>();
        SpinnerNumberModel model = new SpinnerNumberModel(1,1,500,1);//(valor padrao,valor min,valor max,passo)
        this.spinQtd.setModel(model);
        this.dadosDeCalculo = new ArrayList<>();
        this.dadosDeResultado = new ArrayList<>();
        this.valorDoUltimoCalculo = null;
        this.dadosDoUltimoCalculo = null;
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPrincipal.getModel();
        tableModel.setNumRows(0);
        this.listaPasp = new ArrayList<>();
        ConfigDAO cDao = new ConfigDAO();
        try {
            model.bean.Config c = cDao.load();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.rowPasp = -1;
        this.row = -1;
    }

    private String[] listaMolduras() {
        MolduraDAO dao = new MolduraDAO();
        String[] list = null;
        try {
            list = dao.getIdsMolduras();
            if (list.length < 1) {//Sem ter o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "ERRO - O sistema não achou molduras registradas no Banco de Dados ");
                String aux = "Sem Registro;";
                list = aux.split(";");
            } else if (list.length == 1) {//contendo apena o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "O sistema não achou molduras registradas no Banco de Dados ");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private String[] listaEucatex() {
        EucatexDAO dao = new EucatexDAO();
        String[] list = null;
        try {
            list = dao.getTiposEucatex();
            if (list.length < 1) {//Sem ter o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "ERRO - O sistema não achou Eucatex registrados no Banco de Dados ");
                String aux = "Sem Registro;";
                list = aux.split(";");
            } else if (list.length == 1) {//contendo apena o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "O sistema não achou Eucatex registrados no Banco de Dados ");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private String[] listaVidros() {
        VidroDAO dao = new VidroDAO();
        String[] list = null;
        try {
            list = dao.getTiposVidro();
            if (list.length < 1) {//Sem ter o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "ERRO - O sistema não achou Vidros registrados no Banco de Dados ");
                String aux = "Sem Registro;";
                list = aux.split(";");
            } else if (list.length == 1) {//contendo apena o registro padrao "Não"
                JOptionPane.showMessageDialog(null, "O sistema não achou Vidros registrados no Banco de Dados ");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private double calculaVidro(double alt, double larg, double precoVidro) {
        double valor = alt * larg * precoVidro;
        return valor;
    }

    private double calculaMoldura(double alt, double larg, double precoMoldura) {
        double porcentagem = 0;
        double valor = ((alt + larg) * 2) * precoMoldura;
        valor = valor + (valor * porcentagem);
        return valor;
    }

    private double calculaEucatex(double alt, double larg, double precoEucatex) {
        double valor = alt * larg * precoEucatex;
        return valor;
    }

    private List<String> getPaspatus() {
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        List<String> lista = new ArrayList<>();

        for (int i = 0; i < this.tabelaPaspatu.getRowCount(); i++) {
            lista.add(tableModel.getValueAt(i, 1).toString());
        }
        return lista;
    }

    private void limparCampos(){
        this.cboxTipo.setSelectedIndex(0);
        this.cboxMoldura.setSelectedIndex(0);
        this.edtLargura.setText("");
        this.edtAltura.setText("");
        
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        tableModel.setNumRows(0);
        
        this.cbVidro.setSelected(false);
        this.cboxVidro.setSelectedIndex(0);
        this.cbEucatex.setSelected(false);
        this.cboxEucatex.setSelectedIndex(0);
        this.cbEntreVidros.setSelected(false);
        this.cboxEntreVidros.setSelectedIndex(0);
        
        this.spinQtd.setValue(1);
        this.edtCampoCalcular.setText("");
        this.edtDescricao.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        cboxTipo = new javax.swing.JComboBox<>();
        cboxMoldura = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxPaspatu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        edtLargura = new javax.swing.JTextField();
        edtAltura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spinQtd = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtDescricao = new javax.swing.JTextArea();
        edtCampoCalcular = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPaspatu = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cbVidro = new javax.swing.JCheckBox();
        cbEucatex = new javax.swing.JCheckBox();
        cbEntreVidros = new javax.swing.JCheckBox();
        cboxVidro = new javax.swing.JComboBox<>();
        cboxEntreVidros = new javax.swing.JComboBox<>();
        cboxEucatex = new javax.swing.JComboBox<>();
        btnAddPasp = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnRemovePasp = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPrincipal = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnNovaNota = new javax.swing.JButton();
        btnLimparTabela = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();

        setMaximizable(true);
        setResizable(true);

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaMolduras()));
        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"tipo"}));

        cboxMoldura.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaMolduras()));
        cboxMoldura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMolduraActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo");

        jLabel3.setText("Moldura");

        cboxPaspatu.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaMolduras()));

        jLabel4.setText("Paspatu");

        edtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtAlturaActionPerformed(evt);
            }
        });

        jLabel5.setText("X");

        jLabel6.setText("Largura(cm)");

        jLabel7.setText("Altura(cm)");

        jLabel8.setText("Quantidade");

        jLabel9.setText("R$");

        jLabel10.setText("Descrição");

        edtDescricao.setColumns(20);
        edtDescricao.setRows(5);
        jScrollPane1.setViewportView(edtDescricao);

        edtCampoCalcular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        tabelaPaspatu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Moldura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPaspatu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPaspatuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaPaspatu);
        if (tabelaPaspatu.getColumnModel().getColumnCount() > 0) {
            tabelaPaspatu.getColumnModel().getColumn(0).setResizable(false);
            tabelaPaspatu.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbVidro.setText("Vidro");
        cbVidro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVidroActionPerformed(evt);
            }
        });

        cbEucatex.setText("Eucatex");
        cbEucatex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEucatexActionPerformed(evt);
            }
        });

        cbEntreVidros.setText("Entre Vidros");
        cbEntreVidros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntreVidrosActionPerformed(evt);
            }
        });

        cboxVidro.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaVidros()));

        cboxEntreVidros.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaVidros()));

        cboxEucatex.setModel(new javax.swing.DefaultComboBoxModel<>(this.listaEucatex()));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbVidro)
                    .addComponent(cbEntreVidros)
                    .addComponent(cbEucatex))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxEntreVidros, 0, 197, Short.MAX_VALUE)
                    .addComponent(cboxVidro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboxEucatex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVidro)
                    .addComponent(cboxVidro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEucatex)
                    .addComponent(cboxEucatex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEntreVidros)
                    .addComponent(cboxEntreVidros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAddPasp.setText("Add");
        btnAddPasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPaspActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnRemovePasp.setText("Remover");
        btnRemovePasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePaspActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calculo Detalhado");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3)
                        .addGap(137, 137, 137)
                        .addComponent(jLabel6)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxMoldura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(edtLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(edtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboxPaspatu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnAddPasp))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRemovePasp)
                                .addGap(32, 32, 32)
                                .addComponent(btnLimpar)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(4, 4, 4)
                                .addComponent(edtCampoCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(spinQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMoldura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(edtLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(edtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxPaspatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddPasp))
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(spinQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemovePasp)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpar)
                            .addComponent(btnCalcular)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(edtCampoCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabelaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Moldura", "Paspatu", "Vidro", "Eucatex", "Dimenção", "Qtd", "Valor Uni.", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPrincipalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaPrincipal);
        if (tabelaPrincipal.getColumnModel().getColumnCount() > 0) {
            tabelaPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tabelaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabelaPrincipal.getColumnModel().getColumn(2).setResizable(false);
            tabelaPrincipal.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaPrincipal.getColumnModel().getColumn(6).setResizable(false);
            tabelaPrincipal.getColumnModel().getColumn(6).setPreferredWidth(12);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1491254405-plusaddmoredetail_82972.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnNovaNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/1492616984-7-docs-document-file-data-google-suits_83406.png"))); // NOI18N
        btnNovaNota.setText("Nova Nota");
        btnNovaNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaNotaActionPerformed(evt);
            }
        });

        btnLimparTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/broom.png"))); // NOI18N
        btnLimparTabela.setText("Limpar Tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/diskette.png"))); // NOI18N
        btnSalvar.setText("Salvar");

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/lixo.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones PNG/broom.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnNovaNota)
                .addGap(18, 18, 18)
                .addComponent(btnLimparCampos)
                .addGap(90, 90, 90)
                .addComponent(btnLimparTabela)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnNovaNota)
                    .addComponent(btnLimparTabela)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimparCampos))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtAlturaActionPerformed

    private void cboxMolduraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMolduraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMolduraActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(this.isCamposPreenchidos()){
            DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPrincipal.getModel();
            this.calculaPedido();
            tableModel.addRow(this.valorDoUltimoCalculo);
            this.dadosDeResultado.add(this.valorDoUltimoCalculo);
            this.dadosDeCalculo.add(this.dadosDoUltimoCalculo);

            this.limparCampos();
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddPaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPaspActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        int ordem = tableModel.getRowCount() + 1;
        if (!this.cboxPaspatu.getSelectedItem().toString().equals("Não")) {
            tableModel.addRow(new Object[]{
                ordem,
                this.cboxPaspatu.getSelectedItem().toString()
            });
            this.listaPasp.add(this.cboxPaspatu.getSelectedItem().toString());
            this.cboxPaspatu.setSelectedIndex(0);
        }

    }//GEN-LAST:event_btnAddPaspActionPerformed

    private void btnRemovePaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePaspActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        if (this.rowPasp != -1) {
            tableModel.removeRow(this.rowPasp);

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
            this.rowPasp = -1;
        }
    }//GEN-LAST:event_btnRemovePaspActionPerformed

    private void tabelaPaspatuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPaspatuMouseClicked
        this.rowPasp = this.tabelaPaspatu.getSelectedRow();
    }//GEN-LAST:event_tabelaPaspatuMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        tableModel.setRowCount(0);
        this.rowPasp = -1;
    }//GEN-LAST:event_btnLimparActionPerformed

    private boolean cbVidroEucatexEntreVidrosSelected() {
        boolean flag = false;
        if (this.cbVidro.isSelected()) {
            flag = true;
        } else if (this.cbEucatex.isSelected()) {
            flag = true;
        } else if (this.cbEntreVidros.isSelected()) {
            flag = true;
        }
        return flag;
    }

    private boolean isCamposPreenchidos() {
        boolean flag = true;

        if (this.edtLargura.getText().isEmpty()) {
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo Largura está vazio!");
        } else if (this.edtAltura.getText().isEmpty()) {
            flag = false;
            JOptionPane.showMessageDialog(null, "O campo Altura está vazio!");
        } else if (this.cboxMoldura.getSelectedItem().equals("Não") && cbVidroEucatexEntreVidrosSelected() == false) {
            flag = false;

            JOptionPane.showMessageDialog(null, "Falta informações para o Calculo de valores, verifique se o campo moldura"
                    + " ou de eucatex e semelhantes foram preenchidos");

        }
        return flag;
    }

    private void calculaPedido() {
        double vidro = 0.0;
        double eucatex = 0.0;
        double pmo = -1; //porcentagem de mao de obra
        double moldura = 0.0;
        double paspatu = 0.0;
        double alt = Double.parseDouble(this.edtAltura.getText())/100;
        double larg = Double.parseDouble(this.edtLargura.getText())/100;
        double valorUnitario = 0.0;
        double valorTotal = 0.0;
        
        Config c = new Config();
        try {
            c = new ConfigDAO().load();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(this.cbEucatex.isSelected()){
            eucatex = this.calculaEucatex(alt, larg, c.getEucatex_metro());
        }
        
        if(cbVidro.isSelected()){
            vidro = this.calculaVidro(alt, larg, c.getVidro_metro());
        }else if(cbEntreVidros.isSelected()){
            vidro = this.calculaVidro(alt, larg, c.getVidro_metro()) * 2;
        }
        
        
        Moldura m = new Moldura();
       
        if (!this.listaPasp.isEmpty()) {
            for (int i = this.listaPasp.size()-1; i >= 0; i--) {
                String idMold = this.listaPasp.get(i);
               
                try {
                    m = new MolduraDAO().getMoldura(idMold);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
                paspatu = paspatu + calculaMoldura(alt, larg, m.getPrecoVenda());
                alt = alt + ((m.getLarguraVara()*2)/100);
                larg = larg + ((m.getLarguraVara()*2)/100);
                
            }
        }
        
        if(!this.cboxMoldura.equals("Não")){
            try {
            m  = new MolduraDAO().getMoldura(this.cboxMoldura.getSelectedItem().toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            moldura = this.calculaMoldura(alt, larg, m.getPrecoVenda());
        }
        
        
        
        pmo = c.getMao_de_obra()/100;
        
        paspatu = paspatu + (paspatu*pmo);
        moldura = moldura + (moldura*pmo);
        vidro = vidro +(vidro*pmo);
        eucatex = eucatex + (eucatex*pmo);
        
        System.out.println("Paspatu "+paspatu+
                            " moldura "+moldura+
                            " vidro "+vidro+
                            " eucatex "+eucatex);
        
        valorUnitario = vidro + eucatex + paspatu + moldura;
        valorTotal = valorUnitario * (int)this.spinQtd.getValue();
        
        
        // Arredondando os valores para duas casas decimais
        moldura = converterParaDoubleCentesimal(moldura);
        paspatu = converterParaDoubleCentesimal(paspatu);
        vidro = converterParaDoubleCentesimal(vidro);
        eucatex = converterParaDoubleCentesimal(eucatex);
        valorUnitario = converterParaDoubleCentesimal(valorUnitario);
        valorTotal = converterParaDoubleCentesimal(valorTotal);
        
        
        this.edtCampoCalcular.setText(valorTotal+"");
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPrincipal.getModel();
        
        Object b = new Object[]{
            tableModel.getRowCount()+1,
            moldura,
            paspatu,
            vidro,
            eucatex,
            this.edtAltura.getText()+"X"+this.edtLargura.getText(),
            this.spinQtd.getValue(),
            valorUnitario,
            valorTotal
        };
        
        //Pegando as informações do pedido necessarias para o calculo de valores
        Object a = new Object[]{
            this.cboxTipo.getSelectedIndex(),
            this.cboxMoldura.getSelectedIndex(),
            this.edtLargura.getText(),
            this.edtAltura.getText(),
            this.listaPasp,
            this.cboxVidro.getSelectedIndex(),
            this.cboxEucatex.getSelectedIndex(),
            this.cboxEntreVidros.getSelectedIndex(),
            this.spinQtd.getValue(),
            this.edtDescricao.getText()
        };
                
        this.dadosDoUltimoCalculo = (Object[]) a;
        this.valorDoUltimoCalculo = (Object[]) b;   
    }

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (this.isCamposPreenchidos()) {
            this.calculaPedido();
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void cbVidroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVidroActionPerformed
        if(this.cbVidro.isSelected()){
            this.cbEntreVidros.setSelected(false);
            this.cboxEntreVidros.setSelectedIndex(0);
            this.cboxVidro.setSelectedIndex(1);
        }else{
            this.cboxVidro.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbVidroActionPerformed

    private void cbEucatexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEucatexActionPerformed
        if(this.cbEucatex.isSelected()){
            this.cbEntreVidros.setSelected(false);
            this.cboxEntreVidros.setSelectedIndex(0);
            this.cboxEucatex.setSelectedIndex(1);
        }else{
            this.cboxEucatex.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbEucatexActionPerformed

    private void cbEntreVidrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntreVidrosActionPerformed
        if(this.cbEntreVidros.isSelected()){
            this.cbVidro.setSelected(false);
            this.cbEucatex.setSelected(false);
            this.cboxEntreVidros.setSelectedIndex(1);
            this.cboxVidro.setSelectedIndex(0);
            this.cboxEucatex.setSelectedIndex(0);
        }else{
            this.cboxEntreVidros.setSelectedIndex(0);
            this.cboxEucatex.setSelectedIndex(0);
            this.cboxVidro.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbEntreVidrosActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPrincipal.getModel();
        tableModel.removeRow(this.row);
        this.dadosDeResultado.remove(this.row);
        this.dadosDeCalculo.remove(this.row);
        this.row = -1;
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPrincipalMouseClicked
        this.row = this.tabelaPrincipal.getSelectedRow();
        
        Object[] aux = null;
        aux = (Object[]) this.dadosDeCalculo.get(this.row);
       
        this.cboxTipo.setSelectedIndex(Integer.parseInt(aux[0].toString()));
        this.cboxMoldura.setSelectedIndex(Integer.parseInt(aux[1].toString()));
        this.edtLargura.setText(aux[2].toString());
        this.edtAltura.setText(aux[3].toString());
        
        List listaP = (List)aux[4];
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPaspatu.getModel();
        tableModel.setNumRows(0);
        for(int i = 0; i<listaP.size();i++){
            tableModel.addRow(new Object[]{i+1,listaP.get(i)});
        }
        
        this.cboxVidro.setSelectedIndex(Integer.parseInt(aux[5].toString()));
        if(this.cboxVidro.getSelectedIndex() == 0){
            this.cbVidro.setSelected(false);
        }else{
            this.cbVidro.setSelected(true);
        }
        this.cboxEucatex.setSelectedIndex(Integer.parseInt(aux[6].toString()));
        if(this.cboxEucatex.getSelectedIndex() == 0){
            this.cbEucatex.setSelected(false);
        }else{
            this.cbEucatex.setSelected(true);
        }
        this.cboxEntreVidros.setSelectedIndex(Integer.parseInt(aux[7].toString()));
        if(this.cboxEntreVidros.getSelectedIndex() == 0){
            this.cbEntreVidros.setSelected(false);
        }else{
            this.cbEntreVidros.setSelected(true);
        }
        
        this.spinQtd.setValue(Integer.parseInt(aux[8].toString()));
        this.edtDescricao.setText(aux[9].toString());
    }//GEN-LAST:event_tabelaPrincipalMouseClicked

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) this.tabelaPrincipal.getModel();
        
        if(tableModel.getRowCount() != 0){
            int value = JOptionPane.showConfirmDialog(null, "Todos os dados da tabela serão apagados, realmente deseja continuar?",
                "ATENÇÂO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
            if(value == JOptionPane.YES_OPTION){    

                tableModel.setNumRows(0);
                this.dadosDeCalculo.clear();
                this.dadosDeResultado.clear();
                this.dadosDoUltimoCalculo = null;
                this.valorDoUltimoCalculo = null;
            }
        }
        
    }//GEN-LAST:event_btnLimparTabelaActionPerformed

    private void btnNovaNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaNotaActionPerformed
//        this.setVisible(false);
       
//        TelaPrincipal.menuNota.setForeground(Color.BLUE);
//        CadPedidoCabecalho cadPedidoCabecalho = new CadPedidoCabecalho();
//        TelaPrincipal.desktopPane.add(cadPedidoCabecalho);
//        cadPedidoCabecalho.setSize(desktopPane.getWidth(),desktopPane.getHeight());
//        cadPedidoCabecalho.setLocation(0,0);
//        cadPedidoCabecalho.setVisible(true);
//        ((BasicInternalFrameUI)cadPedidoCabecalho.getUI()).setNorthPane(null);

    }//GEN-LAST:event_btnNovaNotaActionPerformed

    private String converterDoubleStringCentesimal(double precoDouble) {
        /*Transformando um double em 2 casas decimais*/
        DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais    
        String string = fmt.format(precoDouble);
        //tirando a virgula que vem por padrão no DecimalFormat
        String[] part = string.split("[,]"); 
        String preco = part[0]+"."+part[1];
        
        return preco;
    }
    
    private double converterParaDoubleCentesimal(double precoDouble) {
        /*Transformando um double em 2 casas decimais*/
        DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais    
        String string = fmt.format(precoDouble);
        //tirando a virgula que vem por padrão no DecimalFormat
        String[] part = string.split("[,]"); 
        String preco = part[0]+"."+part[1];
        
        return Double.parseDouble(preco);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddPasp;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnNovaNota;
    private javax.swing.JButton btnRemovePasp;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbEntreVidros;
    private javax.swing.JCheckBox cbEucatex;
    private javax.swing.JCheckBox cbVidro;
    private javax.swing.JComboBox<String> cboxEntreVidros;
    private javax.swing.JComboBox<String> cboxEucatex;
    private javax.swing.JComboBox<String> cboxMoldura;
    private javax.swing.JComboBox<String> cboxPaspatu;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JComboBox<String> cboxVidro;
    private javax.swing.JTextField edtAltura;
    private javax.swing.JFormattedTextField edtCampoCalcular;
    private javax.swing.JTextArea edtDescricao;
    private javax.swing.JTextField edtLargura;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spinQtd;
    private javax.swing.JTable tabelaPaspatu;
    private javax.swing.JTable tabelaPrincipal;
    // End of variables declaration//GEN-END:variables

}
