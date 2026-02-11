package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class ThemeAdm {
    
    public enum Theme {
        LIGHT,
        DARK
    }
    
    // Dimensões padrões das janelas
    private static final int DEFAULT_MIN_WIDTH = 901; // 901, 572
    private static final int DEFAULT_MIN_HEIGHT = 572;
    private static final int DEFAULT_PREF_WIDTH = 901;
    private static final int DEFAULT_PREF_HEIGHT = 572;
    
    private static final Preferences prefs = Preferences.userNodeForPackage(ThemeAdm.class);
    private static final String PREF_KEY = "app.theme";
    private static Theme temaAtual = Theme.LIGHT;
    
    // Cores modo CLARO --------------------------------------------------------
    private static final Color LIGHT_BACKGROUND = hex("#F8F9FA"); // background geral (Cinza Claro - o mais escuro do tema claro)
    private static final Color LIGHT_PANEL = hex("#FFFFFF"); // cards e painéis (Branco Puro - "elevado")
    private static final Color LIGHT_PRIMARY = hex("#1A73E8"); // Azul principal BOTÕES
    private static final Color LIGHT_SECONDARY = hex("#34A853"); // Verde vibrante
    private static final Color LIGHT_TERTIARY = hex("#FBBC05"); // Amarelo/Ouro
    private static final Color LIGHT_TEXT = hex("#202124"); // texto geral (Quase preto)
    private static final Color LIGHT_BUTTON_TEXT = hex("#FFFFFF"); // texto em botões
    private static final Color LIGHT_TABLE_TEXT = hex("#202124"); // texto na JTable
    private static final Color LIGHT_TABLE_SELECTION = hex("#E8F0FE"); // seleção da JTable
    private static final Color LIGHT_FOCUS = hex("#1A73E8"); // borda de foco
    private static final Color LIGHT_PROGRESSBAR = hex("#1A73E8"); // azul Google (barra de progresso)
    
    // Cores modo ESCURO -------------------------------------------------------
    private static final Color DARK_BACKGROUND = hex("#000000"); // Fundo Geral (Azul Escuro Profundo)
    private static final Color DARK_PANEL = hex("#131314"); // Painéis/Cards (Azul Escuro Ligeiramente Mais Claro)
    private static final Color DARK_PRIMARY = hex("#8AB4F8"); // Azul claro principal
    private static final Color DARK_SECONDARY = hex("#81C995"); // Verde suave
    private static final Color DARK_TERTIARY = hex("#FCD668"); // Amarelo suave
    private static final Color DARK_TEXT = hex("#E8EAED"); // texto geral (branco suave)
    private static final Color DARK_BUTTON_TEXT = hex("#171B26"); // texto em botões (Escuro, para contraste com o botão claro)
    private static final Color DARK_TABLE_TEXT = hex("#E8EAED");
    private static final Color DARK_TABLE_SELECTION = hex("#3A445C");
    private static final Color DARK_FOCUS = hex("#8AB4F8");
    private static final Color DARK_PROGRESSBAR = hex("#8AB4F8"); // azul claro (barra de progresso)



    
    // Getters e Setters -------------------------------------------------------
    public static Theme getTheme() { return temaAtual; }
    public static void setTheme(Theme theme) { temaAtual = theme; saveTheme(theme); }
    public static Color getBackgroundColor() { return temaAtual == Theme.LIGHT ? LIGHT_BACKGROUND : DARK_BACKGROUND; }
    public static Color getPanelColor() { return temaAtual == Theme.LIGHT ? LIGHT_PANEL : DARK_PANEL; }
    public static Color getPrimaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_PRIMARY : DARK_PRIMARY; }
    public static Color getSecondaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_SECONDARY : DARK_SECONDARY; }
    public static Color getTertiaryColor() { return temaAtual == Theme.LIGHT ? LIGHT_TERTIARY : DARK_TERTIARY; }
    public static Color getTextColor() { return temaAtual == Theme.LIGHT ? LIGHT_TEXT : DARK_TEXT; }
    public static Color getButtonTextColor() {
return temaAtual == Theme.LIGHT ? LIGHT_BUTTON_TEXT : DARK_BUTTON_TEXT;
}
    public static Color getTableTextColor() { return temaAtual == Theme.LIGHT ? LIGHT_TABLE_TEXT : DARK_TABLE_TEXT; }
    public static Color getTableSelectionColor() { return temaAtual == Theme.LIGHT ? LIGHT_TABLE_SELECTION : DARK_TABLE_SELECTION; }
    public static Color getFocusBorderColor() { return temaAtual == Theme.LIGHT ? LIGHT_FOCUS : DARK_FOCUS; }
    public static Color getProgressBarColor() { return temaAtual == Theme.LIGHT ? LIGHT_PROGRESSBAR : DARK_PROGRESSBAR; }
   
    // Conversão de hex string para color
    private static Color hex(String hex) {
        return Color.decode(hex);
    }
    
    // Toggle de tema (útil para botões de alternância)
    public static void toggleTheme() {
        setTheme(temaAtual == Theme.LIGHT ? Theme.DARK : Theme.LIGHT);
    }
    
    // Percistencia! Registrar a escolha anterior ----------------------------------------
    private static void saveTheme(Theme theme) {
        prefs.put(PREF_KEY, theme.name());
    }
    
    public static Theme loadSavedTheme() {
        String v = prefs.get(PREF_KEY, Theme.LIGHT.name());
        try {
            return Theme.valueOf(v);
        } catch (Exception e) {
            return Theme.LIGHT;
        }
    }
    
    // Aplicação do tema em componentes Swing
    public static void applyTheme(Window window) {
        if (window == null) return;

        // Todo o trabalho de UI DEVE ocorrer dentro do invokeLater.
        SwingUtilities.invokeLater(() -> {

            // 1. Aplica a cor de Fundo Geral (BACKGROUND) ao Content Pane do JFrame.
            if (window instanceof javax.swing.JFrame frame) {
                frame.getContentPane().setBackground(getBackgroundColor());
            } else {
                // Aplica o background a outras janelas (JDialog, etc.)
                window.setBackground(getBackgroundColor());
            }

            // 2. Aplica o tema recursivamente (a lógica do JPanel agora IGNORA o Content Pane)
            applyToComponentHierarchy(window);

            // 3. Força a atualização da interface
            window.revalidate();
            window.repaint();
        });
    }
    
    private static void applyToComponentHierarchy(Component comp) {
        applyToSingleComponent(comp);
        
        if (comp instanceof java.awt.Container cont) {
            for (Component child : cont.getComponents()) {
                applyToComponentHierarchy(child);
            }
        }
    }
    
    private static void applyToSingleComponent(Component c) {
        if (c instanceof JPanel p) {
        // A SOLUÇÃO: Ignorar o Content Pane para que ele mantenha a cor de Fundo Geral (BACKGROUND)
            if (p.getParent() instanceof javax.swing.JRootPane) {
                return; // Sai daqui. O Content Pane já foi tratado em applyTheme.
            }

            // 1. Define como opaco para garantir que o fundo seja pintado
            p.setOpaque(true); 

            // 2. Aplica a cor de CARD/PANEL a TODOS os outros painéis internos
            p.setBackground(getPanelColor());
            p.setForeground(getTextColor());
        }
        
        if (c instanceof JLabel lbl) {
            lbl.setForeground(getTextColor());
        }
        
        if (c instanceof JButton btn) {
            btn.setBackground(getPrimaryColor());
            btn.setForeground(getButtonTextColor());
            btn.setFocusPainted(false);
            btn.setFont(btn.getFont().deriveFont(Font.PLAIN));
        }
        
        if (c instanceof JToggleButton tbtn) {
            tbtn.setBackground(getPanelColor());
            tbtn.setForeground(getTextColor());
        }
        
        if (c instanceof javax.swing.JComboBox<?> combo) {
            combo.setBackground(getPanelColor());
            combo.setForeground(getTextColor());
            try {
                javax.swing.ListCellRenderer<?> renderer = combo.getRenderer();
                if (renderer instanceof javax.swing.JLabel) {
                    ((javax.swing.JLabel) renderer).setForeground(getTextColor());
                }
            } catch (Exception ignored) {}
        }
        
        if (c instanceof JTable table) {
            table.setBackground(getPanelColor());
            table.setForeground(getTableTextColor());
            table.setSelectionBackground(getTableSelectionColor());
            table.setSelectionForeground(getButtonTextColor());
            table.getTableHeader().setBackground(getPrimaryColor());
            table.getTableHeader().setForeground(getButtonTextColor());
            table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
        }
        
        if (c instanceof JScrollPane sp) {
            sp.getViewport().setBackground(getPanelColor());
        }
        
        if (c instanceof JComponent jc) {
            jc.putClientProperty("JComponent.focusedBackground", getFocusBorderColor());
        }
        
        if (c instanceof JProgressBar progressBar) {
            progressBar.setForeground(getProgressBarColor());
            progressBar.setBackground(getPanelColor());
        }
        
        if (!(c instanceof JLabel) && !(c instanceof JButton) && !(c instanceof JTable) && !(c instanceof JPanel)) {
            try {
                c.setForeground(getTextColor());
            } catch (Exception ignored) {
                
            }
        }
        
        if (c instanceof javax.swing.JTextField txt) {
            txt.setBackground(getPanelColor());
            txt.setForeground(getTextColor());
            txt.setCaretColor(getTextColor());

            // Essencial para placeholders VOLTAREM
            txt.repaint();
        }
        
    }
    
    // Registra a ultima escolha do usuario
    public static void addRememberOnClose(Window window) {
        if (window == null) return;
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveTheme(temaAtual);
            }
        });
    }
    
    public static void toggleAndApply(Window window) {
        toggleTheme();
        applyTheme(window);
    }
    
    // Metodos para padronização de telas
    public static void setMinimumSize(Window window) {
        if (window instanceof JFrame frame) {
            frame.setMinimumSize(new Dimension(DEFAULT_MIN_WIDTH, DEFAULT_MIN_HEIGHT));
        }
    }
    
    public static void setMinimumSize(Window window, int width, int height) {
        if (window instanceof JFrame frame) {
            frame.setMinimumSize(new Dimension(width, height));
        }
    }
    
    public static void setPreferredSize(Window window) {
        if (window instanceof JFrame frame) {
            frame.setPreferredSize(new Dimension(DEFAULT_PREF_WIDTH, DEFAULT_PREF_HEIGHT));
            frame.pack();
        }
    }
    
    public static void setPreferredSize(Window window, int width, int height) {
        if (window instanceof JFrame frame) {
            frame.setPreferredSize(new Dimension(width, height));
            frame.pack();
        }
    }
    
    public static void setupWindow(Window window) {
        if (window instanceof JFrame frame) {
            // Define tamanho mínimo
            frame.setMinimumSize(new Dimension(DEFAULT_MIN_WIDTH, DEFAULT_MIN_HEIGHT));
            
            // Define tamanho inicial
            frame.setSize(DEFAULT_PREF_WIDTH, DEFAULT_PREF_HEIGHT);
            
            // Centraliza na tela
            frame.setLocationRelativeTo(null);
            
            // Permite que a janela seja redimensionada
            frame.setResizable(true);
        }
    }
    
    public static void setupWindow(Window window, int minWidth, int minHeight, int prefWidth, int prefHeight) {
        if (window instanceof JFrame frame) {
            frame.setMinimumSize(new Dimension(minWidth, minHeight));
            frame.setSize(prefWidth, prefHeight);
            frame.setLocationRelativeTo(null);
            frame.setResizable(true);
        }
    }
    
    public static void applyThemeAndSetup(Window window) {
        setupWindow(window);
        applyTheme(window);
        addRememberOnClose(window);
    }
    
    public static void applyThemeAndSetup(Window window, int minWidth, int minHeight, int prefWidth, int prefHeight) {
        setupWindow(window, minWidth, minHeight, prefWidth, prefHeight);
        applyTheme(window);
        addRememberOnClose(window);
    }
}
