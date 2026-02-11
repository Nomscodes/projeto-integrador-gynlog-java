package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Movimento;
import model.TipoDespesa;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArquivoExcel_Despesa {
    // Sincronização com Movimento.txt
    public static void Transf_Excel(ArrayList<TipoDespesa> Lista, String Caminho) {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Despesa");
            Caminho = "Despesas.xlsx";
            
            Row header = sheet.createRow(0);
            
            header.createCell(0).setCellValue("ID da Movimentação");
            header.createCell(1).setCellValue("Descrição");
            
            ArrayList<Movimento> movimentos = util.ArquivoTXT_Movimento.lerArquivo();
            Map<Integer, String> tiposDespesa = new LinkedHashMap<>();
            
            // Extrai ID Tipo Despesa e Descrição de cada movimento
            for (Movimento m : movimentos) {
                tiposDespesa.put(m.getIdTipoDespesa(), m.getDescricao());
            }
            
            int NumLinha = 1;
            
            for (Map.Entry<Integer, String> entry : tiposDespesa.entrySet()) {
                Row row = sheet.createRow(NumLinha++);
                
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
            }
            
            for (int i = 0; i < 2; i++) {
                sheet.autoSizeColumn(i);
            }
            
            try (FileOutputStream fos = new FileOutputStream(Caminho)) {
                wb.write(fos);
                fos.flush();
            }
            
            JOptionPane.showMessageDialog(null,
                "Despesas.xlsx: Exportação em Xlsx realizada com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro na exportação em Excel: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }
    
    public static ArrayList<TipoDespesa> lerExcel(String Caminho) {
        ArrayList<TipoDespesa> Lista = new ArrayList();
        
        try(FileInputStream fis = new FileInputStream(Caminho)) {
            Workbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheetAt(0);
            int Linhas = sheet.getPhysicalNumberOfRows();
            
            for (int i = 1; i < Linhas; i++) {
                Row row = sheet.getRow(i);
                
                int idTipoDespesa = (int) row.getCell(0).getNumericCellValue();
                String descricao = row.getCell(1).getStringCellValue();
                
                TipoDespesa despesa = new TipoDespesa(idTipoDespesa, descricao);
                Lista.add(despesa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        
        return Lista;
    }
}
