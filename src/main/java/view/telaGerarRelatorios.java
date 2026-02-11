package view;

import javax.swing.JOptionPane;
import util.ThemeAdm;
import util.relatorioDespesaTotalFrota;
import util.relatorioDespesasVeiculo;
import util.relatorioGastoMensalCombustivelTotalFrota;
import util.relatorioIPVATotalAnualFrota;
import util.relatorioTotalMultasVeiculo;
import util.relatorioVeiculosInativos;

/**
 * @author Gabriel
 */
public class telaGerarRelatorios extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaGerarRelatorios.class.getName());

    public telaGerarRelatorios() {
        initComponents();
        jTFBuscaRelatorio.setEditable(true);
        jTFBuscaRelatorio.setEnabled(true);
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonRelatorioVeiculo = new javax.swing.JButton();
        jTFBuscaRelatorio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonDespesasMensais = new javax.swing.JButton();
        jButtonGastoCombustivel = new javax.swing.JButton();
        jButtonTotalIPVAanual = new javax.swing.JButton();
        jButtonVeiculosInativos = new javax.swing.JButton();
        jButtonMultasAnuaisVeiculo = new javax.swing.JButton();
        jButtonVoltarRelatorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jBtnTema = new javax.swing.JButton();
        jBtnListaMovimento1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(901, 572));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatórios");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Digite ID, mês ou ano:");

        jButtonRelatorioVeiculo.setBackground(new java.awt.Color(153, 153, 153));
        jButtonRelatorioVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRelatorioVeiculo.setText("Despesa total do veículo");
        jButtonRelatorioVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRelatorioVeiculo.addActionListener(this::jButtonRelatorioVeiculoActionPerformed);

        jTFBuscaRelatorio.setEditable(false);
        jTFBuscaRelatorio.setBackground(new java.awt.Color(153, 153, 153));
        jTFBuscaRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        jTFBuscaRelatorio.addActionListener(this::jTFBuscaRelatorioActionPerformed);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText(" Escolha qual relatório deseja: ");

        jButtonDespesasMensais.setBackground(new java.awt.Color(153, 153, 153));
        jButtonDespesasMensais.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDespesasMensais.setText("Despesa mensal total da frota");
        jButtonDespesasMensais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDespesasMensais.addActionListener(this::jButtonDespesasMensaisActionPerformed);

        jButtonGastoCombustivel.setBackground(new java.awt.Color(153, 153, 153));
        jButtonGastoCombustivel.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGastoCombustivel.setText("Gasto mensal total de combustível");
        jButtonGastoCombustivel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGastoCombustivel.addActionListener(this::jButtonGastoCombustivelActionPerformed);

        jButtonTotalIPVAanual.setBackground(new java.awt.Color(153, 153, 153));
        jButtonTotalIPVAanual.setForeground(new java.awt.Color(0, 0, 0));
        jButtonTotalIPVAanual.setText("Total de IPVA anual da frota");
        jButtonTotalIPVAanual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonTotalIPVAanual.addActionListener(this::jButtonTotalIPVAanualActionPerformed);

        jButtonVeiculosInativos.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVeiculosInativos.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVeiculosInativos.setText("Lista de veículos inativos");
        jButtonVeiculosInativos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVeiculosInativos.addActionListener(this::jButtonVeiculosInativosActionPerformed);

        jButtonMultasAnuaisVeiculo.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMultasAnuaisVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonMultasAnuaisVeiculo.setText("Total de multas anual do veículo");
        jButtonMultasAnuaisVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonMultasAnuaisVeiculo.addActionListener(this::jButtonMultasAnuaisVeiculoActionPerformed);

        jButtonVoltarRelatorio.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVoltarRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVoltarRelatorio.setText("Voltar à tela de início");
        jButtonVoltarRelatorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltarRelatorio.addActionListener(this::jButtonVoltarRelatorioActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBuscaRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonVoltarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73)))
                .addGap(154, 154, 154))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMultasAnuaisVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVeiculosInativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTotalIPVAanual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGastoCombustivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDespesasMensais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRelatorioVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFBuscaRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRelatorioVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButtonDespesasMensais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGastoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTotalIPVAanual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVeiculosInativos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMultasAnuaisVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonVoltarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jButton1.setText("Lista de Veículos Registrados");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Registrar novo veículo");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Registrar nova finança");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Inicio");

        jButton6.setText("Detalhes das movimentações");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(this::jButton6ActionPerformed);

        jButton7.setText("Fechar programa");
        jButton7.addActionListener(this::jButton7ActionPerformed);

        jBtnTema.setText("Claro / Escuro");
        jBtnTema.addActionListener(this::jBtnTemaActionPerformed);

        jBtnListaMovimento1.setText("Pesquisar veículos");
        jBtnListaMovimento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaMovimento1.addActionListener(this::jBtnListaMovimento1ActionPerformed);

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
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtnTema, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBtnListaMovimento1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnListaMovimento1)
                .addGap(19, 19, 19)
                .addComponent(jBtnTema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRelatorioVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioVeiculoActionPerformed
                                                            
        String filtro = jTFBuscaRelatorio.getText().trim();
        
        if (filtro.isEmpty() || !filtro.matches("^\\d{6}$")) {
            JOptionPane.showMessageDialog(this,
                    "Digite apenas o ID do Veículo (ex: 100001) com 6 dígitos para gerar o relatório geral de movimentos.",
                    "Filtro Necessário",
                    JOptionPane.WARNING_MESSAGE
            );
            jTFBuscaRelatorio.requestFocus();
            return;
        }

        new util.relatorioDespesasVeiculo().gerarRelatorio(
                "Movimentações Gerais do Veículo ID " + filtro,
                new String[]{"Data", "Descrição", "Tipo Despesa", "Valor (R$)"},
                filtro
        );
 
    }//GEN-LAST:event_jButtonRelatorioVeiculoActionPerformed

    private void jTFBuscaRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBuscaRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBuscaRelatorioActionPerformed

    private void jButtonDespesasMensaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDespesasMensaisActionPerformed
        // TODO add your handling code here:

        String filtro = jTFBuscaRelatorio.getText().trim();

        if (filtro.isEmpty() || !filtro.matches("\\d{1,2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Digite o Mês/Ano (ex: 11/2025) para gerar o Relatório de Despesas Mensais da Frota.", "Filtro Necessário", JOptionPane.WARNING_MESSAGE);
            jTFBuscaRelatorio.requestFocus();
            return;
        }

        try {
            String[] partes = filtro.split("/");
            int mes = Integer.parseInt(partes[0]);
            int ano = Integer.parseInt(partes[1]);

            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(this, "O Mês deve ser um valor entre 01 e 12.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                jTFBuscaRelatorio.requestFocus();
                return;
            }

            if (ano > 2025 || (ano == 2025 && mes > 11)) {
                JOptionPane.showMessageDialog(this,
                        "A data máxima permitida é Novembro de 2025 (11/2025).",
                        "Erro de Limite",
                        JOptionPane.ERROR_MESSAGE
                );
                jTFBuscaRelatorio.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            return;
        }

        new util.relatorioDespesaTotalFrota().gerarRelatorio(
                "Despesa Mensal da Frota (" + filtro + ")",
                new String[]{"ID Veículo", "Placa", "Total Custo (R$)"},
                filtro
        );

    }//GEN-LAST:event_jButtonDespesasMensaisActionPerformed

    private void jButtonGastoCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGastoCombustivelActionPerformed
        // TODO add your handling code here:

        String filtro = jTFBuscaRelatorio.getText().trim();

        // 1. Validação de Formato (Mês/Ano: Ex. 12/2024)
        if (filtro.isEmpty() || !filtro.matches("\\d{1,2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this,
                    "Digite o Mês/Ano (ex: 11/2025) para filtrar o custo de combustível.",
                    "Filtro Necessário",
                    JOptionPane.WARNING_MESSAGE
            );
            jTFBuscaRelatorio.requestFocus();
            return;
        }

        // 2. Validação de Lógica (Mês <= 12 e Limite 11/2025)
        try {
            String[] partes = filtro.split("/");
            int mes = Integer.parseInt(partes[0]);
            int ano = Integer.parseInt(partes[1]);

            if (mes < 1 || mes > 12) {
                JOptionPane.showMessageDialog(this, "O Mês deve ser um valor entre 01 e 12.", "Erro de Data", JOptionPane.ERROR_MESSAGE);
                jTFBuscaRelatorio.requestFocus();
                return;
            }

            // Regra de Limite: Não pode ser ano > 2025 OU (ano == 2025 E mês > 11)
            if (ano > 2025 || (ano == 2025 && mes > 11)) {
                JOptionPane.showMessageDialog(this,
                        "A data máxima permitida para este relatório é Novembro de 2025 (11/2025).",
                        "Erro de Limite",
                        JOptionPane.ERROR_MESSAGE
                );
                jTFBuscaRelatorio.requestFocus();
                return;
            }

        } catch (NumberFormatException e) {
            return;
        }

        // Chamada do Relatório com 'util.'
        new util.relatorioGastoMensalCombustivelTotalFrota().gerarRelatorio(
                "Custo Mensal de Combustível da Frota (" + filtro + ")",
                new String[]{"ID Veículo", "Data", "Custo (R$)"},
                filtro
        );

    }//GEN-LAST:event_jButtonGastoCombustivelActionPerformed

    private void jButtonVoltarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarRelatorioActionPerformed
        // TODO add your handling code here:
        new TelaInicio().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarRelatorioActionPerformed

    private void jButtonMultasAnuaisVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultasAnuaisVeiculoActionPerformed
        // TODO add your handling code here:
        String filtro = jTFBuscaRelatorio.getText().trim();

        if (filtro.isEmpty() || !filtro.matches("^\\d{6}/\\d{4}$")) {
            JOptionPane.showMessageDialog(this,
                    "Digite o ID do Veículo (6 dígitos) e o Ano (ex: 100001/2024) no campo de busca.",
                    "Filtro Necessário",
                    JOptionPane.WARNING_MESSAGE
            );
            jTFBuscaRelatorio.requestFocus();
            return;
        }

        String[] partesFiltro = filtro.split("/");
        String idVeiculoStr = partesFiltro[0].trim();
        String anoFiltro = partesFiltro[1].trim();

        new util.relatorioTotalMultasVeiculo().gerarRelatorio(
                "Multas Anuais do Veículo " + idVeiculoStr + " (" + anoFiltro + ")",
                new String[]{"Data", "Valor (R$)", "Descrição"},
                filtro
        );
    
    }//GEN-LAST:event_jButtonMultasAnuaisVeiculoActionPerformed

    private void jButtonTotalIPVAanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalIPVAanualActionPerformed
        // TODO add your handling code here:

        String filtro = jTFBuscaRelatorio.getText().trim();

        if (filtro.isEmpty() || !filtro.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(this,
                    "Digite o Ano (ex: 2024) para filtrar o custo de IPVA.",
                    "Filtro Necessário",
                    JOptionPane.WARNING_MESSAGE
            );
            jTFBuscaRelatorio.requestFocus();
            return;
        }

        try {
            int ano = Integer.parseInt(filtro);

            if (ano > 2024) {
                JOptionPane.showMessageDialog(this,
                        "O ano máximo permitido para relatórios de IPVA é 2024.",
                        "Erro de Limite",
                        JOptionPane.ERROR_MESSAGE
                );
                jTFBuscaRelatorio.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }

        new util.relatorioIPVATotalAnualFrota().gerarRelatorio(
                "IPVA Detalhado da Frota no Ano (" + filtro + ")",
                new String[]{"ID Veículo", "Valor (R$)"},
                filtro
        );

    }//GEN-LAST:event_jButtonTotalIPVAanualActionPerformed

    private void jButtonVeiculosInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVeiculosInativosActionPerformed
        // TODO add your handling code here:
        jTFBuscaRelatorio.setText("");

        new relatorioVeiculosInativos().gerarRelatorio(
                "Lista de Veículos Inativos da Frota",
                new String[]{"ID Veículo", "Placa", "Marca", "Modelo", "Ano", "Status"},
                ""
        );
    }//GEN-LAST:event_jButtonVeiculosInativosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaListaVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaRegistroVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new TelaRegistroPrejuizo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int confirmacao =  javax.swing.JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja sair do sistema?" ,
            "Confirmação de Saída" ,
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if(confirmacao == javax.swing.JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBtnTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTemaActionPerformed
        if (ThemeAdm.getTheme() == ThemeAdm.Theme.LIGHT) {
                ThemeAdm.setTheme(ThemeAdm.Theme.DARK);
            } else {
                ThemeAdm.setTheme(ThemeAdm.Theme.LIGHT);
            }
        ThemeAdm.applyTheme(this);
    }//GEN-LAST:event_jBtnTemaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new telaGerarRelatorios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new telaGerarRelatorios().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnListaMovimento1;
    private javax.swing.JButton jBtnTema;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonDespesasMensais;
    private javax.swing.JButton jButtonGastoCombustivel;
    private javax.swing.JButton jButtonMultasAnuaisVeiculo;
    private javax.swing.JButton jButtonRelatorioVeiculo;
    private javax.swing.JButton jButtonTotalIPVAanual;
    private javax.swing.JButton jButtonVeiculosInativos;
    private javax.swing.JButton jButtonVoltarRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTFBuscaRelatorio;
    // End of variables declaration//GEN-END:variables
}
