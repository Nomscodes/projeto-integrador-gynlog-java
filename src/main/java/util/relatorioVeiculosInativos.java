/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Veiculo;
import util.ArquivoTXT_Veiculo; 
import util.GerarRelatorios;


public class relatorioVeiculosInativos extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra os veiculos por inativos e formata os dados//
        ArrayList<String[]> resultado = new ArrayList<>();
        
        for (Veiculo v : ArquivoTXT_Veiculo.LerArquivo()) {
            
            if (!v.isStatus()) {
                
                resultado.add(new String[]{
                    String.valueOf(v.getIdVeiculo()), 
                    v.getPlaca(),
                    v.getMarca(),
                    v.getModelo(),
                    String.valueOf(v.getanoFabricacao()),
                    v.getStatusTextual() 
                });
            }
        }
        
        return resultado;
    }
}