package telas;

import dao.DaoPonto;
import eventos.ConfigurarCampos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Funcionario;
import modelo.EntradaDeHorarios;
import tabelaDesign.DesenharTabela;
import dao.DaoFuncionario;
import eventos.EventosDoMouse;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class FrmPonto extends javax.swing.JFrame {

    private final EventosDoMouse eventosDoMouse = new EventosDoMouse();
    private final Funcionario func = new Funcionario();
    private EntradaDeHorarios entrada = new EntradaDeHorarios();
    private final ConfigurarCampos config = new ConfigurarCampos();

    public FrmPonto() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        carregarBotoes();
        carregarTabela();
        carregarComboFuncionario();
        getRootPane().setDefaultButton(btnSalvar);//pegar clique ao dar enter..
        gerarMascara();
    }

    private void captura() {
        btnSalvar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnSalvar.removeKeyListener(this);
                }
            }
        });
    }

    private List<JButton> listaDeBotoes() {
        List<JButton> botoes = Arrays.asList(btnSalvar, btnAlterar, btnExcluir, btnGravar, btnLimpar, btnSelecionar, btnFechar);
        return botoes;
    }

    private void carregarBotoes() {
        List<JButton> btn = listaDeBotoes();
        eventosDoMouse.renderizarBotoes(btn);
        eventosDoMouse.alterarCor(btn);
    }

    private List<JFormattedTextField> listaDeCampos() {
        List<JFormattedTextField> lista = new ArrayList<>();
        lista.add(jFormatted_txt_saida);
        lista.add(jFormatted_txt_entrada);
        lista.add(jFormatted_txt_almoco);
        lista.add(jFormatted_txt_retorno);
        lista.add(jFormatted_txt_saida);
        return lista;
    }

    private void gerarMascara() {
        List<JFormattedTextField> txt_formatado = listaDeCampos();
        config.mascararHora(txt_formatado);
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
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarTabela() {
        List<EntradaDeHorarios> dados = DaoPonto.todosHorarios();
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saída", "Horas normais", "Horas extras", "Horas noturnas"};
        int[] larguraColunas = {50, 50, 50, 50, 50, 50, 50, 50};
        DesenharTabela<EntradaDeHorarios> desenhar = new DesenharTabela<>();
        desenhar.renderizarTabela(tabPonto, colunas, larguraColunas, dados);
    }

    private void somar() {
        Time hora1 = Time.valueOf("10:30:00");
        Time hora2 = Time.valueOf("02:45:00");
        long soma = hora1.getTime() + hora2.getTime();
        Time hora3 = new Time(soma);
    }

    private void carregarCampos() {
        entrada.setDia(Integer.parseInt(txtDia.getText()));
        entrada.setHora_entrada(Time.valueOf(jFormatted_txt_entrada.getText() + ":00"));
        entrada.setHora_almoco(Time.valueOf(jFormatted_txt_almoco.getText() + ":00"));
        entrada.setHora_retorno(Time.valueOf(jFormatted_txt_retorno.getText() + ":00"));
        entrada.setHora_saida(Time.valueOf(jFormatted_txt_saida.getText() + ":00"));
        entrada.setNome_funcionario((String) cmbPontoFuncionario.getSelectedItem());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        seletorDeArquivos = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        cmbPontoFuncionario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jFormatted_txt_entrada = new javax.swing.JFormattedTextField();
        jFormatted_txt_almoco = new javax.swing.JFormattedTextField();
        jFormatted_txt_retorno = new javax.swing.JFormattedTextField();
        jFormatted_txt_saida = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPonto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 26, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 26, 2, 0);
        jPanel1.add(txtNome, gridBagConstraints);

        jLabel2.setText("Função:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 111;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 2, 0);
        jPanel1.add(txtFuncao, gridBagConstraints);

        jLabel3.setText("Empresa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 5, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 2, 0);
        jPanel1.add(txtEmp, gridBagConstraints);

        jLabel4.setText("CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 2, 0);
        jPanel1.add(txtCnpj, gridBagConstraints);

        cmbPontoFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPontoFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPontoFuncionarioMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 2, 2);
        jPanel1.add(cmbPontoFuncionario, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("SELECIONE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Entrada:");

        jLabel6.setText("Almoço:");

        jLabel7.setText("Retorno:");

        jLabel8.setText("Saida:");

        jLabel10.setText("Dia:");

        txtDia.setToolTipText("dia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jFormatted_txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormatted_txt_almoco, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jFormatted_txt_retorno, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jFormatted_txt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormatted_txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormatted_txt_almoco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jFormatted_txt_saida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormatted_txt_retorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabPonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabPonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), null, null, null, null, null, null, null},
                { new Integer(2), null, null, null, null, null, null, null},
                { new Integer(3), null, null, null, null, null, null, null},
                { new Integer(4), null, null, null, null, null, null, null},
                { new Integer(5), null, null, null, null, null, null, null},
                { new Integer(6), null, null, null, null, null, null, null},
                { new Integer(7), null, null, null, null, null, null, null},
                { new Integer(8), null, null, null, null, null, null, null},
                { new Integer(9), null, null, null, null, null, null, null},
                { new Integer(10), null, null, null, null, null, null, null},
                { new Integer(11), null, null, null, null, null, null, null},
                { new Integer(12), null, null, null, null, null, null, null},
                { new Integer(13), null, null, null, null, null, null, null},
                { new Integer(14), null, null, null, null, null, null, null},
                { new Integer(15), null, null, null, null, null, null, null},
                { new Integer(16), null, null, null, null, null, null, null},
                { new Integer(17), null, null, null, null, null, null, null},
                { new Integer(18), null, null, null, null, null, null, null},
                { new Integer(19), null, null, null, null, null, null, null},
                { new Integer(20), null, null, null, null, null, null, null},
                { new Integer(21), null, null, null, null, null, null, null},
                { new Integer(22), null, null, null, null, null, null, null},
                { new Integer(23), null, null, null, null, null, null, null},
                { new Integer(24), null, null, null, null, null, null, null},
                { new Integer(25), null, null, null, null, null, null, null},
                { new Integer(26), null, null, null, null, null, null, null},
                { new Integer(27), null, null, null, null, null, null, null},
                { new Integer(28), null, null, null, null, null, null, null},
                { new Integer(29), null, null, null, null, null, null, null},
                { new Integer(30), null, null, null, null, null, null, null},
                { new Integer(31), null, null, null, null, null, null, null}
            },
            new String [] {
                "Dia", "Entrada", "Almoço", "Retorno", "Saida", "Horas normais", "Horas extras", "Horas noturnas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            tabPonto.getColumnModel().getColumn(5).setResizable(false);
            tabPonto.getColumnModel().getColumn(6).setResizable(false);
            tabPonto.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 146, 2, 0);
        jPanel2.add(btnSalvar, gridBagConstraints);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 0);
        jPanel2.add(btnAlterar, gridBagConstraints);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 0);
        jPanel2.add(btnExcluir, gridBagConstraints);

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 0);
        jPanel2.add(btnGravar, gridBagConstraints);

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 0);
        jPanel2.add(btnLimpar, gridBagConstraints);

        btnSelecionar.setText("SELECIONAR");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 0);
        jPanel2.add(btnSelecionar, gridBagConstraints);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 5, 2, 146);
        jPanel2.add(btnFechar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbPontoFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPontoFuncionarioMouseClicked
        func.setNomeFuncionario((String) cmbPontoFuncionario.getSelectedItem());
        Funcionario funcionario = DaoPonto.todosFuncionarios(func);
        txtNome.setText(funcionario.getNomeFuncionario());
        txtFuncao.setText(funcionario.getFuncao());
        txtEmp.setText(funcionario.getNomeEmpresa());
        txtCnpj.setText(funcionario.getCnpj());
    }//GEN-LAST:event_cmbPontoFuncionarioMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtDia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o dia!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            carregarCampos();
            DaoPonto.inserirHorarios(entrada);
            carregarTabela();
            List<JFormattedTextField> listaParaLimpar = listaDeCampos();
            config.limparCampos(listaParaLimpar);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha os campos!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            carregarCampos();
            DaoPonto.upDatePonto(entrada);
            carregarTabela();
            List<JFormattedTextField> listaParaLimpar = listaDeCampos();
            config.limparCampos(listaParaLimpar);
            btnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tabPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPontoMouseClicked
        String hora;
        hora = String.valueOf(tabPonto.getValueAt(tabPonto.getSelectedRow(), 1));//linha e coluna        
        entrada = DaoPonto.getHorarios(hora);//pega uma empresa do metodo getEmpresa..DAO      
        txtDia.setText(String.valueOf(entrada.getDia()));
        jFormatted_txt_entrada.setText(String.valueOf(entrada.getHora_entrada()));
        jFormatted_txt_almoco.setText(String.valueOf(entrada.getHora_almoco()));
        jFormatted_txt_retorno.setText(String.valueOf(entrada.getHora_retorno()));
        jFormatted_txt_saida.setText(String.valueOf(entrada.getHora_saida()));
        cmbPontoFuncionario.setSelectedItem(entrada.getNome_funcionario());
        btnSalvar.setEnabled(false);
    }//GEN-LAST:event_tabPontoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(null, "Deseja realmete excluir?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resposta == JOptionPane.YES_OPTION) {
            carregarCampos();
            DaoPonto.deletarHorarios(entrada);
            carregarTabela();
        }
        List<JFormattedTextField> lista = listaDeCampos();
        config.limparCampos(lista);
        btnSalvar.setEnabled(true);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        List<EntradaDeHorarios> dadosLimpos = DaoPonto.limparLista();
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saida"};
        int[] larguraColunas = {50, 150, 150, 150, 150};//p enviar a largura das colunas da tabela
        DesenharTabela<EntradaDeHorarios> desenhar = new DesenharTabela<>();
        desenhar.renderizarTabela(tabPonto, colunas, larguraColunas, dadosLimpos);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        String nomeRecebido = (String) cmbPontoFuncionario.getSelectedItem();
        List<EntradaDeHorarios> dadosRecebidos = DaoPonto.todosHorarios();
        try {
            List<Funcionario> funcionarios = DaoFuncionario.dadosFuncionarios(nomeRecebido);
            FileWriter arq = new FileWriter("C:\\testeGravar\\listaEnviada.txt");
            String cabecalho = String.format("%-20s %-25s %-22s %-23s", "entrada", "almoco", "retorno", "saida");
            arq.write(cabecalho);
            arq.write("\n");
            for (int i = 0; i < dadosRecebidos.size(); i++) {
                String linha = String.format("%-20s %-20s %-20s %-20s", dadosRecebidos.get(i).getHora_entrada(), dadosRecebidos.get(i).getHora_almoco(), dadosRecebidos.get(i).getHora_retorno(), dadosRecebidos.get(i).getHora_saida());
                arq.write(linha);
                arq.write("\n");
            }
            arq.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int valor = seletorDeArquivos.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File file = seletorDeArquivos.getSelectedFile();
            String nome = file.getName();
        } else {
            System.out.println("Acesso negado!");
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private String nomeArquivo() {
        String nome = "";
        int valor = seletorDeArquivos.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File file = seletorDeArquivos.getSelectedFile();
            nome = file.getName();
            System.out.println(nome);
        } else {
            System.out.println("File access cancelled by user.");
        }
        return nome;
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
            java.util.logging.Logger.getLogger(FrmPonto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPonto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cmbPontoFuncionario;
    private javax.swing.JFormattedTextField jFormatted_txt_almoco;
    private javax.swing.JFormattedTextField jFormatted_txt_entrada;
    private javax.swing.JFormattedTextField jFormatted_txt_retorno;
    private javax.swing.JFormattedTextField jFormatted_txt_saida;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFileChooser seletorDeArquivos;
    private javax.swing.JTable tabPonto;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmp;
    private javax.swing.JTextField txtFuncao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
