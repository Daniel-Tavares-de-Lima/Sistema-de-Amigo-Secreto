package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Main.Classes.Presentes;

public class IRepositorioPresente {
    
    private ArrayList<Presentes> presentes;
    

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

    
}
