package com.personapp.view;

import com.personapp.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import javafx.event.ActionEvent;

public class PersonInterface {




    @FXML
    private TextField name;

    @FXML
    private TextField dateOfBirth;

    @FXML
    private Button binarySerialization;

    @FXML
    private Button csvSerialization;

    @FXML
    private Button xmlSerialization;

    @FXML
    private Button binaryDeserialization;

    @FXML
    private Button csvDeserialzation;

    @FXML
    private Button xmlDeserialization;

    @FXML
    private Label personLabel;

    Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));

    @FXML
    public void binaryDeserialization(ActionEvent event) {
        Person person= Person.deserializationBinary("personFile.ser");
        personLabel.setText("Binary:"+person.prettyString());

    }


    @FXML
    private void binarySerialization(ActionEvent event) {
        Person.serializationBinary(person,"personFile.ser");

    }

    @FXML
    void csvDeserialization(ActionEvent event) {

    }

    @FXML
    void csvSerialization(ActionEvent event) {

    }

    @FXML
    void xmlDeserialization(ActionEvent event) {

    }

    @FXML
    void xmlSerialization(ActionEvent event) {

    }

    /*
        @FXML
    void binaryDeserialization(ActionEvent event) {
        Person person= Person.deserializationBinary("personFile.ser");
        personLabel.setText("Binary:"+person.prettyString());

    }

    @FXML
    void binarySerialization(ActionEvent event) {
        Person.serializationBinary(person,"personFile.ser");
    }

    @FXML
    void csvDeserialization(ActionEvent event) {
        Person person= Person.deserializationCSV("person.csv");
        personLabel.setText("CSV: "+person.prettyString());

    }

    @FXML
    void csvSerialization(ActionEvent event) {
        Person.serializationCSV(person,"person.csv");

    }

    @FXML
    void xmlDeserialization(ActionEvent event) {
        Person.serializationXML(person,"person.xml");

    }

    @FXML
    void xmlSerialization(ActionEvent event) {
        Person person= Person.deserializationXML("person.xml");
        personLabel.setText("XML: "+person.prettyString());

    }
     */

}