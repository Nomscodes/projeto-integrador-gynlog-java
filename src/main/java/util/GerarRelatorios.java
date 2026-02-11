package util;

/**
 * @author Gabriel
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; //importações//


public abstract class GerarRelatorios { //Classe mãe que modela os relatórios em formato TXT ou Excel//

    protected abstract ArrayList<String[]> buscarDados(String filtro); //método abstrato que faz as classes filhas buscarem os dados requisitados//

    public void gerarRelatorio(String titulo, String[] colunas, String filtro) { //método que gera o relatório//
        
        ArrayList<String[]> dados = buscarDados(filtro); //busca de dados

        if (dados == null || dados.isEmpty() || (dados.size() == 1 && dados.get(0).length > 0 && dados.get(0)[0].equals("---"))) { //Excessão para filtro não encontrado//
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado com o filtro: " + filtro, "Relatório Vazio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Object[] opcoes = {"Arquivo Texto (.txt)", "Planilha Excel (.xlsx)"}; //Janela que pergunta se usuário deseja relatório em arquivo TXT ou Excel//
        int escolha = JOptionPane.showOptionDialog(null,
                "Como deseja salvar o relatório: '" + titulo + "'?",
                "Exportar Relatório",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, opcoes, opcoes[0] 
        );

        if (escolha == 0) { //Escolha txt//
            gerarTxt(titulo, colunas, dados);
        } 
        else{ 
            if (escolha == 1) { //Escplha Excel//
            gerarExcel(titulo, colunas, dados);
            }
        }
    }

    private void gerarTxt(String titulo, String[] colunas, ArrayList<String[]> dados) { //cria o arquivo TXT//
        String nomeArquivo = "Relatorio_" + titulo.replace(" ", "_").replace("/", "-") + ".txt"; 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) { 
            writer.write("=== SISTEMA GYNLOG - " + titulo.toUpperCase() + " ==="); 
            writer.newLine();
            writer.write("Data de geração: " + java.time.LocalDate.now()); //data de geração do arquivo//
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------");
            writer.newLine();
            
            for (String col : colunas) {
                writer.write(String.format("%-25s", col)); //formata e escreve os títulos das colunas
            }
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------");
            writer.newLine();
            
            for (String[] linha : dados) { //escreve os dados em linha 
                for (String valor : linha) {
                    writer.write(String.format("%-25s", valor)); //formata o valor//
                }
                writer.newLine();
            }
            
            JOptionPane.showMessageDialog(null, "Relatório TXT salvo com sucesso:\n" + nomeArquivo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar TXT: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gerarExcel(String titulo, String[] colunas, ArrayList<String[]> dados) { //cria o arquivo do Excel, pela biblioteca Apache POI//
        String nomeArquivo = "Relatorio_" + titulo.replace(" ", "_").replace("/", "-") + ".xlsx"; 
        try (Workbook wb = new XSSFWorkbook()) { 
            Sheet sheet = wb.createSheet("Dados"); //cria a planilha
            
            Row header = sheet.createRow(0); //cria a linha de cabeçalho
            for (int i = 0; i < colunas.length; i++) {
                header.createCell(i).setCellValue(colunas[i]); //preenche as células do cabeçalho
            }
            
            int numLinha = 1; //prenche as linhas com os dados
            for (String[] registro : dados) { 
                Row row = sheet.createRow(numLinha++);
                for (int i = 0; i < registro.length; i++) {
                    String valor = registro[i];
                    try {
                        if (valor.contains("R$")) { //converte o valor monetário
                            double v = Double.parseDouble(valor.replace("R$", "").replace(",", ".").trim());
                            row.createCell(i).setCellValue(v);
                        } 
                        else{
                            if (i == 0 && valor.matches("\\d+")) { 
                                row.createCell(i).setCellValue(Integer.parseInt(valor));
                                } 
                                else {
                                    row.createCell(i).setCellValue(valor);
                                }
                        }
                    } 
                    catch (Exception e) {
                        row.createCell(i).setCellValue(valor);
                    }
                }
            }
            
            for (int i = 0; i < colunas.length; i++) { //ajusta tamanho das colunas auto
                sheet.autoSizeColumn(i);
            }
            
            try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
                wb.write(fos);
            }
            
            JOptionPane.showMessageDialog(null, "Planilha Excel gerada com sucesso:\n" + nomeArquivo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar Excel: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}


