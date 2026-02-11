package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Movimento;
import model.TipoDespesa;

public class ArquivoTXT_Despesa {
    private static final String arquivamento = "Despesas.txt";
    private static final String separador = " | ";

    // Metodo sincroniza com movimento.txt
    public static void sincronizarComMovimento() {
        try {
            // Lê todos os movimentos
            ArrayList<Movimento> movimentos = util.ArquivoTXT_Movimento.lerArquivo();
            
            // Usa LinkedHashMap para manter ordem e evitar duplicatas
            Map<Integer, String> tiposDespesa = new LinkedHashMap<>();
            
            // Extrai ID Tipo Despesa e Descrição de cada movimento
            for (Movimento m : movimentos) {
                tiposDespesa.put(m.getIdTipoDespesa(), m.getDescricao());
            }
            
            // Escreve o arquivo Despesas.txt
            File arquivo = new File(arquivamento);
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivamento, false))) {
                
                // Escreve cabeçalho
                writer.write("ID Tipo Despesa | Descrição");
                writer.newLine();
                
                // Escreve cada tipo de despesa único
                for (Map.Entry<Integer, String> entry : tiposDespesa.entrySet()) {
                    StringBuilder Linha = new StringBuilder();
                    Linha.append(entry.getKey()).append(separador);
                    Linha.append(entry.getValue());
                    
                    writer.write(Linha.toString());
                    writer.newLine();
                }
                
                writer.flush();
            }
            
            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null,
                "Despesas.txt: Exportação em Txt realizada com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao sincronizar Despesas.txt: " + e.getMessage(),
                "Erro de Sincronização",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    
    public static ArrayList<TipoDespesa> lerArquivo() {
        ArrayList<TipoDespesa> Lista = new ArrayList<>();
        File arquivo = new File(arquivamento);
        
        // <<<< SINCRONIZA PRIMEIRO (se Movimento.txt existir)
        File movimentoFile = new File("Movimento.txt");
        if (movimentoFile.exists()) {
            sincronizarComMovimento();
        }
        
        if (!arquivo.exists()) {
            return Lista;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivamento))) {
            String Linha;
            boolean primeiraLinha = true;
            int numeroLinha = 0;
            
            while((Linha = br.readLine()) != null) {
                numeroLinha++;
                Linha = Linha.trim();
                
                if (Linha.isEmpty()) {
                    continue;
                }
                
                if (primeiraLinha) {
                    primeiraLinha = false;
                    if (Linha.startsWith("ID") || Linha.contains("Tipo")) {
                        continue;
                    }
                }
                
                String[] Partes = Linha.split("\\s*\\|\\s*");
                
                if (Partes.length < 2) {
                    System.err.println("Linha " + numeroLinha + " inválida no Despesas.txt: " + Linha);
                    continue;
                }
                
                try {
                    int TpDesp = Integer.parseInt(Partes[0]);
                    String Desc = Partes[1];
                    TipoDespesa despesa = new TipoDespesa(TpDesp, Desc);
                    Lista.add(despesa);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao processar linha " + numeroLinha + ": " + Linha);
                    System.err.println("  Detalhes: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro na leitura do arquivo Despesas.txt: " + e.getMessage(),
                "Erro de Leitura",
                JOptionPane.ERROR_MESSAGE
            );
        }
        
        return Lista;
    }
    
    // metodo em desuso (mantido por compatibilidade)
    @Deprecated
    public static void salvarLinha(TipoDespesa despesa) {
        // Este método não é mais usado
    }
}
