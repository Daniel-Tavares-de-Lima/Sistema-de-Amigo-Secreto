package Repositorios;

import java.util.ArrayList;

import Main.Classes.Grupos;

public class IRepositorioGrupo {
    
    private ArrayList<Grupos> grupos;

    public IRepositorioGrupo(){
        grupos = new ArrayList<Grupos>();
    }


    //---METODO PARA ADICIONAR GRUPOS NO COMBOBOX
    public void addGrupos(Grupos g){
        if(g != null){
            grupos.add(g);
        }
    }

    //--METODO PARA RETORNA O ARRAYLIST
    public ArrayList<Grupos> getGrupos(){
        return grupos;
    }
}
