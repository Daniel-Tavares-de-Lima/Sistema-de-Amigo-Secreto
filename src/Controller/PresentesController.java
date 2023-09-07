package Controller;

import Main.App;
import Main.Classes.Pessoa;
import Main.Classes.Presentes;
import Main.Classes.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PresentesController {
    /*----HEADER */
    @FXML
    protected void bt3Pessoa(ActionEvent e){
        App.mudarTela(TelasEnum.PESSOAS);
    }
    @FXML
    protected void bt3Grupos(ActionEvent e){
        App.mudarTela(TelasEnum.GRUPOS);
    }
    @FXML
    protected void bt3Presentes(ActionEvent e){
        App.mudarTela(TelasEnum.PRESENTES);
    }
    @FXML
    protected void bt3Sorteio(ActionEvent e){
        App.mudarTela(TelasEnum.SORTEIO);
    }
    /*-----FIM HEADER */

    /*-----MAIN */
    @FXML
    private TextField categoria;

    @FXML
    private TextArea descricao;

    @FXML
    private TextField preco;



    public TextField getCategoria(){
        return categoria;
    }


    @FXML
    protected void salvarPresente(ActionEvent e){
        //---VERIFICAR SE NAO ESTA NULO

        String labelCategoria = categoria.getText();
        String labelDescricao = descricao.getText();
        String labelPreco = preco.getText();
        
        if(labelCategoria != null && !labelCategoria.isEmpty() && labelDescricao != null && !labelDescricao.isEmpty() && labelPreco != null && !labelPreco.isEmpty()){
            if(labelPreco.substring(0).matches("[0-9]*")){

                Presentes presentes = new Presentes(labelCategoria);
                App.presente.addPresentes(presentes);
                
                categoria.setText("");
                descricao.setText("");
                preco.setText("");
                categoria.requestFocus();


            }else{
                //---EXCEPTION
                System.out.println("NAO É UM NUMERO");
                preco.setText("");
            }
        }else{
            System.out.println("A label esta vazia");
        }

        


    }



    
}
