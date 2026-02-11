package util;

/**
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Movimento;
import util.ArquivoTXT_Movimento;
import util.GerarRelatorios;

public class relatorioIPVATotalAnualFrota extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra por ano e formata os dados//
        ArrayList<String[]> resultado = new ArrayList<>();
        double totalGeralIPVA = 0.0;
        
        for (Movimento m : ArquivoTXT_Movimento.lerArquivo()) {
            String desc = m.getDescricao().toLowerCase();
            String data = m.getData();
            
            if (data.endsWith(filtro) && desc.contains("ipva")) { //condição para ano e ipva
                
                double valor = m.getValor();
                
                resultado.add(new String[]{
                    String.valueOf(m.getIdVeiculo()), 
                    "R$ " + String.format("%.2f", valor) 
                });
                
                totalGeralIPVA += valor;
            }
        }
        
        if (!resultado.isEmpty()) {
            
            resultado.add(new String[]{"---", "---"});
          
            resultado.add(new String[]{"TOTAL GERAL DE IPVA DA FROTA NO ANO:", "R$ " + String.format("%.2f", totalGeralIPVA)});
        }
        
        return resultado;
    }
}