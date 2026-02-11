package util;

/**
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Movimento;
import model.TipoDespesa;
import util.ArquivoTXT_Movimento;
import util.ArquivoTXT_Despesa;
import util.GerarRelatorios;

public class relatorioTotalMultasVeiculo extends GerarRelatorios { 
  
    private int buscarIdMulta(ArrayList<TipoDespesa> listaDespesas) {
        for (TipoDespesa td : listaDespesas) {
            if (td.getDescricao().toLowerCase().contains("multa")) { 
                return td.getIdTipoDespesa();
            }
        }
        return -1; 
    }
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { 
        
        ArrayList<String[]> dadosFiltrados = new ArrayList<>();
        
        String[] partesFiltro = filtro.split("/");
        if (partesFiltro.length != 2) {
            return dadosFiltrados; 
        }
        
        int idVeiculoDesejado;
        int anoDesejado;
        
        try {
            idVeiculoDesejado = Integer.parseInt(partesFiltro[0].trim());
            anoDesejado = Integer.parseInt(partesFiltro[1].trim());
        } catch (NumberFormatException e) {
            System.err.println("Erro: O ID do veículo ou o ano não é um número válido.");
            return dadosFiltrados;
        }

        ArrayList<Movimento> listaMovimentos = ArquivoTXT_Movimento.lerArquivo();
        ArrayList<TipoDespesa> listaDespesas = ArquivoTXT_Despesa.lerArquivo();
        
        int multaId = buscarIdMulta(listaDespesas);
        
        if (multaId == -1) {
            System.err.println("Erro: Tipo de Despesa 'Multa' não encontrado em Despesas.txt");
            return dadosFiltrados;
        }
        
        for (Movimento mov : listaMovimentos) {
            
            if (mov.getIdVeiculo() == idVeiculoDesejado && 
                mov.getAno() == anoDesejado && 
                mov.getIdTipoDespesa() == multaId) 
            {
                String tipoDespesaDesc = buscarDescricaoDespesa(mov.getIdTipoDespesa(), listaDespesas);
                
                String valorFormatado = String.format("%.2f", mov.getValor()).replace('.', ',');
                
                String[] linha = new String[]{ 
                    mov.getData(),               
                    valorFormatado,              
                    mov.getDescricao()           
                };
                
                dadosFiltrados.add(linha);
            }
        }
        
        return dadosFiltrados;
    }
    
    private String buscarDescricaoDespesa(int idTipoDespesa, ArrayList<TipoDespesa> listaDespesas) {
        for (TipoDespesa td : listaDespesas) {
            if (td.getIdTipoDespesa() == idTipoDespesa) {
                return td.getDescricao();
            }
        }
        return "Desconhecido"; 
    }
}