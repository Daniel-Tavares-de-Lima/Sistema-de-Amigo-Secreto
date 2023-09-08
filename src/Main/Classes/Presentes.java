package Main.Classes;

import java.util.ArrayList;

public class Presentes {
    
    private String categoria;
    private String descricao;
    private float preco;

    private ArrayList<Presentes> listaPresentes = new ArrayList<>();

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

    public ArrayList<Presentes> getPresentes(){
        return listaPresentes;
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
