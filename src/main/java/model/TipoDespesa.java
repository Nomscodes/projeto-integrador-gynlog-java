package model;

public class TipoDespesa {
    private int idTipoDespesa;
    private String descricao;
    
    public TipoDespesa(int idTipoDespesa, String descricao) {
        this.idTipoDespesa = idTipoDespesa;
        this.descricao = descricao;
    }
    
    public int getIdTipoDespesa() { return idTipoDespesa; }
    public void setIdTipoDespesa(int idTipoDespesa) { this.idTipoDespesa = idTipoDespesa; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
}