package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import model.Movimento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArquivoExcel_Movimento {
    public static void Transf_Excel(ArrayList<Movimento> Lista, String Caminho) {
        try(Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Movimento");
            Caminho = "Movimento.xlsx";
            
            Row header = sheet.createRow(0);
            
            header.createCell(0).setCellValue("ID da Movimentação");
            header.createCell(1).setCellValue("ID do Veículo");
            header.createCell(2).setCellValue("Tipo de Despesa");
            header.createCell(3).setCellValue("Descrição");
            header.createCell(4).setCellValue("Data do Registro");
            header.createCell(5).setCellValue("Valor de Custo");
            
            int NumLinha = 1;
            
            for(Movimento movimento : Lista) {
                Row row = sheet.createRow(NumLinha++);
                
                row.createCell(0).setCellValue(movimento.getIdMovimento());
                row.createCell(1).setCellValue(movimento.getIdVeiculo());
                row.createCell(2).setCellValue(movimento.getIdTipoDespesa());
                row.createCell(3).setCellValue(movimento.getDescricao());
                row.createCell(4).setCellValue(movimento.getData());
                row.createCell(5).setCellValue(movimento.getValor());
            }
            
            for (int i = 0; i < 6; i++) {
                sheet.autoSizeColumn(i);
            }
            
            try (FileOutputStream fos = new FileOutputStream(Caminho)) {
                wb.write(fos);
                fos.flush();
            }
            
            JOptionPane.showMessageDialog(null,
                "Movimento.xlsx: Exportação em Xlsx realizada com sucesso!",
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
    
    public static ArrayList<Movimento> lerExcel(String Caminho) {
        ArrayList<Movimento> Lista = new ArrayList();
        
        try(FileInputStream fis = new FileInputStream(Caminho)) {
            Workbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheetAt(0);
            int Linhas = sheet.getPhysicalNumberOfRows();
            
            for (int i = 1; i < Linhas; i++) {
                Row row = sheet.getRow(i);
                
                int idMovimento = (int) row.getCell(0).getNumericCellValue();
                int idVeiculo = (int) row.getCell(1).getNumericCellValue();
                int idTipoDespesa = (int) row.getCell(2).getNumericCellValue();
                String descricao = row.getCell(3).getStringCellValue();
                String dataText = row.getCell(4).getStringCellValue();
                double valor = row.getCell(5).getNumericCellValue();
                
                Movimento movimento = new Movimento(idMovimento, idVeiculo, idTipoDespesa, valor, descricao, dataText);
                Lista.add(movimento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        
        return Lista;
    }
}
