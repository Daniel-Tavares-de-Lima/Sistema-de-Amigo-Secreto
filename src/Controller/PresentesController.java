package Controller;

/*-----IMPORTS */
import Main.App;
import Main.Classes.Presentes;
import Main.Classes.TelasEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/*----- */


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
    /*-----VARIAVEIS FXML */
    @FXML
    private TextField categoria;
    @FXML
    private TextArea descricao;
    @FXML
    private TextField preco;
    /*-------- */

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


                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.INFORMATION);
                alertSalvaPessoa.setTitle("PRESENTES ADICIONADOS");
                alertSalvaPessoa.setContentText("Presente salvo com sucesso!");
                alertSalvaPessoa.show();
                /*------ */

            }else{
                
                /*---ALERT */
                Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
                alertSalvaPessoa.setTitle("APENAS NUMEROS");
                alertSalvaPessoa.setContentText("Por favor, digite apenas numeros");
                alertSalvaPessoa.show();
                /*------ */
                preco.setText("");
            }
        }else{
            /*---ALERT */
            Alert alertSalvaPessoa = new Alert(Alert.AlertType.ERROR);
            alertSalvaPessoa.setTitle("CAMPO VAZIL");
            alertSalvaPessoa.setContentText("Por favor, selecione um campo");
            alertSalvaPessoa.show();
            /*------ */
        }

    }

    /*-------- */

    /*---FOOTER-- */
   @FXML
   protected void btnVoltar(ActionEvent e){
       categoria.setText("");
       descricao.setText("");
       preco.setText("");
       App.mudarTela(TelasEnum.MAIN);
   }
   /*-----FIM FOOTER */




    
}
