package Repositorios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Main.Classes.Grupos;
import Main.Classes.Pessoa;

public class IRepositorioSorteio {
    
    private List<Pessoa> pessoas;
    


    public IRepositorioSorteio(){

    }
    public IRepositorioSorteio(List<Pessoa> pessoa){
        this.pessoas = pessoa;
    }

    /*----METODO QUE REALIZA O SORTEIO */
    public void realizarAmigoSecreto(List<Pessoa> pessoas){


        List<Pessoa> embaralhaPessoas = new ArrayList<>(pessoas);
        Collections.shuffle(embaralhaPessoas);


        //----Verifica se a lista de pessoas é valida para o sorteio
        if(pessoas.size() < 2){
            //--EXCPETIONN
            System.out.println("Não há pessoas suficientes para realizar o sorteio.");
            return;
        }

        //---CRIAÇÃO DE UM GRAFO DIRECIONADO REPRESENTANDO O SORTEIO
        List<Integer> indicesDisponiveis = new ArrayList<>();
        for(int i = 0; i < pessoas.size(); i++){
            indicesDisponiveis.add(i);
        }

        for(int i = 0; i < pessoas.size(); i++){
            Pessoa pessoaAtual = pessoas.get(i);

            //---ESCOLHER ALEATORIAMENTE UM INDICE DE UMA PESSOA NAO SELECIONADA
            int indiceSorteado = escolherIndiceAleatorio(indicesDisponiveis, i);

            //---GARANTIR QUE O INDICE SORTEADO NAO SEJA O MESMO INDICE ATUAL
            if(indiceSorteado == i){
                //--SE FOR O MESMO, TROQUE COM O ULTIMO INDICE DISPONIVEL
                Collections.swap(indicesDisponiveis, i, indicesDisponiveis.size() - 1);
                indiceSorteado = escolherIndiceAleatorio(indicesDisponiveis, i);
            }
            
            //--OBTER A PESSOA CORRESPONDENTE AO INDICE SORTEADO
            Pessoa amigoSecreto = pessoas.get(indicesDisponiveis.get(indiceSorteado));

            //-REMOVER O INDICE SORTEADO DA LISTA DE DISPONIVEIS
            indicesDisponiveis.remove(indiceSorteado);
            

            System.out.println(pessoaAtual + " tirou " + amigoSecreto);
        }
        
    }

    private int escolherIndiceAleatorio(List<Integer> indicesDisponiveis, int currentIndex){
            Random random = new Random();
            int maxIndex = indicesDisponiveis.size() - 1;

            if(indicesDisponiveis.size() == 1){
                return 0;
            }

            int indiceSorteado;

            do{
                indiceSorteado = random.nextInt(maxIndex + 1);
            }while(indiceSorteado == currentIndex);

            return indiceSorteado;
        }

    
}
