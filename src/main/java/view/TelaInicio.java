package view;

import util.ThemeAdm;

public class TelaInicio extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaInicio.class.getName());
    
    public TelaInicio() {
        initComponents();
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
        setLocationRelativeTo(null);
        this.setTitle("GynLog");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTelaInicial = new javax.swing.JPanel();
        jButtonRegistrarMovimentações = new javax.swing.JButton();
        jButtonVerRelatorios = new javax.swing.JButton();
        jButtonRegistrarVeiculo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonFehcarSistema = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTelaInicial.setBackground(new java.awt.Color(204, 204, 204));

        jButtonRegistrarMovimentações.setBackground(new java.awt.Color(153, 153, 153));
        jButtonRegistrarMovimentações.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRegistrarMovimentações.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistrarMovimentações.setText("Registrar Movimentações");
        jButtonRegistrarMovimentações.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrarMovimentações.addActionListener(this::jButtonRegistrarMovimentaçõesActionPerformed);

        jButtonVerRelatorios.setBackground(new java.awt.Color(153, 153, 153));
        jButtonVerRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonVerRelatorios.setForeground(new java.awt.Color(0, 0, 0));
        jButtonVerRelatorios.setText("Ver Relatórios");
        jButtonVerRelatorios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVerRelatorios.addActionListener(this::jButtonVerRelatoriosActionPerformed);

        jButtonRegistrarVeiculo.setBackground(new java.awt.Color(153, 153, 153));
        jButtonRegistrarVeiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonRegistrarVeiculo.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistrarVeiculo.setText("Registrar Veiculo");
        jButtonRegistrarVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRegistrarVeiculo.addActionListener(this::jButtonRegistrarVeiculoActionPerformed);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Serviços:");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 3, 90)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("GynLog");

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Olá, Seja Bem-vindo(a) ao Sistema de Gestão de Frota da");

        jButtonFehcarSistema.setBackground(new java.awt.Color(153, 153, 153));
        jButtonFehcarSistema.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFehcarSistema.setForeground(new java.awt.Color(0, 0, 0));
        jButtonFehcarSistema.setText("Sair");
        jButtonFehcarSistema.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFehcarSistema.addActionListener(this::jButtonFehcarSistemaActionPerformed);

        javax.swing.GroupLayout jPanelTelaInicialLayout = new javax.swing.GroupLayout(jPanelTelaInicial);
        jPanelTelaInicial.setLayout(jPanelTelaInicialLayout);
        jPanelTelaInicialLayout.setHorizontalGroup(
            jPanelTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(358, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTelaInicialLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTelaInicialLayout.createSequentialGroup()
                        .addGroup(jPanelTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                                .addComponent(jButtonRegistrarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVerRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonFehcarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(133, 133, 133)
                        .addComponent(jButtonRegistrarMovimentações, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        jPanelTelaInicialLayout.setVerticalGroup(
            jPanelTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTelaInicialLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrarMovimentações, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButtonFehcarSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTelaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarMovimentaçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarMovimentaçõesActionPerformed
       logger.info("Redirecionando para tela de Registro de Movimentações...");
        new TelaRegistroPrejuizo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegistrarMovimentaçõesActionPerformed

    private void jButtonVerRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerRelatoriosActionPerformed
        logger.info("Redirecionando para tela de Relatórios...");
        new telaGerarRelatorios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVerRelatoriosActionPerformed

    private void jButtonRegistrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarVeiculoActionPerformed
        logger.info("Redirecionando para tela de Registro de Veículos...");
        new TelaRegistroVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonRegistrarVeiculoActionPerformed

    private void jButtonFehcarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFehcarSistemaActionPerformed
        int confirmacao =  javax.swing.JOptionPane.showConfirmDialog(this, 
                "Tem certeza que deseja sair do sistema?" , 
                "Confirmação de Saída" , 
                javax.swing.JOptionPane.YES_NO_OPTION, 
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );
        
        if(confirmacao == javax.swing.JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonFehcarSistemaActionPerformed

    /**
     * @param args the command line arguments
     */
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
        java.awt.EventQueue.invokeLater(() -> new TelaInicio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFehcarSistema;
    private javax.swing.JButton jButtonRegistrarMovimentações;
    private javax.swing.JButton jButtonRegistrarVeiculo;
    private javax.swing.JButton jButtonVerRelatorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelTelaInicial;
    // End of variables declaration//GEN-END:variables
}
