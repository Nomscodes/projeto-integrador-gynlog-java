package model;

public class Movimento extends TipoDespesa {
    private int idMovimento;
    private int idVeiculo;
    private double valor;
    private String data;
    
    public Movimento(int idMovimento, int idVeiculo, int idTipoDespesa, double valor, String descricao, String data) {
        super(idTipoDespesa, descricao);
        this.idMovimento = idMovimento;
        this.idVeiculo = idVeiculo;
        this.valor = valor;
        this.data = data;
    }
    
    // Getters e Setters
    public int getIdMovimento() { return idMovimento; }
    public void setIdMovimento(int idMovimento) { this.idMovimento = idMovimento; }
    
    public int getIdVeiculo() { return idVeiculo; }
    public void setIdVeiculo(int idVeiculo) { this.idVeiculo = idVeiculo; }
    
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    
    public int getAno() {
        if (data == null || data.isEmpty()) {
            return -1;
        }
        
        try {
            // A data está no formato dd/MM/yyyy, então o ano está após a segunda barra
            String[] partes = data.split("/");
            if (partes.length == 3) {
                return Integer.parseInt(partes[2]);
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Erro ao extrair ano da data: " + data);
        }
        
        return -1;
    }
}
