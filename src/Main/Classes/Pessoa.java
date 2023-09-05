package Main.Classes;


public class Pessoa{
    
    private String nome;
    private String apelido;
    private String senha;

    public Pessoa(){
        
    }
    public Pessoa(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
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


}
