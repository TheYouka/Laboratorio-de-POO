package com.example.sistemaestudiantila1945;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class MainSceneController implements Initializable {

    boolean nombreValido = false;
    boolean matriculaValida = false;
    boolean semestreValido = false;
    boolean promedioValido = false;

    private ObservableList<Estudiante> listaEstudiantes;


    @FXML
    private ChoiceBox<String> carreraChoiceBox;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField matriculaTextField;
    @FXML
    private TextField semestreTextField;
    @FXML
    private TextField promedioTextField;
    @FXML
    private Boton21Estilizado submitButton;
    @FXML
    private TableView<Estudiante> estudiantesTableView;

    @FXML
    private Button borrarButton;
    @FXML
    private Button actualizarButton;


    private String[] carreas = {"LCC","LMAD","LSTI","LF","LM"};

    TableColumn<Estudiante, String> primeraColumna = new TableColumn<>("Nombre");
    TableColumn<Estudiante, String> segundaColumna = new TableColumn<>("Carrera");
    TableColumn<Estudiante, String> terceraColumna = new TableColumn<>("Matricula");
    TableColumn<Estudiante, Integer> cuartaColumna = new TableColumn<>("Semestre");
    TableColumn<Estudiante, Double> quintaColumna = new TableColumn<>("Promedio");


    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        carreraChoiceBox.getItems().addAll(carreas);
        carreraChoiceBox.setOnAction(this::getCarreraSelected);

        listaEstudiantes = FXCollections.observableArrayList();
        estudiantesTableView.setItems(listaEstudiantes);

        primeraColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        segundaColumna.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        terceraColumna.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        cuartaColumna.setCellValueFactory(new PropertyValueFactory<>("semestre"));
        quintaColumna.setCellValueFactory(new PropertyValueFactory<>("promedio"));

        estudiantesTableView.getColumns().addAll(
                primeraColumna, segundaColumna, terceraColumna, cuartaColumna, quintaColumna
        );
    }

    public void getCarreraSelected(ActionEvent e){
        String carrera = carreraChoiceBox.getValue();
        System.out.println("Carrera seleccionada: " + carrera);
    }

    public void agregarEstudiante(ActionEvent e) {
        if(nombreValido && matriculaValida && semestreValido && promedioValido && carreraChoiceBox.getValue() != null){
            // (Tu lógica para agregar)
            String nombre = nombreTextField.getText();
            String matricula = matriculaTextField.getText();
            String carrera = carreraChoiceBox.getValue();
            int semestre = Integer.parseInt(semestreTextField.getText());
            double promedio = Double.parseDouble(promedioTextField.getText());
            Estudiante nuevoEstudiante = new Estudiante(nombre, carrera, matricula, semestre, promedio);
            listaEstudiantes.add(nuevoEstudiante);

            submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
            submitButton.setText("Submit");
            mostrarAlerta("Confirmación", "Datos enviados", Alert.AlertType.INFORMATION);
            limpiarCampos();
        }
        else{
            submitButton.setText("Formulario inválido");
            submitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        }
    }

    @FXML
    public void borrarEstudiante(ActionEvent e) {
        // 1. Obtenemos el estudiante seleccionado de la tabla
        Estudiante estudianteSeleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        // 2. Revisamos si de verdad seleccionó uno
        if (estudianteSeleccionado == null) {
            mostrarAlerta("Error", "No has seleccionado ningún estudiante para borrar.", Alert.AlertType.ERROR);
            return;
        }

        // 3. ¡Pedimos confirmación! (Como lo pediste)
        Alert alertaConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        alertaConfirmacion.setTitle("Confirmar Borrado");
        alertaConfirmacion.setHeaderText("¿Estás seguro de que quieres borrar a " + estudianteSeleccionado.getNombre() + "?");
        alertaConfirmacion.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> resultado = alertaConfirmacion.showAndWait();

        // 4. Si el usuario dice "OK", lo borramos de la lista
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            listaEstudiantes.remove(estudianteSeleccionado);
            mostrarAlerta("Éxito", "Estudiante borrado correctamente.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    public void actualizarEstudiante(ActionEvent e) {
        // 1. Obtenemos el estudiante seleccionado
        Estudiante estudianteSeleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        if (estudianteSeleccionado == null) {
            mostrarAlerta("Error", "No has seleccionado ningún estudiante para actualizar.", Alert.AlertType.ERROR);
            return;
        }

        Dialog<Estudiante> dialog = new Dialog<>();
        dialog.setTitle("Actualizar Estudiante");
        dialog.setHeaderText("Actualizando datos de: " + estudianteSeleccionado.getNombre());

        ButtonType botonActualizar = new ButtonType("Actualizar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(botonActualizar, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nombre = new TextField(estudianteSeleccionado.getNombre());
        TextField matricula = new TextField(estudianteSeleccionado.getMatricula());
        TextField carrera = new TextField(estudianteSeleccionado.getCarrera());
        TextField semestre = new TextField(String.valueOf(estudianteSeleccionado.getSemestre()));
        TextField promedio = new TextField(String.valueOf(estudianteSeleccionado.getPromedio()));

        grid.add(new Label("Nombre:"), 0, 0); grid.add(nombre, 1, 0);
        grid.add(new Label("Matrícula:"), 0, 1); grid.add(matricula, 1, 1);
        grid.add(new Label("Carrera:"), 0, 2); grid.add(carrera, 1, 2);
        grid.add(new Label("Semestre:"), 0, 3); grid.add(semestre, 1, 3);
        grid.add(new Label("Promedio:"), 0, 4); grid.add(promedio, 1, 4);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == botonActualizar) {
                try {
                    int sem = Integer.parseInt(semestre.getText());
                    double prom = Double.parseDouble(promedio.getText());
                    return new Estudiante(nombre.getText(), carrera.getText(), matricula.getText(), sem, prom);
                } catch (NumberFormatException ex) {
                    // (Si ponen letras en semestre, etc.)
                    return null;
                }
            }
            return null;
        });

        Optional<Estudiante> resultado = dialog.showAndWait();

        resultado.ifPresent(estudianteActualizado -> {
            listaEstudiantes.remove(estudianteSeleccionado);
            listaEstudiantes.add(estudianteActualizado);
            mostrarAlerta("Éxito", "Estudiante actualizado.", Alert.AlertType.INFORMATION);
        });
    }



    private void limpiarCampos() {
        nombreTextField.clear();
        matriculaTextField.clear();
        semestreTextField.clear();
        promedioTextField.clear();
        carreraChoiceBox.setValue(null);
        // Reseteamos las banderas
        nombreValido = false;
        matriculaValida = false;
        semestreValido = false;
        promedioValido = false;
    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }

    public void validarNombre(KeyEvent e){
        String textoActual = nombreTextField.getText();
        String regexSoloLetrasYEspacios = "^[a-zA-Z ]*$";
        nombreValido = textoActual.matches(regexSoloLetrasYEspacios) && !textoActual.isEmpty();
        aplicarEstiloError(nombreTextField, nombreValido);
    }
    public void validarMatricula(KeyEvent e) {
        String textoActual = matriculaTextField.getText();
        String regexSoloNumeros = "^[0-9]+$";
        matriculaValida = textoActual.matches(regexSoloNumeros);
        aplicarEstiloError(matriculaTextField, matriculaValida);
    }
    public void validarSemestre(KeyEvent e) {
        String textoActual = semestreTextField.getText();
        String regexNumerosMaxDos = "^[1-9][0-9]?$";
        semestreValido = textoActual.matches(regexNumerosMaxDos);
        aplicarEstiloError(semestreTextField, semestreValido);
    }
    public void validarPromedio(KeyEvent e) {
        String textoActual = promedioTextField.getText();
        try {
            double valor = Double.parseDouble(textoActual);
            if (valor >= 0.0 && valor <= 100.0) {
                promedioValido = true;
                aplicarEstiloError(promedioTextField, true);
            } else { promedioValido = false; aplicarEstiloError(promedioTextField, false); }
        } catch (NumberFormatException ex) {
            promedioValido = false;
            aplicarEstiloError(promedioTextField, false);
        }
    }
    private void aplicarEstiloError(TextField campo, boolean esValido) {
        if (esValido) {
            campo.setStyle(null);
        } else {
            campo.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
        }
    }
}