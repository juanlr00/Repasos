package com.mycompany.respasojavafx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private ChoiceBox<String> liga;
    @FXML
    private TextField txtEquipo;
    @FXML
    private ComboBox<String> posicion;
    @FXML
    private Spinner<Integer> precio;
    @FXML
    private CheckBox disponible;
    @FXML
    private DatePicker nacimiento;
    @FXML
    private Button btnCrear;
    @FXML
    private Label info;
    @FXML
    private Button btnCancelar;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void crear(ActionEvent event) {
        
        if(liga.getValue()=="Serie A") {
            Alert modal = new Alert(AlertType.WARNING);
            modal.setContentText("La Serie A aun no esta activa ");
            modal.setHeaderText("Cuidao primo");
            modal.showAndWait();
            return;
        }
        
        if ( disponible.isSelected()) {
            info.setStyle("-fx-background-color:green");
            info.setText("Se va a añadir el jugador "+txtNombre.getText()+" al equipo "+ txtEquipo.getText());
            
        }else{    
            info.setStyle("-fx-background-color:red");
            info.setText("No se pueden añadir jugadores no disponibles");
        }
        
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Numero para el spinner
        SpinnerValueFactory svf = new IntegerSpinnerValueFactory(100000,25000000,300000,500000);
        precio.setValueFactory(svf);
        
        //Añade los items al choiceBox
        liga.getItems().clear();
        liga.getItems().addAll("Liga Santander","Premier League","Seria A");
        //Poner por defecto
        liga.setValue("Liga Santander");
        
        //Añade items al comboBox
        posicion.getItems().clear();
        posicion.getItems().addAll("portero","defensa","mediocentro","delantero");
        posicion.setValue("portero");
        
        //Fecha actual
        nacimiento.setValue( LocalDate.now());
    }

    @FXML
    private void cancelar(ActionEvent event) {
        //Boton cancelar
        Alert salida = new Alert(AlertType.CONFIRMATION);
        salida.setContentText("¿Desea salir?");
        
        var r = salida.showAndWait();
        
        if( (r.get().getText()).equals("Aceptar") ) {
            System.out.println("Saliendo...");
            //Sale del programa
            System.exit(0);
        }
    }
}
