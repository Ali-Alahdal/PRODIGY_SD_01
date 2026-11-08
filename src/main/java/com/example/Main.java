package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    @Override
    public void start(Stage stage) {

        //establshing the window tab and center the elements in vertical view
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Temperature Conversion Application ");
        stage.setScene(scene);
        stage.show();


        // welcoming label
        Label title = new Label("Welcome To Temperature Conversion ");



        // user input
        TextField input = new TextField("0");


        // label for to display the value of each unit
        Label celsius = new Label("Celsius : 0" );
        Label fahrenheit = new Label("Fahrenheit : 0");
        Label kelvin = new Label("Kelvin : 0");



        // Dropdown for the unit selection
        ComboBox<String> unitDropdown = new ComboBox<>();
        unitDropdown.getItems().addAll(
                "Celsius",
                "Fahrenheit",
                "Kelvin"
        );
        unitDropdown.setValue("Celsius");


        Button convertButton = new Button("convert");




        // Converation Actions , method calling based on the selected unit
        convertButton.setOnAction(event -> {
            String selectedUnit = unitDropdown.getValue();
            if(selectedUnit == "Celsius"){
               celsius.setText("Celsius : " + String.valueOf(input.getText()));
               fahrenheit.setText("Fahrenheit : "  + String.valueOf(celsiusToFahrenheit(Double.parseDouble(input.getText()))));
               kelvin.setText("Kelvin : "  + String.valueOf(celsiusToKelvin(Double.parseDouble(input.getText()))));
            } else if (selectedUnit == "Fahrenheit") {
                celsius.setText("Celsius : " + fahrenheitToCelsius(Double.parseDouble(input.getText())));
                fahrenheit.setText("Fahrenheit : "  + String.valueOf(input.getText()));
                kelvin.setText("Kelvin : "  + String.valueOf(fahrenheitToKelvin(Double.parseDouble(input.getText()))));
            }else{
                celsius.setText("Celsius : " + kelvinToCelsius(Double.parseDouble(input.getText())));
                fahrenheit.setText("Fahrenheit : "  + kelvinToFahrenheit(Double.parseDouble(input.getText())));
                kelvin.setText("Kelvin : "  + String.valueOf(input.getText()));
            }
        });
        root.getChildren().addAll(title,unitDropdown , input, convertButton , celsius, fahrenheit, kelvin);

    }

     static void main(String[] args) {

        launch(args);


    }

    // converation operations

    // --- Celsius to Others ---
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // --- Fahrenheit to Others ---
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0 + 273.15;
    }

    // --- Kelvin to Others ---
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9.0 / 5.0 + 32.0;
    }
}
