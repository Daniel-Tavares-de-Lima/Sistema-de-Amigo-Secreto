package Repositorios;

import java.util.ArrayList;


import Main.Classes.Pessoa;
import javafx.scene.control.Alert;

public class IRepositorioPessoa{
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Pessoa> apelidos;
    private ArrayList<Pessoa> senhas;
    
    private boolean addPessoaFalhou = false;

    private ArrayList<Pessoa> pessoasEscolhidas = new ArrayList<>();

    

    public IRepositorioPessoa(){
        pessoas = new ArrayList<Pessoa>();
        apelidos = new ArrayList<Pessoa>();
        senhas = new ArrayList<Pessoa>();
    }

    
    // --METODO PARA ADICIONAR PESSOAS AO ARRAYLIST
    public void addPessoa(Pessoa p){
        if(p != null && !apelidos.contains(p)){
            pessoas.add(p);
            apelidos.add(p);
            senhas.add(p);
        }else{
            if(!addPessoaFalhou){
                addPessoaFalhou = true;
            }
            
        }
    }

   


    /*-----METODO PARA ADICIONAR PESSOAS ESCOLHIDAS AO GRUPO */
    public void addPessoasEscolhidas(Pessoa p){
        if(p != null){
            pessoasEscolhidas.add(p);
        }
    }

   
    //---METODO PARA RETORNAR TODO O ARRAYLIST DE PESSOAS
    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST DE APELIDOS
    public ArrayList<Pessoa> getApelidos(){
        return apelidos;
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST DE SENHAS
    public ArrayList<Pessoa> getSenha(){
        return senhas;
    }

    /*-------METODO PARA RETORNAR TODAS AS PESSOAS ESCOLHIDAS DO GRUPO */
    public ArrayList<Pessoa> getPessoasEscolhidas(){
        return pessoasEscolhidas;
    }

    public boolean foiAddPessoaFalhou(){
        return addPessoaFalhou;
    }

    public void reseteAddPessoaFalhou(){
        addPessoaFalhou = false;
    }
    

    

    

}
