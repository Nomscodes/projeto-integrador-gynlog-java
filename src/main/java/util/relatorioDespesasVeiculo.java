package util;

/**
 *
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Movimento;
import model.TipoDespesa;
import util.ArquivoTXT_Movimento; 
import util.ArquivoTXT_Despesa; 
import util.GerarRelatorios; 


public class relatorioDespesasVeiculo extends GerarRelatorios { 
    
    private String buscarDescricaoDespesa(int idTipoDespesa, ArrayList<TipoDespesa> listaDespesas) { //procura pela despesa 
        for (TipoDespesa td : listaDespesas) {
            if (td.getIdTipoDespesa() == idTipoDespesa) {
                return td.getDescricao();
            }
        }
        return "Desconhecido"; 
    }
    
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra veiculo por ID//
        
        ArrayList<String[]> dadosFiltrados = new ArrayList<>();
        int idVeiculoDesejado;
        
        try {
            idVeiculoDesejado = Integer.parseInt(filtro.trim()); 
        } 
        catch (NumberFormatException e) {
            System.err.println("Erro: O filtro não é um ID de veículo válido (deve ser um número).");
            System.out.println("Filtro recebido: " + filtro); 
            return dadosFiltrados; 
        }
        
        ArrayList<Movimento> listaMovimentos = ArquivoTXT_Movimento.lerArquivo(); //lê e cria uma lista de despesas
        ArrayList<TipoDespesa> listaDespesas = ArquivoTXT_Despesa.lerArquivo(); 
        
        System.out.println("Buscando Movimentos para o ID do Veículo: " + idVeiculoDesejado);

        for (Movimento mov : listaMovimentos) { //loop para pegar os dados filtrados
            
            if (mov.getIdVeiculo() == idVeiculoDesejado) { 
                
                String tipoDespesaDesc = buscarDescricaoDespesa(mov.getIdTipoDespesa(), listaDespesas); //busca da descrição escrita
                
                String valorFormatado = String.format("%.2f", mov.getValor()).replace('.', ',');
                
                String[] linha = new String[]{ //linha exibida no arquivo
                    mov.getData(),               
                    mov.getDescricao(),          
                    tipoDespesaDesc,             
                    valorFormatado               
                };
                
                dadosFiltrados.add(linha); //escreve os dados encontrados
            }
        }
        
        System.out.println(" Total de despesas encontradas: " + dadosFiltrados.size());
        return dadosFiltrados;
    }
}