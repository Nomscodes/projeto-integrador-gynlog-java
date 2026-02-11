    package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import model.Veiculo;

public class ArquivoTXT_Veiculo {
    private static final String arquivamento = "Veiculo.txt";
    private static final String separador = " | ";
    
    public static void salvarLinha(Veiculo veiculo) {
        try {
            File arquivo = new File(arquivamento);
            boolean arquivoVazio = !arquivo.exists() || arquivo.length() == 0;
           
            // Verificando se o arquivo termina com quebra de linha ----------------------
            if (!arquivoVazio && arquivo.length() > 0) {
                try (RandomAccessFile raf = new RandomAccessFile(arquivo, "r")) {
                    if (raf.length() > 0) {
                        raf.seek(raf.length() - 1);
                        // Se o ultimo elemento não for uma quebra de linha, então vai quebrar ----
                        byte ultimoByte = raf.readByte();
                        if(ultimoByte != '\n' && ultimoByte != '\r') {
                            try (FileWriter fw = new FileWriter(arquivo, true)) {
                                fw.write(System.lineSeparator());
                            }
                        }
                    }
                }
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivamento, true))) {
                
                // Verificação se o arquivo está vazio -----------------------
                if (arquivoVazio || arquivo.length() == 0) {
                    writer.write("ID do Veículo | Placa | Marca | Modelo | Ano | Disponibilidade");
                    writer.newLine();
                }
                
                // Monta a linha no registro ---------------------------------
                StringBuilder linha = new StringBuilder();
                linha.append(veiculo.getIdVeiculo()).append(separador);
                linha.append(veiculo.getPlaca()).append(separador);
                linha.append(veiculo.getMarca()).append(separador);
                linha.append(veiculo.getModelo()).append(separador);
                linha.append(veiculo.getanoFabricacao()).append(separador);
                linha.append(veiculo.getStatusTextual());
                
                writer.write(linha.toString());
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao salvar no arquivo TXT: " + e.getMessage(),
                    "Erro de Gravação", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static int gerarProximoId() {
        ArrayList<Veiculo> Lista = LerArquivo();
        if (Lista.isEmpty()) {
            return 100000;
        }
        
        // Define o ID inicial do sistema
        int idInicial = 100000;

        HashSet<Integer> idsExistentes = new HashSet<>();
        int maiorId = idInicial;
        
        for (Veiculo veiculo : Lista) {
            int id = veiculo.getIdVeiculo();
            idsExistentes.add(id);
            if (id > maiorId) {
                maiorId = id;
            }
        }
        
        // Buscando por ids vagos na sequencia
        for (int i = idInicial; i <= maiorId; i++) {
            if (!idsExistentes.contains(i)) {
                // Encontrou um ID vago!
                return i;
            }
        }

        
        return maiorId + 1;
    }
    
    // Verificação de duplicação de Placas registradas ----------------------------------------------------------------------------
    public static boolean placaJaExiste(String placa) {
        ArrayList<Veiculo> lista = LerArquivo();
        for (Veiculo v : lista) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<Veiculo> LerArquivo() {
        ArrayList<Veiculo> Lista = new ArrayList<>();
        File arquivo = new File(arquivamento);
        
        // Se o arquivo não existe, retorna lista vazia ---------------------
        if (!arquivo.exists()) {
            return Lista;
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(arquivamento))) {
            String Linha;
            boolean primeiraLinha = true;
            
            while((Linha = br.readLine()) != null) {
                Linha = Linha.trim();
                
                // Pulando linhas vazias ------------------------------------
                if (Linha.isEmpty()) {
                    continue;
                }
                
                // Pulando cabeçalho (a primeira linha) ---------------------
                if (primeiraLinha) {
                    primeiraLinha = false;
                    // verificação se é realmente o cabeçalho
                    if (Linha.startsWith("ID") || Linha.startsWith("id")) {
                        continue;
                    }
                }
                // Split usando regex ---------------------------------------
                String[] Partes = Linha.split("\\s*\\|\\s*");
                
                // Validação de formato -------------------------------------
                if (Partes.length < 6) {
                    System.err.println("Linha inválida ignorada: " + Linha);
                    continue;
                }
                
                try {
                    int idVEICULO = Integer.parseInt(Partes[0]);
                    String placa = Partes[1];
                    String marca = Partes[2];
                    String modelo = Partes[3];
                    int anoFABRICADO = Integer.parseInt(Partes[4]);
                    boolean dispon = Partes[5].equalsIgnoreCase("Disponível") || Partes[5].equalsIgnoreCase("Disponivel");
                    Veiculo veiculo = new Veiculo(idVEICULO, placa, marca, modelo, anoFABRICADO, dispon);
                    Lista.add(veiculo);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao processar linha: " + Linha);
                    System.err.println("  Detalhes: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao ler arquivo: " + e.getMessage(),
                "Erro de Leitura",
                JOptionPane.ERROR_MESSAGE
            );
        }
        return Lista;
    }
    
    public static void AtualizarTxtExcel(ArrayList<Veiculo> Lista){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivamento, false))) {
            
            // Escrevendo cabeçalho TESTE
            writer.write("ID do Veículo | Placa | Marca | Modelo | Ano | Disponibilidade");
            writer.newLine();
            
            // Escrevendo cada registro -------------------------------------
            for(Veiculo veiculo : Lista){
                StringBuilder Linha = new StringBuilder();
                Linha.append(veiculo.getIdVeiculo()).append(separador);
                Linha.append(veiculo.getPlaca()).append(separador);
                Linha.append(veiculo.getMarca()).append(separador);
                Linha.append(veiculo.getModelo()).append(separador);
                Linha.append(veiculo.getanoFabricacao()).append(separador);
                Linha.append(veiculo.getStatusTextual());
                
                writer.write(Linha.toString());
                writer.newLine();
            }
            
            writer.flush();
            
            JOptionPane.showMessageDialog(null, 
                "Arquivo TXT atualizado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, 
                "Erro na atualização do arquivo TXT: " + e.getMessage(),
                "Erro de Gravação",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
