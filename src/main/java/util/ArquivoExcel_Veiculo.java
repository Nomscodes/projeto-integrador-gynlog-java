package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Veiculo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArquivoExcel_Veiculo {
    public static void Transf_Excel(ArrayList<Veiculo> Lista, String Caminho) {
        try(Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Veiculo");
            Caminho = ("Veiculo.xlsx");
            
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID Veículo");
            header.createCell(1).setCellValue("Placa");
            header.createCell(2).setCellValue("Marca");
            header.createCell(3).setCellValue("Modelo");
            header.createCell(4).setCellValue("Ano De Fabricacao");
            header.createCell(5).setCellValue("Disponibilidade");
            
            int NumLinha = 1;
            
            for(Veiculo veiculo : Lista) {
                Row row = sheet.createRow(NumLinha++);
                row.createCell(0).setCellValue(veiculo.getIdVeiculo());
                row.createCell(1).setCellValue(veiculo.getPlaca());
                row.createCell(2).setCellValue(veiculo.getMarca());
                row.createCell(3).setCellValue(veiculo.getModelo());
                row.createCell(4).setCellValue(veiculo.getanoFabricacao());
                row.createCell(5).setCellValue(veiculo.getStatusTextual());
            }
            
            // Argumenta o tamanho da caixinha ---------------------------------
            for (int i = 0; i < 7; i++) {
                sheet.autoSizeColumn(i);
            }
            
            // Registrando informações -----------------------------------------
            try (FileOutputStream fos = new FileOutputStream(Caminho)) {
                wb.write(fos);
            }
            
            JOptionPane.showMessageDialog(null, "Exportação em Excel realizada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na exportação em Excel: " + e.getMessage());
        }
    }
    
    public static ArrayList<Veiculo> lerExcel(String Caminho) {
        ArrayList<Veiculo> Lista = new ArrayList();
        
        try(FileInputStream fis = new FileInputStream(Caminho)) {
            Workbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheetAt(0);
            int Linhas = sheet.getPhysicalNumberOfRows();
            
            for (int i = 1; i < Linhas; i++) {
                Row row = sheet.getRow(i);
                
                int idVeiculo = (int) row.getCell(0).getNumericCellValue();
                String placa = row.getCell(1).getStringCellValue();
                String marca = row.getCell(2).getStringCellValue();
                String modelo = row.getCell(3).getStringCellValue();
                int anoFabricacao = (int) row.getCell(4).getNumericCellValue();
                String StatusTxt = row.getCell(5).getStringCellValue();
                
                boolean StatusDoVeiculo = StatusTxt.equalsIgnoreCase("Disponível") || StatusTxt.equalsIgnoreCase("Disponivel");
                
                Veiculo veiculo = new Veiculo(idVeiculo, placa, marca, modelo, anoFabricacao, StatusDoVeiculo);
                Lista.add(veiculo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
        
        return Lista;
    }
}
