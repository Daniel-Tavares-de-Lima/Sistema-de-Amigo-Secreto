package Main.Classes;

import java.util.ArrayList;

public class Grupos {

    private String nomeGrupo;
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Grupos(){

    }

    public Grupos(String nome){
        this.nomeGrupo = nome;
    }

    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> getPessoasCerta(){
        return pessoas;
    }

    public String getNomeGrupo(){
        return nomeGrupo;
    }

    public void setNomeGrupo(String nome){
        this.nomeGrupo = nome;
    }

    public String toString(){
        return this.nomeGrupo;
    }

    
}
