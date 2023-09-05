package Main.Classes;

public class Grupos {

    private String nomeGrupo;

    public Grupos(){

    }

    public Grupos(String nome){
        this.nomeGrupo = nome;
    }

    public String getNomeGrupo(){
        return nomeGrupo;
    }

    public void setNomeGrupo(String nome){
        this.nomeGrupo = nome;
    }

    public String toString(){
        return this.nomeGrupo;
    }


}
