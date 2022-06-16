/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package novo.crud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
/**
 * FXML Controller class
 *
 * @author Gusta
 */
public class MainController implements Initializable {


    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfIdade;
    @FXML
    private ToggleButton btnMasc;
    @FXML
    private ToggleButton BtnFem;
    @FXML
    private TableView<?> tvCadastros;
    @FXML
    private TableColumn<Pessoa, String> colNome;
    @FXML
    private TableColumn<Pessoa, Integer> colIdade;
    @FXML
    private TableColumn<Pessoa, String> colSexo;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnDeletar;
    @FXML
    private TableColumn<Pessoa, Integer> colID;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    

}
