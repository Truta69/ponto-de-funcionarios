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
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import pacoteSomar.SomarHoraNormal;

public class FrmPonto extends javax.swing.JFrame {

    private final EventosDoMouse eventosDoMouse = new EventosDoMouse();
    private final Funcionario func = new Funcionario();
    private EntradaDeHorarios entrada = new EntradaDeHorarios();
    private final ConfigurarCampos config = new ConfigurarCampos();
    SomarHoraNormal somarHoras = new SomarHoraNormal();

    public FrmPonto() {
        initComponents();
        getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        carregarBotoes();
        carregarTabela();
        carregarComboFuncionario();
        getRootPane().setDefaultButton(btnSalvar);//pegar clique ao dar enter..
        gerarMascara();
    }

    private void gerarMascara() {
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            jFormatted_txt_entrada.setFormatterFactory(new DefaultFormatterFactory(mask));
            jFormatted_txt_almoco.setFormatterFactory(new DefaultFormatterFactory(mask));
            jFormatted_txt_retorno.setFormatterFactory(new DefaultFormatterFactory(mask));
            jFormatted_txt_saida.setFormatterFactory(new DefaultFormatterFactory(mask));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro de formatação!" + ex);
        }
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
        lista.add(jFormatted_txt_entrada);
        lista.add(jFormatted_txt_almoco);
        lista.add(jFormatted_txt_retorno);
        lista.add(jFormatted_txt_saida);
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
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionarios!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarTabela() {
        List<EntradaDeHorarios> dados = DaoPonto.todosHorarios();
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saída", "Hrs. normais", "Horas extras", "Horas noturnas"};
        int[] larguraColunas = {50, 50, 50, 50, 50, 50, 50, 50};
        DesenharTabela<EntradaDeHorarios> desenhar = new DesenharTabela<>();
        desenhar.renderizarTabela(tabPonto, colunas, larguraColunas, dados);
    }

    private void carregarCampos() {
        entrada.setDia(Integer.parseInt(txtDia.getText()));
        entrada.setHora_entrada((jFormatted_txt_entrada.getText()));
        entrada.setHora_almoco((jFormatted_txt_almoco.getText()));
        entrada.setHora_retorno((jFormatted_txt_retorno.getText()));
        entrada.setHora_saida((jFormatted_txt_saida.getText()));
        entrada.setHora_total(txtSoma.getText());
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
        jLabel3 = new javax.swing.JLabel();
        txtEmp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        cmbPontoFuncionario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtCagaHoraria = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
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
        txtSoma = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtHoraExtra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHoraNoturna = new javax.swing.JTextField();
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
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nome:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 34, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 164;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 34, 19, 0);
        jPanel1.add(txtNome, gridBagConstraints);

        jLabel3.setText("Empresa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        txtEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 194;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 19, 0);
        jPanel1.add(txtEmp, gridBagConstraints);

        jLabel4.setText("CNPJ:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 19, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 19, 54);
        jPanel1.add(cmbPontoFuncionario, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("SELECIONE:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 19, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 19, 0);
        jPanel1.add(txtCagaHoraria, gridBagConstraints);

        jLabel2.setText("C.horaria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Entrada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 39, 0, 0);
        jPanel3.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Almoço:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel3.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Retorno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 7, 0, 0);
        jPanel3.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Saida:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel3.add(jLabel8, gridBagConstraints);

        jLabel10.setText("Dia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel3.add(jLabel10, gridBagConstraints);

        txtDia.setToolTipText("dia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(txtDia, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 39, 0, 0);
        jPanel3.add(jFormatted_txt_entrada, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(jFormatted_txt_almoco, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 7, 0, 0);
        jPanel3.add(jFormatted_txt_retorno, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(jFormatted_txt_saida, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(txtSoma, gridBagConstraints);

        jLabel11.setText("H.Normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel3.add(jLabel11, gridBagConstraints);

        jLabel12.setText("H.Extra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 0, 0);
        jPanel3.add(jLabel12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        jPanel3.add(txtHoraExtra, gridBagConstraints);

        jLabel13.setText("H:Noturna");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        jPanel3.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(txtHoraNoturna, gridBagConstraints);

        tabPonto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabPonto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
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
        gridBagConstraints.insets = new java.awt.Insets(9, 150, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 150);
        jPanel2.add(btnFechar, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
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
        txtCagaHoraria.setText(String.valueOf(funcionario.getCargaHoraria()));
        txtEmp.setText(funcionario.getNomeEmpresa());
        txtCnpj.setText(funcionario.getCnpj());
    }//GEN-LAST:event_cmbPontoFuncionarioMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtDia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o dia!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String srt = somarIntervaloDia();
            txtSoma.setText(String.valueOf(srt));
            JOptionPane.showMessageDialog(this, "soma=" + srt);
            carregarCampos();
            DaoPonto.inserirHorarios(entrada);
            carregarTabela();
            List<JFormattedTextField> listaParaLimpar = listaDeCampos();
            config.limparCampos(listaParaLimpar);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    private String somarIntervaloDia() {
        String h_entrada = jFormatted_txt_entrada.getText();
        String h_almoco = jFormatted_txt_almoco.getText();
        String h_retorno = jFormatted_txt_retorno.getText();
        String h_saida = jFormatted_txt_saida.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime time_entrada = LocalTime.parse(h_entrada, formatter);
        LocalTime time_almoco = LocalTime.parse(h_almoco, formatter);
        LocalTime time_retorno = LocalTime.parse(h_retorno, formatter);
        LocalTime time_saida = LocalTime.parse(h_saida, formatter);
        String respostaManha = somarHoras.calcularIntervaloManha(time_entrada, time_almoco);
        String respostaTarde = somarHoras.calcularIntervaloManha(time_retorno, time_saida);
        String resposta = somarHoras.calcularIntervaloDia(respostaManha, respostaTarde);
        return resposta;
    }

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (jFormatted_txt_entrada.getText().isEmpty()) {
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
        String[] colunas = new String[]{"Dia", "Entrada", "Almoço", "Retorno", "Saida", "Hrs total"};
        int[] larguraColunas = {50, 100, 100, 100, 100, 100};//p enviar a largura das colunas da tabela
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

    private void txtEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JFormattedTextField txtCagaHoraria;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEmp;
    private javax.swing.JTextField txtHoraExtra;
    private javax.swing.JTextField txtHoraNoturna;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSoma;
    // End of variables declaration//GEN-END:variables
}
