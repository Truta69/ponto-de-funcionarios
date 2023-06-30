package telas;

import dao.DaoPonto;
import eventos.ConfigurarCampos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Funcionario;
import modelo.EntradaDeHorarios;
import tabelaDesign.DesenharTabela;
import dao.DaoFuncionario;
import eventos.EventosDoMouse;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import javax.swing.JButton;

public class FrmPonto extends javax.swing.JFrame {

    private final EventosDoMouse eventosDoMouse;
    private final Funcionario func;
    private EntradaDeHorarios entrada;
    private final ConfigurarCampos config;

    public FrmPonto() {
        initComponents();
        this.eventosDoMouse = new EventosDoMouse();
        config = new ConfigurarCampos();
        func = new Funcionario();
        entrada = new EntradaDeHorarios();
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarBotoes();
        carregarTabela();
        carregarComboFuncionario();
        captura();
        getRootPane().setDefaultButton(btnSalvar);

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
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saída", "Horas normais", "Horas extras", "Horas noturnas"};
        int[] larguraColunas = {50, 50, 50, 50, 50, 50, 50, 50};
        DesenharTabela<EntradaDeHorarios> desenhar = new DesenharTabela<>();
        desenhar.renderizarTabela(tabPonto, colunas, larguraColunas, dados);
    }

    private void carregarCampos() {
        entrada.setDia(Integer.parseInt(txtDia.getText()));
        entrada.setHora_entrada(Time.valueOf(txt_entrada.getText()));
        entrada.setHora_almoco(Time.valueOf(txt_almoco.getText()));
        entrada.setHora_retorno(Time.valueOf(txt_retorno.getText()));
        entrada.setHora_saida(Time.valueOf(txt_saida.getText()));
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
        txt_entrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_almoco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_retorno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_saida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPonto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

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
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Entrada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 92, 0, 0);
        jPanel3.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 92, 13, 0);
        jPanel3.add(txt_entrada, gridBagConstraints);

        jLabel6.setText("Almoço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 14, 0, 0);
        jPanel3.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 13, 0);
        jPanel3.add(txt_almoco, gridBagConstraints);

        jLabel7.setText("Retorno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 0, 0);
        jPanel3.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 13, 0);
        jPanel3.add(txt_retorno, gridBagConstraints);

        jLabel8.setText("Saida:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 0, 0);
        jPanel3.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 13, 0);
        jPanel3.add(txt_saida, gridBagConstraints);

        jLabel10.setText("Dia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 0, 0);
        jPanel3.add(jLabel10, gridBagConstraints);

        txtDia.setToolTipText("dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 13, 166);
        jPanel3.add(txtDia, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(7, 144, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 2, 144);
        jPanel2.add(btnFechar, gridBagConstraints);

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
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            List<JTextField> listaParaLimpar = listaDeCampos();
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
            List<JTextField> listaParaLimpar = listaDeCampos();
            config.limparCampos(listaParaLimpar);
            btnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tabPontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPontoMouseClicked
        String hora;
        hora = String.valueOf(tabPonto.getValueAt(tabPonto.getSelectedRow(), 1));//linha e coluna        
        entrada = DaoPonto.getHorarios(hora);//pega uma empresa do metodo getEmpresa..DAO      
        txtDia.setText(String.valueOf(entrada.getDia()));
        txt_entrada.setText(String.valueOf(entrada.getHora_entrada()));
        txt_almoco.setText(String.valueOf(entrada.getHora_almoco()));
        txt_retorno.setText(String.valueOf(entrada.getHora_retorno()));
        txt_saida.setText(String.valueOf(entrada.getHora_saida()));
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
        List<JTextField> lista = listaDeCampos();
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
            try (PrintWriter gravarArq = new PrintWriter(arq)) {
                funcionarios.stream().forEach(e -> gravarArq.printf("%s%n", (e)));
                dadosRecebidos.stream().forEach(e -> gravarArq.printf("%s%n", (e)));
            }
        } catch (IOException ex) {
            throw new RuntimeException("Erro de gravação..!!" + ex);
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possivel executar a conexão!!" + ex);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        int valor = seletorDeArquivos.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File file = seletorDeArquivos.getSelectedFile();
            String nome = file.getName();
        } else {
            System.out.println("File access cancelled by user.");
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
    private javax.swing.JTextField txt_almoco;
    private javax.swing.JTextField txt_entrada;
    private javax.swing.JTextField txt_retorno;
    private javax.swing.JTextField txt_saida;
    // End of variables declaration//GEN-END:variables
}
