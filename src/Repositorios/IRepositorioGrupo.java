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
            boolean grupoAdd = grupoJaAdicionado(grupos, g);

            if(!grupoAdd){
                grupos.add(g);
            }else{
                //---EXCPETION
                System.out.println("Grupo ja existente!");
            }
            
        }
    }

    public static boolean grupoJaAdicionado(ArrayList<Grupos> grupos, Grupos g){
        String p = g.toString();
        Grupos grupoProcurado = new Grupos(p);
        return grupos.contains(grupoProcurado);
    }

    //--METODO PARA RETORNA O ARRAYLIST
    public ArrayList<Grupos> getGrupos(){
        return grupos;
    }
}
