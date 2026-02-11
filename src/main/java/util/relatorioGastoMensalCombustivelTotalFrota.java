package util;

/**
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Movimento;
import util.ArquivoTXT_Movimento;
import util.GerarRelatorios;


public class relatorioGastoMensalCombustivelTotalFrota extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra por mês e formata os dados//
        ArrayList<String[]> resultado = new ArrayList<>();
        double totalGeralCusto = 0.0;
        

        for (Movimento m : ArquivoTXT_Movimento.lerArquivo()) {
            String desc = m.getDescricao().toLowerCase();
            
            if (m.getData().endsWith(filtro) &&  //condição de data e palavras relacionadas ao combustivel
                (desc.contains("combust") || desc.contains("gasolina") || 
                 desc.contains("diesel") || desc.contains("etanol") || 
                 desc.contains("abastec"))) {
                
                double valorCusto = m.getValor();
                
                resultado.add(new String[]{
                    String.valueOf(m.getIdVeiculo()), 
                    m.getData(),
                    "R$ " + String.format("%.2f", valorCusto) 
                });
                
                totalGeralCusto += valorCusto;
            }
        }
    
        if (!resultado.isEmpty()) {

            resultado.add(new String[]{"---", "---", "---"});

            resultado.add(new String[]{"", "TOTAL GERAL DA FROTA NO MÊS:", "R$ " + String.format("%.2f", totalGeralCusto)});
        }
        
        return resultado;
    }
}