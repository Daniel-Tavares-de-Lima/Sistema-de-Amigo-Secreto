package Repositorios;

import java.util.ArrayList;
import Main.Classes.Pessoa;

public class IRepositorioPessoa{
    private ArrayList<Pessoa> pessoas;

    public IRepositorioPessoa(){
        pessoas = new ArrayList<Pessoa>();
    }

    //--METODO PARA ADICIONAR PESSOAS AO COMBOBOX
    public void addPessoa(Pessoa p){
        if(p != null){
            pessoas.add(p);
        }
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST
    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    
}
