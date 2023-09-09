package Repositorios;

import java.util.ArrayList;


import Main.Classes.Pessoa;
import javafx.scene.control.Alert;

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
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("APELIDO JA EXISTE");
            alertSalvaPessoa.setContentText("O apelido digitado já existe, por favor digite outro");
            alertSalvaPessoa.show();
            /*------ */
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


    

    

}
