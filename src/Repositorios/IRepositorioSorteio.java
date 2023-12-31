package Repositorios;

/*--------- */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import Main.Classes.Pessoa;
import javafx.scene.control.Alert;
/*-------- */

public class IRepositorioSorteio {

    private List<Pessoa> pessoas;

    public IRepositorioSorteio() {

    }

    public IRepositorioSorteio(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    /*----METODO QUE REALIZA O SORTEIO */
    public List<String> realizarAmigoSecreto(List<Pessoa> pessoas) {

        List<Pessoa> embaralhaPessoas = new ArrayList<>(pessoas);
        Collections.shuffle(embaralhaPessoas);

        List<Integer> indicesDisponiveis = new ArrayList<>();
        List<String> nomesAmigosSecretos = new ArrayList<>();

        // ----Verifica se a lista de pessoas é valida para o sorteio
        if (pessoas.size() < 2) {
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("Sorteio");
            alertSalvaPessoa.setContentText("Não há pessoas suficientes no grupo para realizar o sorteio.");
            alertSalvaPessoa.show();
            /*------ */
        } else {
           
            for (int i = 0; i < pessoas.size(); i++) {
                indicesDisponiveis.add(i);
            }

            // Collections.shuffle(indicesDisponiveis);//--EMBARALHA OS INDICES DISPONIVEIS
            for (int i = 0; i < pessoas.size(); i++) {
                Pessoa pessoaAtual = pessoas.get(i);

                // ---ESCOLHER ALEATORIAMENTE UM INDICE DE UMA PESSOA NAO SELECIONADA
                int indiceSorteado = escolherIndiceAleatorio(indicesDisponiveis, i);

                // ---GARANTIR QUE O INDICE SORTEADO NAO SEJA O MESMO INDICE ATUAL
                if (indiceSorteado == i) {
                    // --SE FOR O MESMO, TROQUE COM O ULTIMO INDICE DISPONIVEL
                    Collections.swap(indicesDisponiveis, i, indicesDisponiveis.size() - 1);
                    indiceSorteado = escolherIndiceAleatorio(indicesDisponiveis, i);
                }


                //ERRO SE O TAMANHO DA LISTA INDICES DISPONIVEIS SE TORNAR MENOR DO QUE O VALOR DE INDICE SORTEADO
                if (!indicesDisponiveis.isEmpty() && indiceSorteado < indicesDisponiveis.size()) {
                    // --OBTEM A PESSOA CORRESPONDENTE AO INDICE SORTEADO
                    Pessoa amigoSecretoEscolhido = pessoas.get(indicesDisponiveis.get(indiceSorteado));
                    nomesAmigosSecretos.add(amigoSecretoEscolhido.getNome());

                    // ---IMPEDIR QUE A PESSOA TIRE ELA MESMA
                    while (amigoSecretoEscolhido == pessoaAtual) {
                        indiceSorteado = escolherIndiceAleatorio(indicesDisponiveis, i);
                        amigoSecretoEscolhido = pessoas.get(indicesDisponiveis.get(indiceSorteado));
                        nomesAmigosSecretos.set(i, amigoSecretoEscolhido.getNome());
                        indicesDisponiveis.remove(indiceSorteado);
                    }

                    // -REMOVER O INDICE SORTEADO DA LISTA DE DISPONIVEIS
                    indicesDisponiveis.remove(indiceSorteado);

                }

                

            }
        }
        return nomesAmigosSecretos;
    }

    private int escolherIndiceAleatorio(List<Integer> indicesDisponiveis, int i) {
        Random random = new Random();
        int maxIndex = indicesDisponiveis.size() - 1;
        if (indicesDisponiveis.size() == 1) {
            return 0;
        }
        int indiceSorteado;

        do {
            indiceSorteado = random.nextInt(maxIndex + 1);
        } while (indiceSorteado == i);

        return indiceSorteado;
    }

}
