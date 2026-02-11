package view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Veiculo;
import util.ThemeAdm;

public class TelaPesquisaVeiculo extends javax.swing.JFrame {

    public TelaPesquisaVeiculo() {
        initComponents();
        inicializarMarcasModelos();
        configurarComponentes();
        setLocationRelativeTo(null);
        this.setTitle("GynLog");
        ThemeAdm.setTheme(ThemeAdm.loadSavedTheme());
        ThemeAdm.applyThemeAndSetup(this);
    }
    
    private Map<String, List<String>> marcasModelos = new HashMap<>();
    private javax.swing.JPopupMenu dropdownModelo;
    private javax.swing.JPopupMenu dropdownMarca;
    
    // Lista de veículos
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
    
    // Configuração de componentes ------------------
    private void configurarComponentes() {
        // Configurar tabela como não editável
        jTDadosPesquisa.setDefaultEditor(Object.class, null);
        
        // Configurar campo de entrada inicialmente invisível
        jTFEntrada.setVisible(false);
        jLTexto.setVisible(false);
        jTFEntrada.setText("");
        
        // Configurar listener do ComboBox
        jCBFiltros.addActionListener(e -> configurarCampoPesquisa());
    }
    
    // COnfiguração do campo de pesquisa usando filtros
    private void configurarCampoPesquisa() {
        String filtroSelecionado = jCBFiltros.getSelectedItem().toString();
        
        // Limpa a tabela
        limparTabela();
        
        // Remove listeners anteriores
        removerListeners(jTFEntrada);
        
        switch (filtroSelecionado) {
            case "---":
                jTFEntrada.setVisible(false);
                jLTexto.setVisible(false);
                limparTabela();
                break;
                
            case "Id do Veículo":
                jTFEntrada.setVisible(true);
                jLTexto.setVisible(true);
                jTFEntrada.setText("");
                jLTexto.setText("Digite o ID:");
                configurarCampoId();
                break;
                
            case "Placa":
                jTFEntrada.setVisible(true);
                jLTexto.setVisible(true);
                jTFEntrada.setText("");
                jLTexto.setText("Digite a Placa:");
                configurarCampoPlaca();
                break;
                
            case "Modelo":
                jTFEntrada.setVisible(true);
                jLTexto.setVisible(true);
                jTFEntrada.setText("");
                jLTexto.setText("Digite o Modelo:");
                configurarCampoModelo();
                break;
                
            case "Marca":
                jTFEntrada.setVisible(true);
                jLTexto.setVisible(true);
                jTFEntrada.setText("");
                jLTexto.setText("Digite a Marca:");
                configurarCampoMarca();
                break;
                
            case "Ano de Fabricação":
                jTFEntrada.setVisible(true);
                jLTexto.setVisible(true);
                jTFEntrada.setText("");
                jLTexto.setText("Digite o Ano:");
                configurarCampoAno();
                break;
                
            case "Disponíveis":
                jTFEntrada.setVisible(false);
                jLTexto.setVisible(false);
                pesquisarDisponiveis(true);
                break;
                
            case "Indisponíveis":
                jTFEntrada.setVisible(false);
                jLTexto.setVisible(false);
                pesquisarDisponiveis(false);
                break;
        }
        
        jTFEntrada.requestFocus();
    }
    
    // Filtro: ID
    private void configurarCampoId() {
        // Aceita apenas números
        jTFEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
                    evt.consume();
                }
            }
            
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = jTFEntrada.getText().trim();
                if (!texto.isEmpty()) {
                    pesquisarPorId(texto);
                } else {
                    limparTabela();
                }
            }
        });
    }
    
    private void pesquisarPorId(String idTexto) {
        try {
            int id = Integer.parseInt(idTexto);
            ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
            ArrayList<Veiculo> resultados = new ArrayList<>();
            
            for (Veiculo v : todosVeiculos) {
                if (String.valueOf(v.getIdVeiculo()).contains(idTexto)) {
                    resultados.add(v);
                }
            }
            
            if (resultados.isEmpty() && idTexto.length() == 6) {
                int resposta = JOptionPane.showConfirmDialog(this,
                    "ID não encontrado. Deseja registrar um novo veículo?",
                    "ID não cadastrado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (resposta == JOptionPane.YES_OPTION) {
                    new TelaRegistroVeiculo().setVisible(true);
                    this.dispose();
                }
            }
            
            preencherTabela(resultados);
            
        } catch (NumberFormatException e) {
            limparTabela();
        }
    }
    
    // Filtro: Placa --------------------------------
    private void configurarCampoPlaca() {
        jTFEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = jTFEntrada.getText().trim().toUpperCase();
                if (!texto.isEmpty()) {
                    pesquisarPorPlaca(texto);
                } else {
                    limparTabela();
                }
            }
        });
        
        jTFEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String placa = jTFEntrada.getText().trim();
                if (!placa.isEmpty() && !isPlacaValidaMercosul(placa)) {
                    JOptionPane.showMessageDialog(TelaPesquisaVeiculo.this,
                        "Placa inválida. Formato esperado: Mercosul (ABC1D23) ou Placa Cinza (ABC1234)",
                        "Formato Inválido",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });
    }
    
    private void pesquisarPorPlaca(String placa) {
        ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
        ArrayList<Veiculo> resultados = new ArrayList<>();
        
        for (Veiculo v : todosVeiculos) {
            if (v.getPlaca().toUpperCase().contains(placa)) {
                resultados.add(v);
            }
        }
        
        if (resultados.isEmpty() && isPlacaValidaMercosul(placa)) {
            int resposta = JOptionPane.showConfirmDialog(this,
                "Placa não encontrada. Deseja registrar um novo veículo?",
                "Placa não cadastrada",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            
            if (resposta == JOptionPane.YES_OPTION) {
                new TelaRegistroVeiculo().setVisible(true);
                this.dispose();
            }
        }
        
        preencherTabela(resultados);
    }
    
    private boolean isPlacaValidaMercosul(String placa) {
        String regex = "^[A-Z]{3}-?[0-9][A-Z0-9][0-9]{2}$";
        return placa.toUpperCase().matches(regex);
    }
    
    // Filtro: Modelo
    private void configurarCampoModelo() {
        configurarDropdownSugestao(jTFEntrada, false);
        
        jTFEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = jTFEntrada.getText().trim();
                if (!texto.isEmpty()) {
                    pesquisarPorModelo(texto);
                } else {
                    limparTabela();
                }
            }
        });
    }
    
    private void pesquisarPorModelo(String modelo) {
        ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
        ArrayList<Veiculo> resultados = new ArrayList<>();
        
        for (Veiculo v : todosVeiculos) {
            if (v.getModelo().toLowerCase().contains(modelo.toLowerCase())) {
                resultados.add(v);
            }
        }
        
        if (resultados.isEmpty()) {
            // Verifica se o modelo existe na lista de modelos cadastrados
            boolean modeloExiste = false;
            for (List<String> modelos : marcasModelos.values()) {
                for (String m : modelos) {
                    if (m.equalsIgnoreCase(modelo)) {
                        modeloExiste = true;
                        break;
                    }
                }
            }
            
            if (modeloExiste) {
                JOptionPane.showMessageDialog(this,
                    "Modelo '" + modelo + "' existe na lista, mas não há veículos cadastrados.",
                    "Sem resultados",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                int resposta = JOptionPane.showConfirmDialog(this,
                    "Modelo não encontrado. Pode estar digitado incorretamente.\n" +
                    "Deseja registrar um novo veículo?",
                    "Modelo não cadastrado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (resposta == JOptionPane.YES_OPTION) {
                    new TelaRegistroVeiculo().setVisible(true);
                    this.dispose();
                }
            }
        }
        
        preencherTabela(resultados);
    }
    
    // Filtro: Marca --------------------------------
    private void configurarCampoMarca() {
        configurarDropdownMarca(jTFEntrada);
        
        jTFEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = jTFEntrada.getText().trim();
                if (!texto.isEmpty()) {
                    pesquisarPorMarca(texto);
                } else {
                    limparTabela();
                }
            }
        });
    }
    
    private void pesquisarPorMarca(String marca) {
        ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
        ArrayList<Veiculo> resultados = new ArrayList<>();
        
        for (Veiculo v : todosVeiculos) {
            if (v.getMarca().toLowerCase().contains(marca.toLowerCase())) {
                resultados.add(v);
            }
        }
        
        if (resultados.isEmpty()) {
            boolean marcaExiste = marcasModelos.containsKey(marca);
            
            if (marcaExiste) {
                JOptionPane.showMessageDialog(this,
                    "Marca '" + marca + "' existe na lista, mas não há veículos cadastrados.",
                    "Sem resultados",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                int resposta = JOptionPane.showConfirmDialog(this,
                    "Marca não encontrada. Pode estar digitada incorretamente.\n" +
                    "Deseja registrar um novo veículo?",
                    "Marca não cadastrada",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (resposta == JOptionPane.YES_OPTION) {
                    new TelaRegistroVeiculo().setVisible(true);
                    this.dispose();
                }
            }
        }
        
        preencherTabela(resultados);
    }
    
    // Filtro: Ano de Fabricação ----------------------------
    private void configurarCampoAno() {
        jTFEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != java.awt.event.KeyEvent.VK_BACK_SPACE) {
                    evt.consume();
                }
            }
            
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = jTFEntrada.getText().trim();
                if (!texto.isEmpty()) {
                    pesquisarPorAno(texto);
                } else {
                    limparTabela();
                }
            }
        });
    }
    
    private void pesquisarPorAno(String anoTexto) {
        try {
            int ano = Integer.parseInt(anoTexto);
            ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
            ArrayList<Veiculo> resultados = new ArrayList<>();
            
            for (Veiculo v : todosVeiculos) {
                if (String.valueOf(v.getanoFabricacao()).contains(anoTexto)) {
                    resultados.add(v);
                }
            }
            
            preencherTabela(resultados);
            
        } catch (NumberFormatException e) {
            limparTabela();
        }
    }
    
    // Filtro: Disponibilidade ---------------------------
    private void pesquisarDisponiveis(boolean disponivel) {
        ArrayList<Veiculo> todosVeiculos = util.ArquivoTXT_Veiculo.LerArquivo();
        ArrayList<Veiculo> resultados = new ArrayList<>();
        
        for (Veiculo v : todosVeiculos) {
            if (v.isStatus() == disponivel) {
                resultados.add(v);
            }
        }
        
        preencherTabela(resultados);
        
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Nenhum veículo " + (disponivel ? "disponível" : "indisponível") + " encontrado.",
                "Sem resultados",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    
    // Dropdown (Modelo e Marca)
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
                    enterPressed[0] = false;
                    return;
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

                // Busca apenas marcas
                for (String marca : marcasModelos.keySet()) {
                    if (marca.toLowerCase().startsWith(texto)) {
                        sugestoes.add(marca);
                    }
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
    
    // Utilitario -------------------
    private void removerListeners(javax.swing.JTextField campo) {
        for (java.awt.event.KeyListener kl : campo.getKeyListeners()) {
            campo.removeKeyListener(kl);
        }
        for (java.awt.event.FocusListener fl : campo.getFocusListeners()) {
            campo.removeFocusListener(fl);
        }
    }
    
    private void limparTabela() {
        DefaultTableModel model = (DefaultTableModel) jTDadosPesquisa.getModel();
        model.setRowCount(0);
    }
    
    private void preencherTabela(ArrayList<Veiculo> veiculos) {
        DefaultTableModel model = (DefaultTableModel) jTDadosPesquisa.getModel();
        model.setRowCount(0);
        
        for (Veiculo v : veiculos) {
            Object[] linha = {
                v.getIdVeiculo(),
                v.getPlaca(),
                v.getMarca(),
                v.getModelo(),
                v.getanoFabricacao(),
                v.getStatusTextual()
            };
            model.addRow(linha);
        }
    }
    
    private void configurarDropdownMarca(javax.swing.JTextField campo) {
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
                            
                            // PAREI AQUI MANO
//                        case java.awt.event.KeyEvent.VK_UP:
//                            evt.consume();
//                            if (selectedIndex[0] > 0) {
//                                menuItems.get(selectedIndex[0]).setBackground(COR_NORMAL);
//                                selectedIndex[0]--;
//                                menuItems.get(selectedIndex[0]).setBackground(COR_DESTAQUE);
//                                
//                                
//                                }
//                            break;
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
                    enterPressed[0] = false;
                    return;
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

                for (String marca : marcasModelos.keySet()) {
                    for (String modelo : marcasModelos.get(marca)) {
                        if (modelo.toLowerCase().startsWith(texto)) {
                            sugestoes.add(modelo);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEscolhaClasse = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCBFiltros = new javax.swing.JComboBox<>();
        jLTexto = new javax.swing.JLabel();
        jTFEntrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDadosPesquisa = new javax.swing.JTable();
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
        jLabel3.setText("Pesquisando na frota");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Escolha como realizar a pesquisa");

        jCBFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Id do Veículo", "Placa", "Modelo", "Marca", "Ano de Fabricação", "Disponíveis", "Indisponíveis" }));

        jLTexto.setText("Pesquisar por:");

        jTDadosPesquisa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTDadosPesquisa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBFiltros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLTexto))
                                .addGap(18, 18, 18)
                                .addComponent(jTFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLTexto)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
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
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(TelaPesquisaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisaVeiculo().setVisible(true);
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
    private javax.swing.JButton jBtnRegistrarMovimento;
    private javax.swing.JButton jBtnRegistrarNovo;
    private javax.swing.JButton jBtnTema;
    private javax.swing.JComboBox<String> jCBFiltros;
    private javax.swing.JLabel jLTexto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDadosPesquisa;
    private javax.swing.JTextField jTFEntrada;
    // End of variables declaration//GEN-END:variables
}
