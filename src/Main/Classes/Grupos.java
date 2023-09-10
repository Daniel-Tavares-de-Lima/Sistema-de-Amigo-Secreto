package Main.Classes;

import java.util.ArrayList;


public class Grupos {

    private String nomeGrupo;
    private ArrayList<Pessoa> pessoas = new ArrayList<>();


    public Grupos(){

    }

    
     //---VERIFICA SE HOUVE SORTEIO
    private boolean realizadoSorteio;

    public boolean foiRealizadoSorteio(){
        return realizadoSorteio;
    }

    public void setRealizadoSorteio(boolean realizadoSorteio){
        this.realizadoSorteio = realizadoSorteio;
    }

    /*------- */

    public Grupos(String nome){
        this.nomeGrupo = nome;
    }

    /*---METODO QUE ADICIONA E REMOVE PESSOAS EM GRUPOS */
    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public void removerPessoa(Pessoa pessoa){
        pessoas.remove(pessoa);
    }

    public ArrayList<Pessoa> getPessoasCerta(){
        return pessoas;
    }

    /*------------ */


    public String getNomeGrupo(){
        return nomeGrupo;
    }

    public void setNomeGrupo(String nome){
        this.nomeGrupo = nome;
    }

    public String toString(){
        return this.nomeGrupo;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Grupos grupo = (Grupos) o;
        return nomeGrupo.equals(grupo.nomeGrupo);
    } 

    @Override
    public int hashCode(){
        return nomeGrupo.hashCode();
    }

    
}
