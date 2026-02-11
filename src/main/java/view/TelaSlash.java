package view;

import java.awt.Color;
import java.util.Random;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import util.ThemeAdm;

public class TelaSlash extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaSlash.class.getName());
    
    public TelaSlash() {
        setUndecorated(true);
        initComponents();
        
        UIManager.put("nimbusOrange", new Color(80, 120, 255));
        SwingUtilities.updateComponentTreeUI(this);
        
        configurarJanela();
        iniciarCarregamento();
        ThemeAdm.addRememberOnClose(this);
        ThemeAdm.applyTheme(this);
    }

    // Frases rotativas para carregar ------------------------------------------
    private static final String[] FRASES_CARREGAMENTO = {
        "Iniciando sistema GynLog...",
        "Carregando lista de veículos...",
        "Conectando ao servidor...",
        "Verificando disponibilidade da frota...",
        "Ativando filtros inteligentes...",
        "Atualizando documentos...",
        "Baixando backups recentes...",
        "Sincronizando dados de veículos...",
        "Validando placas e registros...",
        "Carregando histórico de locações...",
        "Preparando interface do usuário...",
        "Verificando integridade dos arquivos...",
        "Configurando módulos do sistema...",
        "Atualizando catálogo de marcas...",
        "Carregando relatórios financeiros...",
        "Sincronizando com banco de dados...",
        "Preparando dashboard de controle...",
        "Verificando contratos ativos...",
        "Atualizando status da frota...",
        "Finalizando inicialização..."
    };
    
    private Random random = new Random();
    
    private void configurarJanela() {
        setLocationRelativeTo(null);
        
        
        // Barra de carregamento (altura 5px) ----------------------------------
        jPBLoading.setPreferredSize(new java.awt.Dimension(jPBLoading.getPreferredSize().width, 10));
        
        // Inicia barra de progresso em 0 --------------------------------------
        jPBLoading.setValue(0);
        jPBLoading.setStringPainted(true);
        
        // Texto carregamento --------------------------------------------------
        jLInitializing.setText("Inicializando sistema...");
    }
    
    private void iniciarCarregamento() {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                int progresso = 0;
                int incremento = 5; 
                int delayBase = 200;
                
                while (progresso <= 100) {
                    publish(progresso);
                    
                    // Delay variável para parecer mais natural ----------------
                    int delay = delayBase + random.nextInt(120); // 200-300ms
                    Thread.sleep(delay);
                    
                    progresso += incremento;
                }
                return null;
            }
            
            @Override
            protected void process(java.util.List<Integer> chunks) {
                int ultimoProgresso = chunks.get(chunks.size() - 1);
                
                jPBLoading.setValue(ultimoProgresso);
                
                // Rolagem de frases -------------------------------------------
                if (ultimoProgresso < 100) {
                    int indiceFrase = (ultimoProgresso / 5) % FRASES_CARREGAMENTO.length;
                    jLInitializing.setText(FRASES_CARREGAMENTO[indiceFrase]);
                } else {
                    jLInitializing.setText("Carregamento concluído!");
                }
            }
            
            @Override
            protected void done() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    logger.log(java.util.logging.Level.WARNING, "Interrupção no sleep final", e);
                }
                
                // Abre tela principal (precisa de uma tela principal) ---------
                abrirTelaPrincipal();
            }
        };
        worker.execute();
    }
    
    // Abre a tela principal e fecha a splash screen ---------------------------
    private void abrirTelaPrincipal() {
        java.awt.EventQueue.invokeLater(() -> {
//            setAlwaysOnTop(false);
            new TelaInicio().setVisible(true);
            dispose();
        });
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jPBLoading = new javax.swing.JProgressBar();
        jLInitializing = new javax.swing.JLabel();
        jLVersionamento = new javax.swing.JLabel();
        jLDireitos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLTitulo.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setText("GynLog");

        jLInitializing.setText("jLabel2");

        jLVersionamento.setText("Versão 0.26");

        jLDireitos.setText("© 2025 - Aravia. Todos direitos reservados.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPBLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLInitializing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLVersionamento)
                                    .addComponent(jLTitulo)
                                    .addComponent(jLDireitos))
                                .addGap(0, 287, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLTitulo)
                .addGap(62, 62, 62)
                .addComponent(jLVersionamento)
                .addGap(18, 18, 18)
                .addComponent(jLDireitos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(jLInitializing, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
        java.awt.EventQueue.invokeLater(() -> new TelaSlash().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDireitos;
    private javax.swing.JLabel jLInitializing;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLVersionamento;
    private javax.swing.JProgressBar jPBLoading;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
