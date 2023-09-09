package Repositorios;

import java.util.ArrayList;

import Main.Classes.Grupos;
import javafx.scene.control.Alert;

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
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("GRUPO EXISTENTE");
                alertSalvaPessoa.setContentText("Nome do grupo já existe, por favor digite outro.");
                alertSalvaPessoa.show();
                /*------ */
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
