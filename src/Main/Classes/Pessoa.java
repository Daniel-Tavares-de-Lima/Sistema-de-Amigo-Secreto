package Main.Classes;


public class Pessoa{
    
    String nome;
    String apelido;

    int id;

    private String senha;

    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
        
    }
    
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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String toString(){
        return this.nome;
    }


}
