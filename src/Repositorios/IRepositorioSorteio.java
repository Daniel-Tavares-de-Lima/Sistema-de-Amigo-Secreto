package Repositorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Main.Classes.Pessoa;
import javafx.scene.control.Alert;

public class IRepositorioSorteio {

    private List<Pessoa> pessoas;

    public IRepositorioSorteio() {

    }

    public IRepositorioSorteio(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    /*----METODO QUE REALIZA O SORTEIO */
    public List<String> realizarAmigoSecreto(List<Pessoa> pessoas) {

        // List<Pessoa> embaralhaPessoas = new ArrayList<>(pessoas);
        // Collections.shuffle(embaralhaPessoas);

        List<String> nomesAmigosSecretos = new ArrayList<>();

        List<Pessoa> pessoasDisponiveis = new ArrayList<>(pessoas);

        // ----Verifica se a lista de pessoas é valida para o sorteio
        if (pessoas.size() < 2) {
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("Sorteio");
            alertSalvaPessoa.setContentText("Não há pessoas suficientes no grupo para realizar o sorteio.");
            alertSalvaPessoa.show();
            /*------ */
        }

        Collections.shuffle(pessoasDisponiveis);// --EMBARALHA AS PESSOAS DISPONIVEIS
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoaAtual = pessoas.get(i);
            Pessoa amigoSecretoEscolhido = null;

            //--SE HOUVER PESSOAS DISPONIVEIS PARA O SORTEIO
            if (!pessoasDisponiveis.isEmpty()) {
                // --RODE ATE O AMIGO SECRETO NAO SER ELA MESMA
                do {
                    amigoSecretoEscolhido = pessoasDisponiveis.remove(0);
                } while (amigoSecretoEscolhido == pessoaAtual);
            }else{
                break;
            }

            nomesAmigosSecretos.add(amigoSecretoEscolhido.getNome());
            System.out.println(pessoaAtual + " tirou " + amigoSecretoEscolhido);

        }

        return nomesAmigosSecretos;

    }

    // private int escolherIndiceAleatorio(List<Integer> indicesDisponiveis, int currentIndex) {
    //     Random random = new Random();
    //     int maxIndex = indicesDisponiveis.size() - 1;

    //     if (indicesDisponiveis.size() == 1) {
    //         return 0;
    //     }

    //     int indiceSorteado;

    //     do {
    //         indiceSorteado = random.nextInt(maxIndex + 1);
    //     } while (indiceSorteado == currentIndex);

    //     return indiceSorteado;
    // }

}
