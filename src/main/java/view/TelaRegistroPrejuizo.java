package view;

import java.awt.Color;
import util.ThemeAdm;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import model.Movimento;
import model.TipoDespesa;
import model.Veiculo;

public class TelaRegistroPrejuizo extends javax.swing.JFrame {

    public TelaRegistroPrejuizo() {
        initComponents();
        adicionarPlaceholders();
        configurarCampoIdAutomatico();
        configurarCalendario();
        configurarComboBoxTipoDespesa();
        permitirApenasNumeros(jTFEncontrarID);
        adicionarValidacoesFoco();
        setLocationRelativeTo(null);
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
        this.setTitle("GynLog");
    }
    
    private void configurarCampoIdAutomatico() {
        jTFIdMovimentacao.setEditable(false);
    }
    
    // Permite apenas números no campo ID do veículo
    private void permitirApenasNumeros(javax.swing.JTextField campo) {
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_DELETE) {
                    evt.consume();
                }
            }
        });
    }
    
    private void configurarComboBoxTipoDespesa() {
        // Esconde o campo "Outros" inicialmente
        jTFOutros.setVisible(false);
        
        // Adiciona listener para detectar mudanças na seleção
        jCBidTipoDespesa.addActionListener(e -> {
            int selectedIndex = jCBidTipoDespesa.getSelectedIndex();
            
            // Se selecionou "Outros" (índice 14), mostra o campo
            if (selectedIndex == 14) {
                jTFOutros.setVisible(true);
                jTFOutros.setText(""); // Limpa o campo
                jTFOutros.setForeground(Color.BLACK);
                jTFOutros.requestFocus(); // Foca no campo para o usuário digitar
            } else {
                // Se selecionou qualquer outra opção, esconde o campo
                jTFOutros.setVisible(false);
                jTFOutros.setText("Outro");
                jTFOutros.setForeground(Color.GRAY);
            }
        });
    }
    
    // Configura o calendário com a data atual
    private void configurarCalendario() {
        // Define a data atual no JDateChooser
        jDateChooser.setDate(new java.util.Date());
        
        // Define formato de exibição da data
        jDateChooser.setDateFormatString("dd/MM/yyyy");
    }
    
    // Obtém a data selecionada no calendário formatada
    private String obterDataSelecionada() {
        java.util.Date dataSelecionada = jDateChooser.getDate();
        if (dataSelecionada == null) {
            // Se nenhuma data foi selecionada, usa a data atual
            dataSelecionada = new java.util.Date();
        }
        
        // Formata a data para dd/MM/yyyy
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dataSelecionada);
    }
    
    // Adicionando validações quando o camp perde o foco
    private void adicionarValidacoesFoco(){
        // Validação do ID do veículo
        jTFEncontrarID.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String raw = jTFEncontrarID.getText().trim();
                
                if (raw.isEmpty() || raw.equals("Digite o ID do veículo")) {
                    return;
                }
                
                if (!raw.matches("\\d+")) {
                    JOptionPane.showMessageDialog(TelaRegistroPrejuizo.this,
                            "O ID deve conter apenas números", 
                            "Erro de Validação",
                            JOptionPane.ERROR_MESSAGE);
                    jTFEncontrarID.requestFocus();
                    return;
                }
                
                try {
                    int idVeiculo = Integer.parseInt(raw);
                    java.util.ArrayList<Veiculo> listaVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
                    boolean encontrado = false;
                    
                    for (Veiculo v : listaVeiculos) {
                        if (v.getIdVeiculo() == idVeiculo) {
                            encontrado = true;
                            break;
                        }
                    }
                    
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(TelaRegistroPrejuizo.this,
                                "Veículo com ID " + idVeiculo + " não encontrado!\n" +
                                "Por favor, verifique o ID e tente novamente.",
                                "Veículo Não Encontrado",
                                JOptionPane.WARNING_MESSAGE);
                        jTFEncontrarID.requestFocus();
                        return;
                    }
                    
                    int proximoId = gerarProximoIdMovimento();
                    jTFIdMovimentacao.setText(String.valueOf(proximoId));
                    jTFIdMovimentacao.setForeground(Color.BLACK);
                    
                } catch (Exception e) {
                    System.err.println("Erro ao verificar veículo: " + e.getMessage());
                }
            }
        });
        
        
        
        
        // Validação do valor
        jTFRRebeValor.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String raw = jTFRRebeValor.getText().trim();
                
                if (raw.isEmpty() || raw.equals("R$: ")) {
                    return;
                }
                
                // Remove caracteres não numéricos exceto vírgula e ponto
                String valorLimpo = raw.replace(",", ".");
                
                try {
                    double valor = Double.parseDouble(valorLimpo);
                    if (valor < 0) {
                        JOptionPane.showMessageDialog(TelaRegistroPrejuizo.this,
                                "O valor não pode ser negativo.",
                                "Erro de Validação",
                                JOptionPane.ERROR_MESSAGE);
                        jTFRRebeValor.requestFocus();
                        return;
                    }
                    // Formata o valor para exibição
                    jTFRRebeValor.setText(String.format("%.2f", valor));
                    jTFRRebeValor.setForeground(Color.BLACK);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(TelaRegistroPrejuizo.this,
                            "Valor inválido. Use apenas números.",
                            "Erro de Validação",
                            JOptionPane.ERROR_MESSAGE);
                    jTFRRebeValor.requestFocus();
                }
            }
        });
    }
    
    // Gera o próximo ID de movimentação
    private int gerarProximoIdMovimento() {
        java.util.ArrayList<Movimento> lista = util.ArquivoTXT_Movimento.lerArquivo();
        
        // Se a lista está vazia, começa com 10000
        if (lista.isEmpty()) {
            return 10000;
        }
        
        int maiorId = 10000; // ID mínimo
        for (Movimento m : lista) {
            if (m.getIdMovimento() > maiorId) {
                maiorId = m.getIdMovimento();
            }
        }
        return maiorId + 1;
    }
    
    // Limpa todos os campos do formulário
    private void limparCampos() {
        jTFEncontrarID.setText("Digite o ID do veículo");
        jTFEncontrarID.setForeground(Color.GRAY);
        
        jTFIdMovimentacao.setText("Gerado automaticamente");
        jTFIdMovimentacao.setForeground(Color.GRAY);
        
        jDateChooser.setDate(new java.util.Date());
        
        jTFRRebeValor.setText("R$: ");
        jTFRRebeValor.setForeground(Color.GRAY);
        
        jCBidTipoDespesa.setSelectedIndex(0);
        
        jTFOutros.setText("Outro");
        jTFOutros.setForeground(Color.GRAY);
        jTFOutros.setVisible(false);
        
        jTADescricao.setText("");
        
        jTFEncontrarID.requestFocus();
    }
    
    // Converte o item selecionado para ID de tipo de despesa
    private int obterIdTipoDespesa() {
        int selectedIndex = jCBidTipoDespesa.getSelectedIndex();
        
        if (selectedIndex == 0) {
            return -1; // Inválido
        }
        
        // Converte índice para ID: índice 1 = ID 101, índice 2 = ID 102, etc.
        return 100 + selectedIndex;
    }
    
    // Vamos usar o id tipo despesa como int no registro
    // Vai ser String apenas para o usuario, nos relatorios serão numeros
    
    // Obtém o tipo de despesa selecionado
    private int obterTipoDespesaSelecionado() {
        int selectedIndex = jCBidTipoDespesa.getSelectedIndex();
        
        if (selectedIndex == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione o tipo de despesa.",
                    "Campo Obrigatório",
                    JOptionPane.WARNING_MESSAGE);
            jCBidTipoDespesa.requestFocus();
            return -1;
        }
        
        return selectedIndex; // Retorna o índice que representa o tipo
    }
    
    // Obtém o tipo de despesa ou o texto customizado
    private String obterTipoDespesaTexto() {
        int selectedIndex = jCBidTipoDespesa.getSelectedIndex();
        
        if (selectedIndex == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione o tipo de despesa.",
                    "Campo Obrigatório",
                    JOptionPane.WARNING_MESSAGE);
            jCBidTipoDespesa.requestFocus();
            return null;
        }
        
        // Se selecionou "Outros", retorna o texto digitado pelo usuário
        if (selectedIndex == 14) {
            String outrosText = jTFOutros.getText().trim();
            if (outrosText.isEmpty() || outrosText.equals("Outro")) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, especifique o tipo de despesa em 'Outros'.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE);
                jTFOutros.requestFocus();
                return null;
            }
            return outrosText;
        }
        
        // Csao contrario retorna a opcao selecionada no CB
        return (String) jCBidTipoDespesa.getSelectedItem();
    }
    
    // Método principal de registro
    private void registrarMovimento() {
        try {
            // Validações básicas
            String idVeiculoText = jTFEncontrarID.getText().trim();
            String idMovimentoText = jTFIdMovimentacao.getText().trim();
            String dataText = obterDataSelecionada();
            String valorText = jTFRRebeValor.getText().trim();
            String descricaoText = jTADescricao.getText().trim();
            
            // Verifica ID do veículo
            if (idVeiculoText.equals("Digite o ID do veículo") || idVeiculoText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha o ID do veículo.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE);
                jTFEncontrarID.requestFocus();
                return;
            }
            
            // Verifica se o ID da movimentação foi gerado
            if (idMovimentoText.equals("Gerado automaticamente") || idMovimentoText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha um ID de veículo válido primeiro.\n" +
                        "O ID da movimentação será gerado automaticamente.",
                        "ID Não Gerado",
                        JOptionPane.WARNING_MESSAGE);
                jTFEncontrarID.requestFocus();
                return;
            }
            
            // Verifica tipo de despesa
            int selectedIndex = jCBidTipoDespesa.getSelectedIndex();
            if (selectedIndex == 0) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, selecione o tipo de despesa.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE);
                jCBidTipoDespesa.requestFocus();
            return;
        }
            
            int idTipoDespesa = 100 + selectedIndex;
            
            // Recebe o texto da despesa
            String nomeTipoDespesa = obterTipoDespesaTexto();
            if (nomeTipoDespesa == null) {
                return;
            }
            
            // Verifica valor
            if (valorText.equals("R$: ") || valorText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha o valor da despesa.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE);
                jTFRRebeValor.requestFocus();
                return;
            }
            
            // Verifica se o usuário digitou uma descrição
            if (descricaoText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, descreva o motivo/necessidade desta movimentação.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE);
                jTADescricao.requestFocus();
                return;
            }
            
            // Converte os valores
            int idVeiculo = Integer.parseInt(idVeiculoText);
            int idMovimento = Integer.parseInt(idMovimentoText);
            double valor = Double.parseDouble(valorText.replace(",", "."));
            
            Movimento novoMovimento = new Movimento(
                idMovimento,
                idVeiculo,
                idTipoDespesa,
                valor,
                descricaoText,
                dataText
            );
            
                        
            // TXTs
            util.ArquivoTXT_Movimento.salvarLinha(novoMovimento);
            util.ArquivoTXT_Despesa.sincronizarComMovimento();
            
            // XLSXs
            java.util.ArrayList<Movimento> listaMovimentos = util.ArquivoTXT_Movimento.lerArquivo();
            util.ArquivoExcel_Movimento.Transf_Excel(listaMovimentos, "Movimento.xlsx");
            
            // Sync
            util.ArquivoExcel_Despesa.Transf_Excel(null, "Despesas.xlsx");
            
            JOptionPane.showMessageDialog(this,
                    "Movimentação registrada com sucesso!\n" +
                    "ID da movimentação: " + idMovimento + "\n" +
                    "ID do veículo: " + idVeiculo + "\n" +
                    "Tipo de despesa: " + nomeTipoDespesa + "\n" +
                    "Data: " + dataText,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            limparCampos();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro: Verifique se os campos numéricos contêm valores válidos.\n\n" +
                    "Detalhes técnicos: " + e.getMessage(),
                    "Formato Inválido",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao registrar movimentação!\n\n" +
                    "Detalhes: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    
    // Metodos de Placeholder -------------------------------------------------------------
    private void aplicarPlaceholder(javax.swing.JTextField campo, String placeholder) {
        final Color PLACEHOLDER_COLOR = ThemeAdm.getTheme() == ThemeAdm.Theme.LIGHT ? Color.GRAY : new Color(150, 150, 150);
        
        campo.setText(placeholder);
        campo.setForeground(PLACEHOLDER_COLOR);

        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(ThemeAdm.getTextColor());
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campo.getText().isEmpty()) {
                    campo.setText(placeholder);
                    campo.setForeground(PLACEHOLDER_COLOR);
                }
            }
        });
    }

    private void adicionarPlaceholders() {
        aplicarPlaceholder(jTFEncontrarID, "Digite o ID do veículo");
        aplicarPlaceholder(jTFIdMovimentacao, "Gerado automaticamente");
        aplicarPlaceholder(jTFRRebeValor, "R$: ");
        aplicarPlaceholder(jTFOutros, "Outro");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEscolhaClasse = new javax.swing.ButtonGroup();
        canvas1 = new java.awt.Canvas();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFEncontrarID = new javax.swing.JTextField();
        jbtnRegistrar = new javax.swing.JButton();
        jTFIdMovimentacao = new javax.swing.JTextField();
        jTFRRebeValor = new javax.swing.JTextField();
        jCBidTipoDespesa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jTFOutros = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtnListaVeiculos = new javax.swing.JButton();
        jBtnRegistrarNovo = new javax.swing.JButton();
        jBtnRegistrarMovimento = new javax.swing.JButton();
        jBtnHome = new javax.swing.JButton();
        jBtnListaMovimento = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();
        jBtnTema = new javax.swing.JButton();
        jBtnListaMovimento1 = new javax.swing.JButton();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GynLog");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Relatorio de Movimentações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTFEncontrarID.setText("Veículo Id");

        jbtnRegistrar.setText("Enviar Registro");
        jbtnRegistrar.setOpaque(true);
        jbtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrarActionPerformed(evt);
            }
        });

        jTFIdMovimentacao.setText("id movimento");

        jTFRRebeValor.setText("Valor");

        jCBidTipoDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Combustível", "Manutenção Preventiva", "Manutenção Corretiva", "Pneus e Rodas", "Documentação e Licenciamento", "Multas e Penalidades", "Seguro", "Pedágios", "Lavagem e Higienização", "Rastreamento e Monitoramento", "Equipamentos e Acessórios", "Energia / Carregamento", "Despesas Administrativas", "Outros" }));
        jCBidTipoDespesa.setOpaque(true);

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jTFOutros.setText("outros");
        jTFOutros.setOpaque(true);

        jLabel4.setText("Descrição da movimentação:");

        jDateChooser.setOpaque(false);

        jLabel5.setText("ID do veículo");

        jLabel6.setText("Tipos de Despesa");

        jLabel7.setText("Custo (em reais)");

        jLabel8.setText("ID do movimento");

        jLabel9.setText("Data da situação");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Certifique-se de registrar a data e atribuir o valor da movimentação financeira.");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("As informações registradas aqui devem estar ligadas à um veículo registrado na frota.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFIdMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFRRebeValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnRegistrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFEncontrarID, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCBidTipoDespesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFOutros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBidTipoDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTFOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFEncontrarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFRRebeValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFIdMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnRegistrar)
                .addGap(39, 39, 39))
        );

        jBtnListaVeiculos.setText("Lista de Veículos Registrados");
        jBtnListaVeiculos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaVeiculos.setOpaque(true);
        jBtnListaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListaVeiculosActionPerformed(evt);
            }
        });

        jBtnRegistrarNovo.setText("Registrar novo veículo");
        jBtnRegistrarNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrarNovo.setOpaque(true);
        jBtnRegistrarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarNovoActionPerformed(evt);
            }
        });

        jBtnRegistrarMovimento.setText("Registrar nova finança");
        jBtnRegistrarMovimento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrarMovimento.setOpaque(true);
        jBtnRegistrarMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarMovimentoActionPerformed(evt);
            }
        });

        jBtnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnHome.setText("Inicio");
        jBtnHome.setOpaque(true);
        jBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHomeActionPerformed(evt);
            }
        });

        jBtnListaMovimento.setText("Gerar relatórios");
        jBtnListaMovimento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaMovimento.setOpaque(true);
        jBtnListaMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListaMovimentoActionPerformed(evt);
            }
        });

        jBtnExit.setText("Fechar programa");
        jBtnExit.setOpaque(true);
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });

        jBtnTema.setText("Claro / Escuro");
        jBtnTema.setOpaque(true);
        jBtnTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTemaActionPerformed(evt);
            }
        });

        jBtnListaMovimento1.setText("Pesquisar veículos");
        jBtnListaMovimento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaMovimento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListaMovimento1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtnListaVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnRegistrarNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnRegistrarMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnListaMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnTema)
                                    .addComponent(jBtnListaMovimento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnExit)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jBtnListaVeiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRegistrarNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRegistrarMovimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnListaMovimento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnListaMovimento1)
                .addGap(18, 18, 18)
                .addComponent(jBtnTema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jBtnExit)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnListaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnListaVeiculosActionPerformed
        new TelaListaVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnListaVeiculosActionPerformed

    private void jBtnRegistrarNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarNovoActionPerformed
        new TelaRegistroVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnRegistrarNovoActionPerformed

    private void jBtnRegistrarMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarMovimentoActionPerformed
        new TelaRegistroPrejuizo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnRegistrarMovimentoActionPerformed

    private void jBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHomeActionPerformed
        new TelaInicio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnHomeActionPerformed

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExitActionPerformed
        int confirmacao =  javax.swing.JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja sair do sistema?" ,
            "Confirmação de Saída" ,
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if(confirmacao == javax.swing.JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jBtnExitActionPerformed

    private void jBtnTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTemaActionPerformed
        if (ThemeAdm.getTheme() == ThemeAdm.Theme.LIGHT) {
            ThemeAdm.setTheme(ThemeAdm.Theme.DARK);
        } else {
            ThemeAdm.setTheme(ThemeAdm.Theme.LIGHT);
        }
        ThemeAdm.applyTheme(this);
    }//GEN-LAST:event_jBtnTemaActionPerformed

    private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrarActionPerformed
        registrarMovimento();
    }//GEN-LAST:event_jbtnRegistrarActionPerformed

    private void jBtnListaMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnListaMovimentoActionPerformed
        new telaGerarRelatorios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnListaMovimentoActionPerformed

    private void jBtnListaMovimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnListaMovimento1ActionPerformed
        new TelaPesquisaVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnListaMovimento1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroPrejuizo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupEscolhaClasse;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnHome;
    private javax.swing.JButton jBtnListaMovimento;
    private javax.swing.JButton jBtnListaMovimento1;
    private javax.swing.JButton jBtnListaVeiculos;
    private javax.swing.JButton jBtnRegistrarMovimento;
    private javax.swing.JButton jBtnRegistrarNovo;
    private javax.swing.JButton jBtnTema;
    private javax.swing.JComboBox<String> jCBidTipoDespesa;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFEncontrarID;
    private javax.swing.JTextField jTFIdMovimentacao;
    private javax.swing.JTextField jTFOutros;
    private javax.swing.JTextField jTFRRebeValor;
    private javax.swing.JButton jbtnRegistrar;
    // End of variables declaration//GEN-END:variables
}
