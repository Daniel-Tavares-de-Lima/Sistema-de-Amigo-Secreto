package Controller;

import java.beans.EventHandler;
/*-----IMPORTS */
import java.time.LocalDate;
import Main.App;
import Main.Classes.Grupos;
import Main.Classes.Pessoa;
import Main.Classes.TelasEnum;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
/*---------- */
import javafx.scene.input.MouseEvent;

public class GruposController {
    /*----HEADER */
    @FXML
    protected void bt2Pessoa(ActionEvent e) {
        App.mudarTela(TelasEnum.PESSOAS);
    }

    @FXML
    protected void bt2Grupos(ActionEvent e) {
        App.mudarTela(TelasEnum.GRUPOS);
    }

    @FXML
    protected void bt2Presentes(ActionEvent e) {
        App.mudarTela(TelasEnum.PRESENTES);
    }

    @FXML
    protected void bt2Sorteio(ActionEvent e) {
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */

    /*-----MAIN---*/

    /*----VARIAVEIS FXML */
    @FXML
    private DatePicker data;
    @FXML
    private TextField tfNomeGrupo;
    @FXML
    private ComboBox<Grupos> cbGrupos;
    @FXML
    private ListView<Pessoa> pessoasGrupo;
    @FXML
    private ListView<Pessoa> todosOsGrupos;
    /*------- */

    /*-----VARIAVEIS COMUNS */
    private ObservableList<Grupos> obsGrupos;
    int comparar;
    /*------ */

    /*------ PESSOAS*/
    private ObservableList<Pessoa> obsPessoas;
    private ObservableList<Pessoa> obsPessoasNoGrupo;

    /*------------- */

    // ---METODO PARA O DATEPICKER
    public void getData(ActionEvent e) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate calenData = data.getValue();

        comparar = dataAtual.compareTo(calenData);

        System.out.println(calenData.toString());
    }

    // ---METODO PARA SALVAR O NOME DO GRUPO

    @FXML
    protected void salvarGrupo(ActionEvent e) {

        // ---VERIFICAR SE NÃO ESTA NULO OU VAZIO
        String labelGrupo = tfNomeGrupo.getText();

        if (labelGrupo != null && !labelGrupo.isEmpty() && data.getValue() != null) {

            if(comparar <= 0) {
                Grupos grupo = new Grupos(labelGrupo);

                App.grupo.addGrupos(grupo);

                /*---COMBO BOX */
                obsGrupos = FXCollections.observableArrayList(App.grupo.getGrupos());
                cbGrupos.setItems(obsGrupos);
                cbGrupos.setValue(grupo);

                /*------- */

                tfNomeGrupo.setText("");
                tfNomeGrupo.requestFocus();
                data.getEditor().clear();

                for (Grupos g : App.grupo.getGrupos()) {
                    System.out.println(g);
                }
            } else {
                // ---EXCEPTION
                System.out.println("ESCOLHA UMA DATA CERTA");
                data.getEditor().clear();
            }

        } else {
            System.out.println("A Label esta vazia");
        }
    }
    /*-------------------- */

    /*------TELA 2 */
    /*-----METODO QUE MANDA AS INFORMAÇÕES DA TELA PESSOA PARA A TELA GRUPO */

    @FXML
    protected <T> void initialize() {
        Interface.MudarTela.mudancaListeree(new Interface.MudarTela.mudanca() {
            @Override
            public void mudar(TelasEnum novaTela, Object userData) {
                if (novaTela.equals(TelasEnum.GRUPOS)) {
                    obsPessoas = FXCollections.observableArrayList(App.pessoa.getPessoas());
                    todosOsGrupos.setItems(obsPessoas);
                    obsPessoasNoGrupo = FXCollections.observableArrayList(App.pessoa.getPessoasEscolhidas());
                    pessoasGrupo.setItems(obsPessoasNoGrupo);

                    // cbGrupos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    // if (newValue != null) {
                    // /*atualiza(newValue);*/


                    // }
                    // });

                    // cbGrupos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Grupos>() {
                    //     @Override
                    //     public void changed(ObservableValue<? extends Grupos> observalble, Grupos oldValue, Grupos newValue){
                            
                    //         for(Pessoa p : newValue.getPessoasCerta()){
                    //             System.out.println(p);
                    //         }
                            
                    //     }
                    // });
                   

                }
            }
        });
    }


    @FXML
    // --METODO PARA ADICIONAR PESSOAS NO GRUPO
    protected void btAddPessoa(ActionEvent e) {
        Pessoa itemPessoa = todosOsGrupos.getSelectionModel().getSelectedItem();
        Grupos gruposSelecionados = cbGrupos.getValue();
        
        if (cbGrupos.getValue() != null && itemPessoa != null) {
            if(!gruposSelecionados.getPessoasCerta().contains(itemPessoa)){
                gruposSelecionados.adicionarPessoa(itemPessoa);

                obsPessoasNoGrupo = FXCollections.observableArrayList(gruposSelecionados.getPessoasCerta());
                pessoasGrupo.setItems(obsPessoasNoGrupo);

            }else{
                System.out.println("ESSA PESSOA JA FOI ADD NO: " + gruposSelecionados);
            }
            
            for(Pessoa g : gruposSelecionados.getPessoasCerta()){
                System.out.println("A pessoa esta no grupo : " + gruposSelecionados + " o nome dela é: " + g);
            }
        }else {
            // ---EXCEPTION
            System.out.println("LABEL VAZIA");
        }

    }

    @FXML
    protected void btSalvar(ActionEvent e){
        //----EXCEPTION
    }

    @FXML
    // ----METODO PARA DELETAR PESSOAS DA LISTVIEW
    protected void deletePessoaGrupo(ActionEvent e) {
        Pessoa itemPessoa = pessoasGrupo.getSelectionModel().getSelectedItem();
        Grupos gruposSelecionados = cbGrupos.getValue();
        if (itemPessoa != null && gruposSelecionados != null) {
            gruposSelecionados.removerPessoa(itemPessoa);
            
            obsPessoasNoGrupo = FXCollections.observableArrayList(gruposSelecionados.getPessoasCerta());
            pessoasGrupo.setItems(obsPessoasNoGrupo);
        } else {
            System.out.println("SELECIONE UM CAMPO!");
        }

    }

    /*---FIM MAIN */

    /*---FOOTER-- */
    @FXML
    protected void btnVoltar(ActionEvent e) {
        tfNomeGrupo.setText("");
        data.getEditor().clear();
        App.mudarTela(TelasEnum.MAIN);
    }
    /*-----FIM FOOTER */

}