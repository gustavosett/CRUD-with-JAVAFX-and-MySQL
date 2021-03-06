/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package novo.crud;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private ToggleButton btnFem;
    @FXML
    private TableView<Pessoa> tvCadastros;
    @FXML
    private TableColumn<Pessoa, String> colNome;
    @FXML
    private TableColumn<Pessoa, Integer> colIdade;
    @FXML
    private TableColumn<Pessoa, Character> colSexo;
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
        mostraUsuarios();
        
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnCadastrar){
            botaoCadastrar();
        } else if (event.getSource() == btnAtualizar){
            botaoAtualizar();
        } else if (event.getSource() == btnDeletar) {
            botaoDeletar();
        }
    }
    
    @FXML
    private void genderButtonAction(ActionEvent event) {
        if(event.getSource() == btnMasc){
            btnFem.setSelected(false);
        } else if (event.getSource() == btnFem){
            btnMasc.setSelected(false);
        }
    }

    @FXML
    private void tableMouseClicked(Event event) {
        Pessoa pes = tvCadastros.getSelectionModel().getSelectedItem();
        tfNome.setText(pes.getNome());
        tfIdade.setText(String.valueOf(pes.getIdade()));
        switch (pes.getSexo()) {
            case 'M':
                btnFem.setSelected(false);
                btnMasc.setSelected(true);
                break;
            case 'F':
                btnFem.setSelected(true);
                btnMasc.setSelected(false);
                break;
            default:
                btnFem.setSelected(false);
                btnMasc.setSelected(false);
                break;
        }
    }

    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "senha");
            return conn;
        }catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }
    
    public String isSelected(){
        if (btnMasc.isSelected()){
            return "M";
        } else if (btnFem.isSelected()){
            return "F";
        } else {
            return "N";
        }
    }

    public ObservableList<Pessoa> getListaUsuarios(){
        ObservableList<Pessoa> listaPessoa = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM usuarios";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Pessoa pessoa;
            while(rs.next()){
                pessoa = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
                listaPessoa.add(pessoa);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return listaPessoa;
    }

    public void mostraUsuarios(){
        ObservableList<Pessoa> lista = getListaUsuarios();

        colID.setCellValueFactory(new PropertyValueFactory<Pessoa, Integer>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<Pessoa, String>("nome"));
        colIdade.setCellValueFactory(new PropertyValueFactory<Pessoa, Integer>("idade"));
        colSexo.setCellValueFactory(new PropertyValueFactory<Pessoa, Character>("sexo"));
        
        tvCadastros.setItems(lista);
    }
    
    private void limpa(){
        btnFem.setSelected(false);
        btnMasc.setSelected(false);
        tfNome.setText("");
        tfIdade.setText("");
    }
    
    private void botaoCadastrar(){
        String query = "INSERT INTO usuarios (nome, idade, sexo) VALUES ('" +
                tfNome.getText() + "', " + tfIdade.getText() + ", '" + isSelected() + "')";
        executeQuery(query);
        mostraUsuarios();
        limpa();
    }
    
    private void botaoAtualizar() {
        Pessoa pes = tvCadastros.getSelectionModel().getSelectedItem();
        String query = "UPDATE usuarios SET nome = '" + tfNome.getText() +
                "', idade = " + tfIdade.getText() + "," + "sexo = '" + isSelected() + "' WHERE id = " + String.valueOf(pes.getId());
        executeQuery(query);
        mostraUsuarios();
        limpa();
    }
    
    private void botaoDeletar() {
        Pessoa pes = tvCadastros.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM usuarios WHERE id = " + String.valueOf(pes.getId()) + "";
        executeQuery(query);
        mostraUsuarios();
        limpa();
    }

    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
