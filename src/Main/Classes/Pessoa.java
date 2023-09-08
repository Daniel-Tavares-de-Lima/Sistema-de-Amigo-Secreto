package Main.Classes;

import java.util.ArrayList;
import java.util.Objects;


public class Pessoa{
    
    private String nome;
    private String apelido;
    private String senha;

    

    private ArrayList<Presentes> presentes = new ArrayList<>();

    public Pessoa(){
       
    }

    public Pessoa(String nome){
        this.nome = nome;
    }


    public Pessoa(String nome, String apelido, String senha){
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
    }

    /////////////////////
   
    
    public ArrayList<Presentes> getPresenteCerto(){
        return presentes;
    }

    public void adicionarPresentes(Presentes presente){
        presentes.add(presente);
    }

    public void removerPresente(Presentes presente){
        presentes.remove(presente);
    }
    /////////////////////

  
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

     public String getApelido(){
        return apelido;
     }

    public void setApelido(String apelido){
        this.apelido = apelido;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

   
    public String toString(){
        return this.nome;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(apelido, pessoa.apelido);
    }

    @Override
    public int hashCode(){
        return Objects.hash(apelido);
    }

}
