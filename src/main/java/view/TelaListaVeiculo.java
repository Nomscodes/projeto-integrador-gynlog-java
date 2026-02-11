package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ThemeAdm;

public class TelaListaVeiculo extends javax.swing.JFrame {

    public TelaListaVeiculo() {
        initComponents();
        configurarTabela();
        configurarComboFiltro();
        carregarDadosNaTabela();
        configurarSelecaoTabela();
        setLocationRelativeTo(null);
        this.setTitle("GynLog");
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
    }
    
    // Configurações diferentes de disponibilidade -----------------------------
    private enum FiltroDisponibilidade {
        TODOS, DISPONIVEIS, INDISPONIVEIS
    }
    
    private FiltroDisponibilidade filtroAtual = FiltroDisponibilidade.TODOS;
    
    // Configuração inicial da tabela ------------------------------------------
    private void configurarTabela() {
            jTDados.setDefaultEditor(Object.class, null);
            
            // Seleção de uma linha individual ---------------------------------
            jTDados.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    // Recebe dados do arquivo Veiculo.txt -------------------------------------
    private void carregarDadosNaTabela() {
        String caminho = "Veiculo.txt";
        
        DefaultTableModel model = (DefaultTableModel) jTDados.getModel();
        model.setRowCount(0);
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            boolean primeiraLinha = true;
            
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                
                // Pula linhas vazias
                if (linha.isEmpty()) {
                    continue;
                }
                
                // Pula o cabeçalho --------------------------------------------
                if(primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                
                String[] dados = linha.split("\\s*\\|\\s*"); // obrigatorio!!!!!!!!
                
                // Verificação do tamanho da linha
                if (dados.length != 6) {
                    throw new IllegalArgumentException(
                        "Linha do arquivo com formato incorreto \n" + linha
                    );
                }
                
                // Filtro de disponibilidade -----------------------------------
                String statusTexto = dados[5].trim();
                boolean disp = statusTexto.equalsIgnoreCase("Disponível") || 
                              statusTexto.equalsIgnoreCase("Disponivel") ||
                              statusTexto.equalsIgnoreCase("True");
                
                boolean deveExibir = false;
                
                switch (filtroAtual) {
                    case TODOS:
                        deveExibir = true;
                        break;
                    case DISPONIVEIS:
                        deveExibir = disp;
                        break;
                    case INDISPONIVEIS:
                        deveExibir = !disp;
                        break;
                }
                
                if (deveExibir) {
                    for (int i = 0; i < dados.length; i++) {
                        dados[i] = dados[i].trim();
                    }
                    
                    dados[5] = disp ? "Disponível" : "Indisponível";
                    // Adiciona a linha de dados ao modelo da tabela ---------------
                    model.addRow(dados);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao ler o arquivo TXT: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    // Alteração de disponibilidade --------------------------------------------
    private void alternarDisponibilidadeVeiculo() {
        int[] linhasSelecionadas = jTDados.getSelectedRows();

        if(linhasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecione um ou mais veículos para alterar a disponibilidade.",
                "Nenhum veículo selecionado",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTDados.getModel();

        // Coleta informações dos veículos selecionados
        ArrayList<String> idsParaAlterar = new ArrayList<>();
        StringBuilder infoVeiculos = new StringBuilder();

        // Verifica se há mistura de disponíveis e indisponíveis
        int qtdDisponiveis = 0;
        int qtdIndisponiveis = 0;

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            int linha = linhasSelecionadas[i];
            String idVeiculo = model.getValueAt(linha, 0).toString().trim();
            String placa = model.getValueAt(linha, 1).toString().trim();
            String marca = model.getValueAt(linha, 2).toString().trim();
            String modeloVeiculo = model.getValueAt(linha, 3).toString().trim();
            String statusAtual = model.getValueAt(linha, 5).toString().trim();

            idsParaAlterar.add(idVeiculo);

            if (statusAtual.equals("Disponível")) {
                qtdDisponiveis++;
            } else {
                qtdIndisponiveis++;
            }

            infoVeiculos.append(String.format("  • %s %s (Placa: %s) - %s\n", 
                                              marca, modeloVeiculo, placa, statusAtual));
        }

        // Define a ação baseada na seleção
        String acao;
        String novoStatus;
        boolean tornarDisponivel;

        if (linhasSelecionadas.length == 1) {
            // Comportamento original para 1 veículo
            String statusAtual = model.getValueAt(linhasSelecionadas[0], 5).toString().trim();
            boolean estaDisponivel = statusAtual.equals("Disponível");
            tornarDisponivel = !estaDisponivel;
            novoStatus = estaDisponivel ? "Indisponível" : "Disponível";
            acao = "alternar";
        } else {
            // Para múltiplos veículos, pergunta qual ação tomar
            if (qtdDisponiveis > 0 && qtdIndisponiveis > 0) {
                // Há mistura - pergunta o que fazer
                Object[] opcoes = {"Marcar todos como Disponível", 
                                  "Marcar todos como Indisponível", 
                                  "Cancelar"};
                int escolha = JOptionPane.showOptionDialog(this,
                        String.format("Você selecionou %d veículos:\n" +
                                     "- %d disponíveis\n" +
                                     "- %d indisponíveis\n\n" +
                                     "O que deseja fazer?",
                                     linhasSelecionadas.length, qtdDisponiveis, qtdIndisponiveis),
                        "Escolha a ação",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

                if (escolha == 0) {
                    tornarDisponivel = true;
                    novoStatus = "Disponível";
                    acao = "marcar como disponível";
                } else if (escolha == 1) {
                    tornarDisponivel = false;
                    novoStatus = "Indisponível";
                    acao = "marcar como indisponível";
                } else {
                    return; // Cancelou
                }
            } else if (qtdDisponiveis > 0) {
                // Todos disponíveis - marcar como indisponível
                tornarDisponivel = false;
                novoStatus = "Indisponível";
                acao = "marcar como indisponível";
            } else {
                // Todos indisponíveis - marcar como disponível
                tornarDisponivel = true;
                novoStatus = "Disponível";
                acao = "marcar como disponível";
            }
        }

        // Confirmação com o usuário
        String mensagem;
        if (linhasSelecionadas.length == 1) {
            mensagem = String.format("Deseja alterar a disponibilidade do veículo?\n\n%s\nNovo status: %s",
                                    infoVeiculos.toString(), novoStatus);
        } else {
            mensagem = String.format("Deseja %s %d veículos?\n\n%s\nNovo status de todos: %s",
                                    acao, linhasSelecionadas.length, infoVeiculos.toString(), novoStatus);
        }

        int confirmacao = JOptionPane.showConfirmDialog(this,
                mensagem,
                "Confirmar Alteração",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            ArrayList<model.Veiculo> listaVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();

            int alterados = 0;
            for (String id : idsParaAlterar) {
                for (model.Veiculo veiculo : listaVeiculos) {
                    if (String.valueOf(veiculo.getIdVeiculo()).equals(id)) {
                        veiculo.setAtivo(tornarDisponivel);
                        alterados++;
                        System.out.println("Status alterado: ID=" + id + " → " + novoStatus);
                        break;
                    }
                }
            }

            if (alterados == 0) {
                JOptionPane.showMessageDialog(this,
                        "Nenhum veículo foi encontrado no sistema.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            util.ArquivoTXT_Veiculo.AtualizarTxtExcel(listaVeiculos);
            util.ArquivoExcel_Veiculo.Transf_Excel(listaVeiculos, "Veiculo.xlsx");

            String mensagemSucesso;
            if (alterados == 1) {
                mensagemSucesso = String.format("Disponibilidade alterada com sucesso!\nNovo status: %s", novoStatus);
            } else {
                mensagemSucesso = String.format("%d veículos alterados com sucesso!\nNovo status: %s", alterados, novoStatus);
            }

            JOptionPane.showMessageDialog(this, 
                    mensagemSucesso,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Salva os IDs antes de recarregar
            ArrayList<String> idsParaReselecionar = new ArrayList<>(idsParaAlterar);

            // Recarrega a tabela
            carregarDadosNaTabela();

            // Tenta reselecionar os veículos
            jTDados.clearSelection();
            for (int i = 0; i < jTDados.getRowCount(); i++) {
                String idLinha = model.getValueAt(i, 0).toString();
                if (idsParaReselecionar.contains(idLinha)) {
                    jTDados.addRowSelectionInterval(i, i);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao alterar disponibilidade:\n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }
    
    // Adicione um SelectionListener na tabela para atualizar o botão
    private void configurarSelecaoTabela() {
        jTDados.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int[] linhasSelecionadas = jTDados.getSelectedRows();
                
                if (linhasSelecionadas.length == 0) {
                    jBtnDisponib.setText("Alterar Disponibilidade");
                    jBtnDisponib.setEnabled(false);
                    
                } else if (linhasSelecionadas.length == 1) {
                    // Uma linha selecionada - comportamento original
                    DefaultTableModel model = (DefaultTableModel) jTDados.getModel();
                    String status = model.getValueAt(linhasSelecionadas[0], 5).toString().trim();
                    
                    if (status.equalsIgnoreCase("Disponível")) {
                        jBtnDisponib.setText("Marcar como Indisponível");
                    } else {
                        jBtnDisponib.setText("Marcar como Disponível");
                    }
                    jBtnDisponib.setEnabled(true);
                } else {
                    // Múltiplas linhas selecionadas
                    jBtnDisponib.setText(String.format("Alterar %d veículos", linhasSelecionadas.length));
                    jBtnDisponib.setEnabled(true);
                }
            }
        });
    }
    
    // Deletando linha selecionada ---------------------------------------------
    private void deletarVeiculoSelecionado() {
        int[] linhasSelecionadas = jTDados.getSelectedRows();

        if (linhasSelecionadas.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione um ou mais veículos para deletar.",
                    "Nenhum veículo selecionado",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTDados.getModel();

        // Coleta informações dos veículos selecionados
        ArrayList<String> idsParaDeletar = new ArrayList<>();
        StringBuilder infoVeiculos = new StringBuilder();

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            int linha = linhasSelecionadas[i];
            String idVeiculo = model.getValueAt(linha, 0).toString().trim();
            String placa = model.getValueAt(linha, 1).toString().trim();
            String modeloVeiculo = model.getValueAt(linha, 3).toString().trim();

            idsParaDeletar.add(idVeiculo);
            infoVeiculos.append(String.format("  • ID: %s | Placa: %s | Modelo: %s\n", 
                                              idVeiculo, placa, modeloVeiculo));
        }

        // Confirmação com o usuário
        String mensagem;
        if (linhasSelecionadas.length == 1) {
            mensagem = "Tem certeza que deseja deletar o veículo?\n\n" + infoVeiculos.toString();
        } else {
            mensagem = String.format("Tem certeza que deseja deletar %d veículos?\n\n%s", 
                                    linhasSelecionadas.length, infoVeiculos.toString());
        }

        int confirmacao = JOptionPane.showConfirmDialog(this,
                mensagem,
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        // Leitura de todos os veículos
        ArrayList<model.Veiculo> listaVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();

        // Remove os veículos com os IDs correspondentes
        int removidos = 0;
        for (String id : idsParaDeletar) {
            boolean removeu = listaVeiculos.removeIf(v -> String.valueOf(v.getIdVeiculo()).equals(id));
            if (removeu) removidos++;
        }

        if (removidos == 0) {
            JOptionPane.showMessageDialog(this,
                "Nenhum veículo foi encontrado na lista.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        util.ArquivoTXT_Veiculo.AtualizarTxtExcel(listaVeiculos);
        util.ArquivoExcel_Veiculo.Transf_Excel(listaVeiculos, "Veiculo.xlsx");

        String mensagemSucesso;
        if (removidos == 1) {
            mensagemSucesso = "Veículo deletado com sucesso!";
        } else {
            mensagemSucesso = String.format("%d veículos deletados com sucesso!", removidos);
        }

        JOptionPane.showMessageDialog(this, 
                mensagemSucesso,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );

        carregarDadosNaTabela();
    }

    
    // Configurações da Combo Box ----------------------------------------------
    private void configurarComboFiltro() {
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Todos");
        jComboBox1.addItem("Disponíveis");
        jComboBox1.addItem("Indisponíveis");
        
        jComboBox1.addActionListener(e -> {
            String opcao = jComboBox1.getSelectedItem().toString();
            
            switch (opcao) {
                case "Todos":
                    alternarFiltro(FiltroDisponibilidade.TODOS);
                    break;
                case "Disponíveis":
                    alternarFiltro(FiltroDisponibilidade.DISPONIVEIS);
                    break;
                case "Indisponíveis":
                    alternarFiltro(FiltroDisponibilidade.INDISPONIVEIS);
                    break;
            }
        });
    }
    
    // Altera filtro de disponibilidade ----------------------------------------
    private void alternarFiltro(FiltroDisponibilidade novoFiltro) {
        filtroAtual = novoFiltro;
        carregarDadosNaTabela();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEscolhaClasse = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDados = new javax.swing.JTable();
        jBtnTelaRegVeic = new javax.swing.JButton();
        jBtnDeletar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jBtnTema1 = new javax.swing.JButton();
        jBtnDisponib = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GynLog");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tela de Disponibilidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
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

        jTDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID do Veículo", "Placa", "Marca", "Modelo", "Ano de fabricação", "Disponibilidade"
            }
        ));
        jScrollPane1.setViewportView(jTDados);

        jBtnTelaRegVeic.setText("Registrar novo veículo");
        jBtnTelaRegVeic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTelaRegVeicActionPerformed(evt);
            }
        });

        jBtnDeletar.setText("Deletar");
        jBtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeletarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Disponíveis", "Indisponíveis" }));

        jBtnTema1.setText("Claro / Escuro");
        jBtnTema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTema1ActionPerformed(evt);
            }
        });

        jBtnDisponib.setText("Alterar Disponibilidade");
        jBtnDisponib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDisponibActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione um ou mais linhas para alterar disponibilidade ou exclusão");

        jbtnInicio.setText("Menu inicial");
        jbtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnInicio))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtnTema1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnDisponib, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnTelaRegVeic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnDeletar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jbtnInicio)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnTelaRegVeic)
                    .addComponent(jBtnDeletar)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnTema1)
                    .addComponent(jBtnDisponib))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeletarActionPerformed
        deletarVeiculoSelecionado();
        carregarDadosNaTabela();
    }//GEN-LAST:event_jBtnDeletarActionPerformed

    private void jBtnTelaRegVeicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTelaRegVeicActionPerformed
        new TelaRegistroVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnTelaRegVeicActionPerformed

    private void jBtnTema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTema1ActionPerformed
        if (ThemeAdm.getTheme() == ThemeAdm.Theme.LIGHT) {
                        ThemeAdm.setTheme(ThemeAdm.Theme.DARK);
                    } else {
                        ThemeAdm.setTheme(ThemeAdm.Theme.LIGHT);
                    }
                ThemeAdm.applyTheme(this);
    }//GEN-LAST:event_jBtnTema1ActionPerformed

    private void jBtnDisponibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDisponibActionPerformed
        alternarDisponibilidadeVeiculo();
    }//GEN-LAST:event_jBtnDisponibActionPerformed

    private void jbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInicioActionPerformed
        new TelaInicio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbtnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupEscolhaClasse;
    private javax.swing.JButton jBtnDeletar;
    private javax.swing.JButton jBtnDisponib;
    private javax.swing.JButton jBtnTelaRegVeic;
    private javax.swing.JButton jBtnTema1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDados;
    private javax.swing.JButton jbtnInicio;
    // End of variables declaration//GEN-END:variables
}
