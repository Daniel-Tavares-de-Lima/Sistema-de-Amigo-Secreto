package Main.Classes;


public class Pessoa{
    
    private String nome;
    private String apelido;
    private String senha;
    private int idPresente;

    public Pessoa(){
       
    }
    public Pessoa(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }

    public Pessoa(String apelido){
        this.apelido = apelido;
        
    }
    
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

    public int getIdPresente(){
        return idPresente;
    }
    public void setIdPresente(int idPresente){
        this.idPresente = idPresente;
    }

    public String toString(){
        return this.nome;
    }


}
