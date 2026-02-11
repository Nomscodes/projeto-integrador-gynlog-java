package view;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Veiculo;
import util.ThemeAdm;

public class TelaRegistroVeiculo extends javax.swing.JFrame {

    public TelaRegistroVeiculo() {
        initComponents();
        inicializarMarcasModelos();
        adicionarPlaceholders();
        configurarAutocomplete();
        adicionarValidacoesFoco();
        configurarComboBoxDisponibilidade();
        configurarCampoIdAutomatico();
        permitirApenasNumeros(jTFAnoFabric);
        setLocationRelativeTo(null);
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
        this.setTitle("GynLog");
    }
    
    // Lista de marcas e modelos de veículos -----------------------------------
    private Map<String, List<String>> marcasModelos = new HashMap<>();
    
    // Inicializa Marcas e Modelos (A completar) -------------------------------
    private void inicializarMarcasModelos(){
        // Volkswagen ----------------------------------------------------------
        marcasModelos.put("Volkswagen", Arrays.asList(
                "Delivery 4.150", // caminhão leve
                "Delivery 11.180", // caminhão leve
                "Constellation 24.280", // caminhão pesado
                "Constellation 33.460", // caminhão extrapesado
                "Worker 13.180", // caminhão
                "Worker 17.210", // caminhão
                "Amarok", // caminhonete
                "Amarok V6", // caminhonete
                "Kombi Furgão", // van
                "Volksbus 9-160", // ônibus urbano
                "Volksbus 17-230", // ônibus rodoviário
                "Crafter 2.0", // van
                "Crafter Truck", // caminhão leve
                "Transporter T6", // van
                "Transporter Chassis" // caminhão leve
        ));

        // Mercedes-Benz -----------------------------------------------------------
        marcasModelos.put("Mercedes-Benz", Arrays.asList(
                "Accelo 815", // caminhão leve
                "Accelo 1016", // caminhão leve
                "Atego 1719", // caminhão médio
                "Atego 2426", // caminhão pesado
                "Actros 2651", // caminhão extrapesado
                "Actros 2553", // caminhão extrapesado
                "Sprinter 314 CDI", // van
                "Sprinter 415 CDI", // van
                "Sprinter 515 CDI", // van
                "Sprinter Street", // van
                "OF-1519", // ônibus urbano
                "OH-1622", // ônibus rodoviário
                "O-500 RSD", // ônibus rodoviário
                "X-Class", // caminhonete
                "G-Class Pickup (custom)" // caminhonete
        ));

        // Ford --------------------------------------------------------------------
        marcasModelos.put("Ford", Arrays.asList(
                "F-250", // caminhonete pesada
                "F-350", // caminhonete pesada
                "F-4000", // caminhão leve
                "F-4000 4x4", // caminhão leve
                "Cargo 1119", // caminhão leve
                "Cargo 1519", // caminhão médio
                "Cargo 2429", // caminhão pesado
                "Cargo 3131", // caminhão pesado
                "Transit Van", // van
                "Transit Furgão", // van
                "Transit Chassi", // caminhão leve
                "Torino Custom" // ônibus urbano (modificado)
        ));

        // Chevrolet ---------------------------------------------------------------
        marcasModelos.put("Chevrolet", Arrays.asList(
                "S10", // caminhonete
                "S10 High Country", // caminhonete
                "Silverado 1500", // caminhonete
                "Silverado 2500 HD", // caminhonete pesada
                "Silverado 3500 HD", // caminhonete pesada
                "Chevy Van G20", // van
                "Express 2500", // van
                "Express 3500 Cutaway" // caminhão leve
        ));

        // Fiat --------------------------------------------------------------------
        marcasModelos.put("Fiat", Arrays.asList(
                "Ducato Furgão", // van
                "Ducato Minibus", // van
                "Ducato Cargo Maxi", // van
                "Scudo", // van
                "Talento", // van
                "Toro", // caminhonete leve
                "Fullback" // caminhonete
        ));

        // Iveco -------------------------------------------------------------------
        marcasModelos.put("Iveco", Arrays.asList(
                "Daily 35-150", // van
                "Daily 45-170", // caminhão leve
                "Daily Minibus", // van
                "Tector 11-190", // caminhão médio
                "Tector 24-300", // caminhão pesado
                "Hi-Way 480", // caminhão extrapesado
                "Hi-Road 440", // caminhão extrapesado
                "Hi-Way 560", // caminhão extrapesado
                "S-Way 570", // caminhão extrapesado
                "CityClass", // ônibus urbano
                "Popstar" // micro-ônibus
        ));

        // Volvo -------------------------------------------------------------------
        marcasModelos.put("Volvo", Arrays.asList(
                "FH 460", // caminhão extrapesado
                "FH 540", // caminhão extrapesado
                "FH 500", // caminhão extrapesado
                "FM 420", // caminhão pesado
                "FMX 540", // caminhão fora de estrada
                "B270F", // ônibus urbano
                "B310R", // ônibus rodoviário
                "B450R" // ônibus rodoviário
        ));

        // Scania ------------------------------------------------------------------
        marcasModelos.put("Scania", Arrays.asList(
                "R 450", // caminhão extrapesado
                "R 500", // caminhão extrapesado
                "S 500", // caminhão extrapesado
                "S 620", // caminhão extrapesado
                "P 360", // caminhão médio
                "P 280", // caminhão leve
                "K 310 IB", // ônibus rodoviário
                "F 280", // ônibus urbano
                "K 400 6x2" // ônibus rodoviário
        ));

        // MAN ---------------------------------------------------------------------
        marcasModelos.put("MAN", Arrays.asList(
                "TGX 28.440", // caminhão extrapesado
                "TGX 29.480", // caminhão extrapesado
                "TGS 26.440", // caminhão pesado
                "TGM 26.290", // caminhão médio
                "TGL 12.250", // caminhão leve
                "Lion's Coach", // ônibus rodoviário
                "Lion's City" // ônibus urbano
        ));

        // Renault -----------------------------------------------------------------
        marcasModelos.put("Renault", Arrays.asList(
                "Master Furgão", // van
                "Master Minibus", // van
                "Master Chassi", // caminhão leve
                "Trafic", // van
                "Alaskan" // caminhonete
        ));

        // Peugeot -----------------------------------------------------------------
        marcasModelos.put("Peugeot", Arrays.asList(
                "Boxer Cargo", // van
                "Boxer Minibus", // van
                "Expert", // van
                "Rifter", // van
                "Landtrek" // caminhonete
        ));

        // Citroën -----------------------------------------------------------------
        marcasModelos.put("Citroën", Arrays.asList(
                "Jumper Furgão", // van
                "Jumpy", // van
                "Spacetourer", // van
                "Berlingo Van" // van
        ));

        // Toyota ------------------------------------------------------------------
        marcasModelos.put("Toyota", Arrays.asList(
                "Hilux", // caminhonete
                "Hilux CD SRX", // caminhonete
                "Hilux Chassi", // caminhão leve
                "Coaster", // micro-ônibus
                "HiAce" // van
        ));

        // Nissan ------------------------------------------------------------------
        marcasModelos.put("Nissan", Arrays.asList(
                "Frontier", // caminhonete
                "Frontier XE", // caminhonete
                "NV350 Urvan", // van
                "Titan XD" // caminhonete pesada
        ));

        // Mitsubishi --------------------------------------------------------------
        marcasModelos.put("Mitsubishi", Arrays.asList(
                "L200 Triton", // caminhonete
                "L200 Savana", // caminhonete
                "L300", // van
                "Fuso Canter 6.5", // caminhão leve
                "Fuso Canter 8.5" // caminhão leve
        ));

        // Hyundai -----------------------------------------------------------------
        marcasModelos.put("Hyundai", Arrays.asList(
                "HR 2.5", // caminhão leve
                "HD 80", // caminhão leve
                "HD 160", // caminhão médio
                "County", // micro-ônibus
                "Solati" // van
        ));

        // Kia ---------------------------------------------------------------------
        marcasModelos.put("Kia", Arrays.asList(
                "Bongo K2500", // caminhão leve
                "Bongo K2700", // caminhão leve
                "Grand Carnival", // van
                "Pregio", // van
                "K9 Van" // van
        ));

        // Ram ---------------------------------------------------------------------
        marcasModelos.put("Ram", Arrays.asList(
                "Ram 1500", // caminhonete
                "Ram 2500", // caminhonete pesada
                "Ram 3500", // caminhonete extrapesada
                "ProMaster Van", // van
                "ProMaster Rapid" // van
        ));

        // Sprinter (custom brand) -------------------------------------------------
        marcasModelos.put("Sprinter Custom", Arrays.asList(
                "Sprinter Ambulância", // van
                "Sprinter Escolar", // van
                "Sprinter Executiva", // van
                "Sprinter Fretamento" // van
        ));

        // Agrale ------------------------------------------------------------------
        marcasModelos.put("Agrale", Arrays.asList(
                "Marruá AM200", // caminhonete militar
                "Marruá AM300", // caminhonete militar
                "Agrale 8700", // ônibus
                "Agrale 10500", // ônibus
                "Agrale 14000 S" // caminhão médio
        ));

        // Marcopolo (carroceria) --------------------------------------------------
        marcasModelos.put("Marcopolo", Arrays.asList(
                "Torino", // ônibus urbano
                "Paradiso 1200", // ônibus rodoviário
                "Paradiso 1800 DD", // ônibus rodoviário double deck
                "Viaggio 1050", // ônibus rodoviário
                "Senior Midi" // micro-ônibus
        ));

        // Caio Induscar -----------------------------------------------------------
        marcasModelos.put("Caio", Arrays.asList(
                "Apache Vip", // ônibus urbano
                "Millennium", // ônibus urbano
                "Mondego", // ônibus rodoviário
                "Foz Super", // micro-ônibus
                "Tile Ade" // ônibus rodoviário
        ));
            //marcasModelos.put("Peugeot", Arrays.asList("")); modelo para mais marcas
    }
    
    // Configuração de sugestão automatica -------------------------------------
    private void configurarAutocomplete(){
        // Sugestão automatica de modelo ---------------------------------------
        configurarDropdownSugestao(jTFModelo, false);
    }
    
    private void configurarCampoIdAutomatico() {
        // Torna o campo não editável ------------------------------------------
        jTFVeiculoID.setEditable(false);
    }
    
    // Configuração de dropdown ------------------------------------------------
    private void configurarDropdownSugestao(javax.swing.JTextField campo, boolean isMarca) {
        javax.swing.JPopupMenu dropdown = new javax.swing.JPopupMenu();
        dropdown.setFocusable(false);

        final java.util.List<javax.swing.JMenuItem> menuItems = new java.util.ArrayList<>();
        final int[] selectedIndex = {-1};
        final boolean[] enterPressed = {false};
        
        final Color COR_NORMAL = Color.WHITE;
        final Color COR_DESTAQUE = new Color(230, 240, 255);

        campo.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (dropdown.isVisible()) {
                    switch (evt.getKeyCode()) {
                        case java.awt.event.KeyEvent.VK_DOWN:
                            evt.consume();
                            if (selectedIndex[0] < menuItems.size() - 1) {
                                if (selectedIndex[0] >= 0) {
                                    menuItems.get(selectedIndex[0]).setBackground(COR_NORMAL);
                                }
                                selectedIndex[0]++;
                                menuItems.get(selectedIndex[0]).setBackground(COR_DESTAQUE);
                            }
                            break;
                        case java.awt.event.KeyEvent.VK_UP:
                            evt.consume();
                            if (selectedIndex[0] > 0) {
                                menuItems.get(selectedIndex[0]).setBackground(COR_NORMAL);
                                selectedIndex[0]--;
                                menuItems.get(selectedIndex[0]).setBackground(COR_DESTAQUE);
                            } else if (selectedIndex[0] == 0) {
                                menuItems.get(selectedIndex[0]).setBackground(COR_NORMAL);
                                selectedIndex[0] = -1;
                            }
                            break;
                        case java.awt.event.KeyEvent.VK_ENTER:
                            evt.consume();
                            enterPressed[0] = true;
                            if (selectedIndex[0] >= 0 && selectedIndex[0] < menuItems.size()) {
                                menuItems.get(selectedIndex[0]).doClick();
                            }
                            dropdown.setVisible(false);
                            menuItems.clear();
                            selectedIndex[0] = -1;
                            break;
                        case java.awt.event.KeyEvent.VK_ESCAPE:
                            evt.consume();
                            dropdown.setVisible(false);
                            selectedIndex[0] = -1;
                            break;
                    }
                }
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (enterPressed[0]) {
                    enterPressed[0] = false; // Reseta a flag
                    return; // Sai sem fazer nada
                }
                String texto = campo.getText().trim().toLowerCase();

                if (dropdown.isVisible() && (
                        evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP || 
                        evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN || 
                        evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER ||
                        evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE)) {
                    return;
                }

                if (texto.isEmpty() || evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    dropdown.setVisible(false);
                    menuItems.clear();
                    selectedIndex[0] = -1;
                    return;
                }

                java.util.List<String> sugestoes = new java.util.ArrayList<>();
                java.util.Map<String, String> modeloParaMarca = new java.util.HashMap<>();

                for (String marca : marcasModelos.keySet()) {
                    for (String modelo : marcasModelos.get(marca)) {
                        if (modelo.toLowerCase().startsWith(texto)) {
                            sugestoes.add(modelo);
                            modeloParaMarca.put(modelo, marca);
                        }
                    }
                }

                if (sugestoes.size() >= 10) {
                    sugestoes = sugestoes.subList(0, 10);
                }

                dropdown.removeAll();
                menuItems.clear();
                selectedIndex[0] = -1;

                if (!sugestoes.isEmpty()) {
                    for (int i = 0; i < sugestoes.size(); i++) {
                        String sugestao = sugestoes.get(i);
                        javax.swing.JMenuItem item = new javax.swing.JMenuItem(sugestao);

                        item.setFocusable(false);
                        item.setBackground(COR_NORMAL);
                        item.setOpaque(true);

                        final int indice = i;
                        item.addMouseListener(new java.awt.event.MouseAdapter() {
                            @Override
                            public void mouseEntered(java.awt.event.MouseEvent e) {
                                if (selectedIndex[0] >= 0 && selectedIndex[0] < menuItems.size()) {
                                    menuItems.get(selectedIndex[0]).setBackground(COR_NORMAL);
                                }
                                selectedIndex[0] = indice;
                                item.setBackground(COR_DESTAQUE);
                            }
                        });

                        item.addActionListener(e -> {
                            campo.setText(sugestao);
                            campo.setForeground(Color.black);

                            String marcaCorrespondente = modeloParaMarca.get(sugestao);
                            if (marcaCorrespondente != null) {
                                jTFMarca.setText(marcaCorrespondente);
                                jTFMarca.setForeground(Color.black);
                            }

                            dropdown.setVisible(false);
                            menuItems.clear();
                            selectedIndex[0] = -1;
                            campo.requestFocusInWindow();
                        });

                        dropdown.add(item);
                        menuItems.add(item);
                    }

                    dropdown.show(campo, 0, campo.getHeight());
                } else {
                    dropdown.setVisible(false);
                }
            }
        });

        // Remove dropdown quando campo perde foco ----------------------------------------------------------------------------
        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    dropdown.setVisible(false);
                    menuItems.clear();
                    selectedIndex[0] = -1;
                });
            }
        });
    }
    
    // Apenas recebe numeros inteiros no campo jTFAnoFabric ----------------------------------------------------------------
    private void permitirApenasNumeros(javax.swing.JTextField campo) {
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_DELETE) {
                    evt.consume(); // Bloqueia o caractere
                }
            }
        });
    }
    
    // Metodos de Placeholder -----------------------------------------------------------------------------------------------------------
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
    
    private void atualizarPlaceholders() {
        final Color PLACEHOLDER_COLOR = ThemeAdm.getTheme() == ThemeAdm.Theme.LIGHT ? Color.GRAY : new Color(150, 150, 150);
        
        javax.swing.JTextField[] campos = {jTFVeiculoID, jTFPlaca, jTFMarca, jTFModelo, jTFAnoFabric};
        String[] placeholders = {
            "ID do veículo", 
            "Placa do veículo", 
            "Marca do veículo", 
            "Modelo do veículo", 
            "Ano de fabricação"
        };
        
        for (int i = 0; i < campos.length; i++) {
            if (campos[i].getText().equals(placeholders[i])) {
                campos[i].setForeground(PLACEHOLDER_COLOR);
            } else if (!campos[i].getText().isEmpty()) {
                campos[i].setForeground(ThemeAdm.getTextColor());
            }
        }
    }

    // Atribuição de textos Placeholders em campos vazios ----------------------
    private void adicionarPlaceholders() {
        aplicarPlaceholder(jTFVeiculoID, "ID do veículo");
        aplicarPlaceholder(jTFPlaca, "Placa do veículo");
        aplicarPlaceholder(jTFMarca, "Marca do veículo");
        aplicarPlaceholder(jTFModelo, "Modelo do veículo");
        aplicarPlaceholder(jTFAnoFabric, "Ano de fabricação");
    }
    
    // Verificação de padronização legal de placas originais -------------------
    private static boolean isPlacaValidaMercosul(String placa) {
        String regex = "^[A-Z]{3}-?[0-9][A-Z0-9][0-9]{2}$";
        return placa.toUpperCase().matches(regex);
    }
    
    
    
//    private void configurarRadioButtonDinamico() {
//    jRBbtnDisponibilidade.setText("Indisponível");
//    
//    jRBbtnDisponibilidade.addItemListener(new java.awt.event.ItemListener() {
//        @Override
//        public void itemStateChanged(java.awt.event.ItemEvent evt) {
//            if (jRBbtnDisponibilidade.isSelected()) {
//                    jRBbtnDisponibilidade.setText("Disponível");
//                } else {
//                    jRBbtnDisponibilidade.setText("Indisponível");
//                }
//            }
//        });
//    }

    private void configurarComboBoxDisponibilidade() {
        jCBDisponibilidade.setSelectedIndex(0);
        
        jCBDisponibilidade.addActionListener(e -> {
            int index = jCBDisponibilidade.getSelectedIndex();
            if (index == 0) {
                // "---" selecionado - estado neutro
            } else if (index == 1) {
                // "Disponivel" selecionado
                System.out.println("Status: Disponível");
            } else if (index == 2) {
                // "Indisponível" selecionado
                System.out.println("Status: Indisponível");
            }
        });
    }
    
    private void limparCampos() {
        jTFVeiculoID.setText("ID do veículo");
        jTFVeiculoID.setForeground(Color.GRAY);
        
        jTFPlaca.setText("Placa do veículo");
        jTFPlaca.setForeground(Color.GRAY);
        
        jTFMarca.setText("Marca do veículo");
        jTFMarca.setForeground(Color.GRAY);
        
        jTFModelo.setText("Modelo do veículo");
        jTFModelo.setForeground(Color.GRAY);
        
        jTFAnoFabric.setText("Ano de Fabricação");
        jTFAnoFabric.setForeground(Color.GRAY);
        
        jCBDisponibilidade.setSelectedIndex(0);
        
        jTFPlaca.requestFocus();
    }
    
    private Boolean obterDisponibilidadeDoComboBox() {
        int selectedIndex = jCBDisponibilidade.getSelectedIndex();
        
        if (selectedIndex == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, selecione a disponibilidade do veículo.",
                    "Campo Obrigatório",
                    JOptionPane.WARNING_MESSAGE
            );
            jCBDisponibilidade.requestFocus();
            return null;
        } else if (selectedIndex == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    private void adicionarValidacoesFoco() {
        // Validação do Id ao perder o foco ------------------------------------
        jTFVeiculoID.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String raw = jTFVeiculoID.getText().trim();
                
                if (raw.isEmpty() || raw.equals("ID do veículo")) {
                    return;
                }
                
                if (!raw.matches("\\d+")) {
                    JOptionPane.showMessageDialog(TelaRegistroVeiculo.this,
                            "O ID deve conter apenas números", 
                            "Erro de Validação",
                            JOptionPane.ERROR_MESSAGE);
                    jTFVeiculoID.requestFocus();
                    return;
                }
                
                if (raw.length() != 6) {
                    JOptionPane.showMessageDialog(TelaRegistroVeiculo.this,
                            "O ID deve possuir exatamente 6 dígitos.", 
                            "Erro de Validação", 
                            JOptionPane.ERROR_MESSAGE);
                    jTFVeiculoID.requestFocus();
                    return;
                }
                
                try {
                    int id = Integer.parseInt(raw);
                    java.util.ArrayList<model.Veiculo> Lista = util.ArquivoTXT_Veiculo.LerArquivo();
                    for (model.Veiculo veiculo : Lista) {
                        if (veiculo.getIdVeiculo() == id) {
                            JOptionPane.showMessageDialog(TelaRegistroVeiculo.this, 
                                    "Já existe um veículo com esse ID.", 
                                    "ID Duplicado", 
                                    JOptionPane.ERROR_MESSAGE);
                            jTFVeiculoID.requestFocus();
                            return;
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao verificar duplicidade: " + e.getMessage());
                }
            }
        });
        
        // Validação da Placa ao perder foco -----------------------------------
        jTFPlaca.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String placaRaw = jTFPlaca.getText().trim();
                
                if (placaRaw.isEmpty() || placaRaw.equals("Placa do veículo")) {
                    return;
                }
                
                String placa = placaRaw.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
                
                if (!isPlacaValidaMercosul(placa)) {
                    JOptionPane.showMessageDialog(TelaRegistroVeiculo.this, 
                            "Placa inválida. Padrão esperado: Mercosul (ABC1D23) ou Placa Cinza (ABC1234)", 
                            "Erro de Validação", 
                            JOptionPane.ERROR_MESSAGE);
                    jTFPlaca.requestFocus();
                    return;
                }
                
                if(util.ArquivoTXT_Veiculo.placaJaExiste(placa)) {
                    JOptionPane.showMessageDialog(TelaRegistroVeiculo.this,
                            "Já existe um veículo com a placa: " + placa + "\n" +
                            "Por favor, verifique se não é um registro duplicado.",
                            "Placa Duplicada",
                            JOptionPane.ERROR_MESSAGE
                    );
                    jTFPlaca.requestFocus();
                    return;
                }
                
                jTFPlaca.setText(placa);
                
                int proximoId = util.ArquivoTXT_Veiculo.gerarProximoId();
                jTFVeiculoID.setText(String.valueOf(proximoId));
                jTFVeiculoID.setForeground(Color.BLACK);
            }
        });
      
        // Validação do Modelo ao perder foco ----------------------------------
        jTFModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String raw = jTFModelo.getText().trim();
                
                if (raw.isEmpty() || raw.equals("Modelo do veículo")) {
                    return;
                }
                
                // Padroniza (primeira letra maiúscula) ------------------------
                String modeloPadr = raw.substring(0,1).toUpperCase() + (raw.length() > 1 ? raw.substring(1) : "");
                jTFModelo.setText(modeloPadr);
            }
        });
        
        // Validação do Ano ao perder foco -------------------------------------
        jTFAnoFabric.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String raw = jTFAnoFabric.getText().trim();
                
                if (raw.isEmpty() || raw.equals("Ano de fabricação")) {
                    return;
                }
                
                try {
                    int ano = Integer.parseInt(raw);
                    int anoAtual = java.time.Year.now().getValue();
                    int anoLimite = anoAtual + 1;
                    
                    if (ano < 1886 || ano > anoLimite) {
                        JOptionPane.showMessageDialog(TelaRegistroVeiculo.this,
                                "Ano inválido. Aceito entre 1886 e " + anoLimite + ".", 
                                "Erro de Validação", 
                                JOptionPane.ERROR_MESSAGE);
                        jTFAnoFabric.requestFocus();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(TelaRegistroVeiculo.this,
                            "Ano deve ser um número inteiro.", 
                            "Erro de Validação", 
                            JOptionPane.ERROR_MESSAGE);
                    jTFAnoFabric.requestFocus();
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEscolhaClasse = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFVeiculoID = new javax.swing.JTextField();
        jTFPlaca = new javax.swing.JTextField();
        jTFMarca = new javax.swing.JTextField();
        jTFModelo = new javax.swing.JTextField();
        jTFAnoFabric = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jBtnRegistrar = new javax.swing.JButton();
        jCBDisponibilidade = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtnListaVeiculos = new javax.swing.JButton();
        jBtnRegistrarNovo = new javax.swing.JButton();
        jBtnRegistrarMovimento = new javax.swing.JButton();
        jBtnHome = new javax.swing.JButton();
        jBtnListaMovimento = new javax.swing.JButton();
        jBtnExit = new javax.swing.JButton();
        jBtnTema = new javax.swing.JButton();
        jBtnListaMovimento1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GynLog");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registro de novo Veículo");

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

        jTFVeiculoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFVeiculoIDActionPerformed(evt);
            }
        });

        jTFPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPlacaActionPerformed(evt);
            }
        });

        jTFMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFMarcaActionPerformed(evt);
            }
        });

        jTFModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFModeloActionPerformed(evt);
            }
        });

        jTFAnoFabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAnoFabricActionPerformed(evt);
            }
        });

        jLabel2.setText("Disponibilidade:");

        jButton1.setText("Veja a frota completa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBtnRegistrar.setText("Registrar");
        jBtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarActionPerformed(evt);
            }
        });

        jCBDisponibilidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Disponível", "Indisponível" }));
        jCBDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDisponibilidadeActionPerformed(evt);
            }
        });

        jLabel4.setText("ID do veículo");

        jLabel5.setText("Placa do veículo");

        jLabel6.setText("Modelo do veículo");

        jLabel7.setText("Marca do veículo");

        jLabel8.setText("Ano de fabricação");

        jLabel9.setText("Como Cadastrar um Veículo: O ID do veículo é gerado automaticamente pelo sistema.");

        jLabel10.setText("Comece preenchendo a placa no formato Mercosul (ABC1D23) ou placa cinza (ABC-1234),");

        jLabel11.setText("depois informe a marca, modelo e ano de fabricação (não pode ser superior a um ano à frente");

        jLabel12.setText("da data atual). Em seguida, insira a quilometragem atual e selecione o estado de");

        jLabel13.setText("disponibilidade (Disponível ou Indisponível). Ao clicar em \"Registrar\", o veículo será salvo");

        jLabel14.setText("automaticamente em um arquivo local do sistema. ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTFPlaca)
                                .addComponent(jTFMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFVeiculoID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jTFModelo)
                                .addComponent(jLabel8)
                                .addComponent(jTFAnoFabric)
                                .addComponent(jLabel2)
                                .addComponent(jCBDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtnRegistrar)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(81, 81, 81))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFAnoFabric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFVeiculoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBDisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jBtnRegistrar))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jBtnListaVeiculos.setText("Lista de Veículos Registrados");
        jBtnListaVeiculos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListaVeiculosActionPerformed(evt);
            }
        });

        jBtnRegistrarNovo.setText("Registrar novo veículo");
        jBtnRegistrarNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrarNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarNovoActionPerformed(evt);
            }
        });

        jBtnRegistrarMovimento.setText("Registrar nova finança");
        jBtnRegistrarMovimento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnRegistrarMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarMovimentoActionPerformed(evt);
            }
        });

        jBtnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBtnHome.setText("Inicio");
        jBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHomeActionPerformed(evt);
            }
        });

        jBtnListaMovimento.setText("Gerar relatórios");
        jBtnListaMovimento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtnListaMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListaMovimentoActionPerformed(evt);
            }
        });

        jBtnExit.setText("Fechar programa");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });

        jBtnTema.setText("Claro / Escuro");
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
                        .addGap(0, 25, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jBtnExit)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFVeiculoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFVeiculoIDActionPerformed
        
    }//GEN-LAST:event_jTFVeiculoIDActionPerformed

    private void jTFPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPlacaActionPerformed
        
    }//GEN-LAST:event_jTFPlacaActionPerformed

    private void jTFMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFMarcaActionPerformed
                
    }//GEN-LAST:event_jTFMarcaActionPerformed

    private void jTFModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFModeloActionPerformed
        
    }//GEN-LAST:event_jTFModeloActionPerformed

    private void jTFAnoFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAnoFabricActionPerformed
        
    }//GEN-LAST:event_jTFAnoFabricActionPerformed

    private void jBtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarActionPerformed
        try {
            // Validações basicas  --------------------------------------------
            String idText = jTFVeiculoID.getText().trim();
            String placaText = jTFPlaca.getText().trim();
            String marcaText = jTFMarca.getText().trim();
            String modeloText = jTFModelo.getText().trim();
            String anoText = jTFAnoFabric.getText().trim();
            
            // Verificação da existencia dos placeholders
            if (idText.equals("ID do veículo") || idText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha uma placa válida primeiro.\n" +
                        "O ID será gerado automaticamente.",
                        "ID não Gerado",
                        JOptionPane.WARNING_MESSAGE
                );
                jTFPlaca.requestFocus();
                return;
            }
            
            //  CORREÇÃO: Usa o ID que já foi gerado
            int idVeiculo = Integer.parseInt(idText);
            
            if (placaText.equals("Placa do veículo") || placaText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha a placa do veículo.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE
                );
                jTFPlaca.requestFocus();
                return;
            }
            
            if (marcaText.equals("Marca do veículo") || marcaText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha a marca do veículo.", 
                        "Campo Obrigatório", 
                        JOptionPane.WARNING_MESSAGE
                );
                jTFMarca.requestFocus();
                return;
            }
            
            if (util.ArquivoTXT_Veiculo.placaJaExiste(placaText)) {
                JOptionPane.showMessageDialog(this,
                        "Já existe um veículo com a placa: " + placaText,
                        "Placa Duplicada",
                        JOptionPane.ERROR_MESSAGE
                );
                jTFPlaca.requestFocus();
                return;
            }
            
            if (modeloText.equals("Modelo do veículo") || modeloText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha o modelo do veículo.", 
                        "Campo Obrigatório", 
                        JOptionPane.WARNING_MESSAGE
                );
                jTFModelo.requestFocus();
                return;
            }
            
            if (anoText.equals("Ano de fabricação") || anoText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, preencha o ano de fabricação.", 
                        "Campo Obrigatório", 
                        JOptionPane.WARNING_MESSAGE
                );
                jTFAnoFabric.requestFocus();
                return;
            }
            
            // Recebendo valores -----------------------------------------------------------------------------------------------------------
            String placa = placaText;
            String marca = marcaText;
            String modelo = modeloText;
            int anoFabricacao = Integer.parseInt(anoText);
            
            Boolean status = obterDisponibilidadeDoComboBox();
            int selectedIndex = jCBDisponibilidade.getSelectedIndex();
            
            if (status == null) return;
            if (selectedIndex == 0) {
                // Se "---" está selecionado, pede para escolher
                JOptionPane.showMessageDialog(this,
                        "Por favor, selecione a disponibilidade do veículo.",
                        "Campo Obrigatório",
                        JOptionPane.WARNING_MESSAGE
                );
                jCBDisponibilidade.requestFocus();
                return;
            } else if (selectedIndex == 1) {
                // "Disponível"
                status = true;
            } else {
                // "Indisponível"
                status = false;
            }
            
            Veiculo novoVeiculo = new Veiculo(idVeiculo, placa, marca, modelo, anoFabricacao, status);
            
            // Salvando no arquivo Txt -----------------------------------------
            util.ArquivoTXT_Veiculo.salvarLinha(novoVeiculo);
            
            // Atualizando Lista e transferindo para o arquivo xlsx ------------
            java.util.ArrayList<Veiculo> listaAtualizada = util.ArquivoTXT_Veiculo.LerArquivo();
            util.ArquivoExcel_Veiculo.Transf_Excel(listaAtualizada, "Veiculo.xlsx");
            
            // Mensagem de sucesso com o ID gerado
            JOptionPane.showMessageDialog(this,
                    "Veículo registrado com sucesso!\n" +
                    "ID gerado: " + idVeiculo,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            // Limpando conteudo dos campos de registro ------------------------
            limparCampos();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro: Verifique se o ID e o Ano contêm apenas números válidos.\n\n" +
                    "Detalhes técnicos: " + e.getMessage(), 
                    "Formato Inválido",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Erro ao registrar veículo!\n\n" +
                    "Detalhes: " + e.getMessage(), 
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBtnRegistrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaListaVeiculo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                atualizarPlaceholders();
    }//GEN-LAST:event_jBtnTemaActionPerformed

    private void jBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHomeActionPerformed
        new TelaInicio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnHomeActionPerformed

    private void jCBDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDisponibilidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBDisponibilidadeActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupEscolhaClasse;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JButton jBtnHome;
    private javax.swing.JButton jBtnListaMovimento;
    private javax.swing.JButton jBtnListaMovimento1;
    private javax.swing.JButton jBtnListaVeiculos;
    private javax.swing.JButton jBtnRegistrar;
    private javax.swing.JButton jBtnRegistrarMovimento;
    private javax.swing.JButton jBtnRegistrarNovo;
    private javax.swing.JButton jBtnTema;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBDisponibilidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField jTFAnoFabric;
    private javax.swing.JTextField jTFMarca;
    private javax.swing.JTextField jTFModelo;
    private javax.swing.JTextField jTFPlaca;
    private javax.swing.JTextField jTFVeiculoID;
    // End of variables declaration//GEN-END:variables
}
