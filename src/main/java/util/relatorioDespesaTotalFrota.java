package util;

/**
 * @author Gabriel
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Movimento;
import model.Veiculo; 
import util.ArquivoTXT_Movimento;
import util.ArquivoTXT_Veiculo; 
import util.GerarRelatorios;

public class relatorioDespesaTotalFrota extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra por mês e ano e formata os dados//
        
        Map<Integer, Double> totaisPorVeiculo = new HashMap<>(); //map pra somar 
       
        Map<Integer, Veiculo> veiculosMap = new HashMap<>();
        double totalGeralFrota = 0;
        
        for (Veiculo v : ArquivoTXT_Veiculo.LerArquivo()) { //carrega os veiculos
            veiculosMap.put(v.getIdVeiculo(), v);
        }
        
        for (Movimento m : ArquivoTXT_Movimento.lerArquivo()) { //laço pra captar as movimentações
            int idVeiculo = m.getIdVeiculo();
            double valor = m.getValor();
                
            totaisPorVeiculo.put(idVeiculo, totaisPorVeiculo.getOrDefault(idVeiculo, 0.0) + valor); //soma
            totalGeralFrota += valor;
        }
        
        ArrayList<String[]> resultado = new ArrayList<>(); //lista de dados que será retornada
        
        if (!totaisPorVeiculo.isEmpty()) {
            
            for (Map.Entry<Integer, Double> entry : totaisPorVeiculo.entrySet()) {
                int idVeiculo = entry.getKey();
                double totalVeiculo = entry.getValue();
                
                Veiculo v = veiculosMap.get(idVeiculo);
       
                String placa = (v != null) ? v.getPlaca() : "ID Não Encontrado"; 
                
                resultado.add(new String[]{ //adiciona uma nova linha de dados
                    String.valueOf(idVeiculo), 
                    placa, 
                    "R$ " + String.format("%.2f", totalVeiculo)
                });
            }
            
            resultado.add(new String[]{"---", "---", "---"});
            resultado.add(new String[]{"", "TOTAL GERAL DA FROTA:", "R$ " + String.format("%.2f", totalGeralFrota)}); //imprime o resultado
        }
        
        return resultado;
    }
}