package Main.Classes;

public class Presentes {
    
    private String categoria;
    private String descricao;
    private float preco;

    public Presentes(){

    }

    public Presentes(String nomePresente){
        this.categoria = nomePresente;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String nome){
        this.categoria = nome;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public float getPreco(){
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }

    public String toString(){
        return this.categoria;
    }
}
