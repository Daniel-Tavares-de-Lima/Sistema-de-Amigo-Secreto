package Repositorios;

import java.util.ArrayList;


import Main.Classes.Pessoa;

public class IRepositorioPessoa{
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Pessoa> apelidos;
    private ArrayList<Pessoa> senhas;

    private ArrayList<Pessoa> pessoasEscolhidas = new ArrayList<>();

    public IRepositorioPessoa(){
        pessoas = new ArrayList<Pessoa>();
        apelidos = new ArrayList<Pessoa>();
        senhas = new ArrayList<Pessoa>();
    }

    
    //--METODO PARA ADICIONAR PESSOAS AO ARRAYLIST
    public void addPessoa(Pessoa p){
        if(p != null && !apelidos.contains(p)){
            pessoas.add(p);
            apelidos.add(p);
            senhas.add(p);
        }else{
            System.out.println("APELIDO JA EXISTE");
        }
    }

    public void addPessoasEscolhidas(Pessoa p){
        if(p != null){
            
            pessoasEscolhidas.add(p);
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

    public ArrayList<Pessoa> getPessoasEscolhidas(){
        return pessoasEscolhidas;
    }


    

    

}
