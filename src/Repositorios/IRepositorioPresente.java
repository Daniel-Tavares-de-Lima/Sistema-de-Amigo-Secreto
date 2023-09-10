package Repositorios;

import java.util.ArrayList;
import Main.Classes.Presentes;

public class IRepositorioPresente {
    
    private ArrayList<Presentes> presentes;
    
    private ArrayList<Presentes> presentesEscolhidos = new ArrayList<>();
    
    public IRepositorioPresente(){
        presentes = new ArrayList<Presentes>();
    }

    //--METODO PARA ADICIONAR PRESENTES 
    public void addPresentes(Presentes p){
        if(p != null){
            presentes.add(p);
        }
    }

    //---METODO PARA RETORNAR TODO O ARRAYLIST
    public ArrayList<Presentes> getPresentes(){
        return presentes;
    }

    //----METODO PARA ADICIONAR PRESENTES A UMA PESSOA
    public void addPresentesEscolhidos(Presentes p){
        if(p != null){
            presentesEscolhidos.add(p);
        }
    }

    public ArrayList<Presentes> getPresentesEscolhidos(){
        return presentesEscolhidos;
    }

    
}
