package telas;

import dao.DaoPonto;
import eventos.ConfigurarCampos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Funcionario;
import modelo.EntradaDeHorarios;
import tabelaDesign.DesenharTabela;

public class FrmPonto extends javax.swing.JFrame {

    Funcionario func = new Funcionario();
    EntradaDeHorarios entrada = new EntradaDeHorarios();
    private final ConfigurarCampos config = new ConfigurarCampos();

    public FrmPonto() {
        initComponents();
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarTabela();
        carregarComboFuncionario();
    }

    private List<JTextField> listaDeCampos() {
        List<JTextField> lista = Arrays.asList(txtDia, txt_entrada, txt_almoco, txt_retorno, txt_saida);
        return lista;
    }

    private void carregarComboFuncionario() {
        ResultSet rs;
        try {
            rs = DaoPonto.carregar();
            cmbPontoFuncionario.removeAllItems();
            while (rs.next()) {
                String nomeRecebido = rs.getString("nome_funcionario");
                cmbPontoFuncionario.addItem(nomeRecebido);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
    }

    private void carregarTabela() {
        List<EntradaDeHorarios> dados = DaoPonto.todosHorarios();
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saída"};
        int[] larguraColunas = {50, 150, 150, 150, 150, 50};
        DesenharTabela<EntradaDeHorarios> desenhar = new DesenharTabela<>();
        desenhar.renderizarTabela(tabPonto, colunas, larguraColunas, dados);
    }

    private void carregarCampos() {
        entrada.setDia(Integer.parseInt(txtDia.getText()));
        entrada.setHora_entrada(txt_entrada.getText());
        entrada.setHora_almoco(txt_almoco.getText());
        entrada.setHora_retorno(txt_retorno.getText());
        entrada.setHora_saida(txt_saida.getText());
        entrada.setNome_funcionario((String) cmbPontoFuncionario.getSelectedItem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPonto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_entrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_almoco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_retorno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_saida = new javax.swing.JTextField();
        cmbPontoFuncionario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tabPonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabPonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null},
                { new Integer(2), null, null, null, null},
                { new Integer(3), null, null, null, null},
                { new Integer(4), null, null, null, null},
                { new Integer(5), null, null, null, null},
                { new Integer(6), null, null, null, null},
                { new Integer(7), null, null, null, null},
                { new Integer(8), null, null, null, null},
                { new Integer(9), null, null, null, null},
                { new Integer(10), null, null, null, null},
                { new Integer(11), null, null, null, null},
                { new Integer(12), null, null, null, null},
                { new Integer(13), null, null, null, null},
                { new Integer(14), null, null, null, null},
                { new Integer(15), null, null, null, null},
                { new Integer(16), null, null, null, null},
                { new Integer(17), null, null, null, null},
                { new Integer(18), null, null, null, null},
                { new Integer(19), null, null, null, null},
                { new Integer(20), null, null, null, null},
                { new Integer(21), null, null, null, null},
                { new Integer(22), null, null, null, null},
                { new Integer(23), null, null, null, null},
                { new Integer(24), null, null, null, null},
                { new Integer(25), null, null, null, null},
                { new Integer(26), null, null, null, null},
                { new Integer(27), null, null, null, null},
                { new Integer(28), null, null, null, null},
                { new Integer(29), null, null, null, null},
                { new Integer(30), null, null, null, null},
                { new Integer(31), null, null, null, null}
            },
            new String [] {
                "Dia", "Entrada", "Almoço", "Retorno", "Saida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPonto.getTableHeader().setReorderingAllowed(false);
        tabPonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPontoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPonto);
        if (tabPonto.getColumnModel().getColumnCount() > 0) {
            tabPonto.getColumnModel().getColumn(0).setResizable(false);
            tabPonto.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabPonto.getColumnModel().getColumn(1).setResizable(false);
            tabPonto.getColumnModel().getColumn(2).setResizable(false);
            tabPonto.getColumnModel().getColumn(3).setResizable(false);
            tabPonto.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nome:");

        jLabel2.setText("Função:");

        jLabel3.setText("Empresa:");

        jLabel4.setText("CNPJ:");

        jLabel5.setText("Entrada:");

        jLabel6.setText("Almoço:");

        jLabel7.setText("Retorno:");

        jLabel8.setText("Saida:");

        cmbPontoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPontoFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPontoFuncionarioMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("SELECIONE:");

        txtDia.setToolTipText("dia");

        jLabel10.setText("Dia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_almoco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_retorno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPontoFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDia)
                                .addGap(91, 91, 91)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_almoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_retorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPontoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAlterar);

        btnExcluir.setText("Excluir");
        jPanel2.add(btnExcluir);

        btnGravar.setText("Gravar");
        jPanel2.add(btnGravar);

        btnLimpar.setText("Limpar");
        jPanel2.add(btnLimpar);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel2.add(btnFechar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbPontoFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPontoFuncionarioMouseClicked
        func.setNomeFuncionario((String) cmbPontoFuncionario.getSelectedItem());
        try {
            Funcionario funcionario = DaoPonto.todosFuncionarios(func);
            txtNome.setText(funcionario.getNomeFuncionario());
            txtFuncao.setText(funcionario.getFuncao());
            txtEmp.setText(funcionario.getNomeEmpresa());
            txtCnpj.setText(funcionario.getCnpj());
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
    }//GEN-LAST:event_cmbPontoFuncionarioMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtDia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o dia!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                carregarCampos();
                DaoPonto.inserirHorarios(entrada);
            } catch (SQLException ex) {
                throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
            }
            carregarTabela();
            List<JTextField> listaParaLimpar = listaDeCampos();
            config.limparCampos(listaParaLimpar);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        carregarCampos();
        try {
            DaoPonto.upDatePonto(entrada);
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
        carregarTabela();
        List<JTextField> listaParaLimpar = listaDeCampos();
        config.limparCampos(listaParaLimpar);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tabPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPontoMouseClicked
        String hora;
        hora = String.valueOf(tabPonto.getValueAt(tabPonto.getSelectedRow(), 1));//linha e coluna
        try {
            entrada = DaoPonto.getHorarios(hora);//pega uma empresa do metodo getEmpresa..DAO
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
        txtDia.setText(String.valueOf(entrada.getDia()));
        txt_entrada.setText((entrada.getHora_entrada()));
        txt_almoco.setText((entrada.getHora_almoco()));
        txt_retorno.setText((entrada.getHora_retorno()));
        txt_saida.setText((entrada.getHora_saida()));
        cmbPontoFuncionario.setSelectedItem(entrada.getNome_funcionario());
    }//GEN-LAST:event_tabPontoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPonto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbPontoFuncionario;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPonto;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmp;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txt_almoco;
    private javax.swing.JTextField txt_entrada;
    private javax.swing.JTextField txt_retorno;
    private javax.swing.JTextField txt_saida;
    // End of variables declaration//GEN-END:variables
}
