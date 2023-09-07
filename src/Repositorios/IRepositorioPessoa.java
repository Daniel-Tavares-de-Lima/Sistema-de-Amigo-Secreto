package Repositorios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Main.Classes.Pessoa;

public class IRepositorioPessoa{
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Pessoa> apelidos;
    private ArrayList<Pessoa> senhas;

    private Set<Pessoa> conjuntoApelidos = new HashSet<>();

    public IRepositorioPessoa(){
        pessoas = new ArrayList<Pessoa>();
        apelidos = new ArrayList<Pessoa>();
        senhas = new ArrayList<Pessoa>();
    }

    //--METODO PARA ADICIONAR PESSOAS AO ARRAYLIST
    public void addPessoa(Pessoa p){
        if(p != null){
            pessoas.add(p);
            
            senhas.add(p);
        }
    }

    //--METODO PARA ADICIONAR APELIDOS AO ARRAYLIST
    public void addApelidos(Pessoa a){
       
        if(a != null && !conjuntoApelidos.contains(a)){
            apelidos.add(a);
            conjuntoApelidos.add(a);
        }else{
            System.out.println("Nome ja estive " + a);
        }
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST DE PESSOAS
    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST DE PESSOAS
    public ArrayList<Pessoa> getApelidos(){
        return apelidos;
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST DE PESSOAS
    public ArrayList<Pessoa> getSenha(){
        return senhas;
    }

    

}
