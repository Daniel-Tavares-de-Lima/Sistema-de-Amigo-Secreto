package Main.Classes;

import java.util.ArrayList;
import java.util.List;

public class Sorteio {

    private List<Pessoa> pessoasAmigoSecreto;

    public Sorteio(){

    }

    public Sorteio(List<Pessoa> pessoasAmigoSecreto){
        this.pessoasAmigoSecreto = pessoasAmigoSecreto;
    }

     public List<Pessoa> obterListaDePessoas(){
        return pessoasAmigoSecreto;
    }
}
