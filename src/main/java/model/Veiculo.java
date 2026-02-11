package model;

public class Veiculo { //Classe que modela e armazena infos do objeto veículo//

    private String placa, marca, modelo; //variáveis dados pelo enuciado//
    private int anoFabricacao, idVeiculo;
    private Boolean Status;

    public Veiculo(int idVeiculo, String placa, String marca, String modelo, int anoFabricacao, boolean Status){ //construtor que inicializa os atributos do objeto veiculo//
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.Status = Status;
    }
    
    // Getters e Setters para acessso dos atributos privados(encapsulamento)// -------------------------------------------------------
    public int getIdVeiculo(){ return idVeiculo;} // ID Veiculo ----------------
    public void setIdVeiculo(int idVeiculo){ this.idVeiculo = idVeiculo; }
    
    public String getMarca(){ return marca; } // Marca -------------------------
    public void setMarca(String marca){ this.marca = marca; }
    
    public String getModelo(){ return modelo; } // Modelo ----------------------
    public void setModelo(String modelo){ this.modelo = modelo; }
    
    public String getPlaca(){ return placa; } // Placa -------------------------
    public void setPlaca(String placa){ this.placa = placa; }
    
    public int getanoFabricacao(){ return anoFabricacao; } // Ano Fabricado ----
    public void setanoFabricacao(int anoFabricacao){ this.anoFabricacao = anoFabricacao; }
    
    public boolean isStatus(){ return Status; } // Disponibilidade -------------
    public void setAtivo(boolean status){ this.Status = status; }
    
    public String getStatusTextual() { // Versão Textual da Disponibilidade ----
        return Status ? "Disponível" : "Indisponível";
    }
}