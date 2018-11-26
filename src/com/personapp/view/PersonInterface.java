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
    private Label personLabel;

    //Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));

    @FXML
    public void binaryDeserialization(ActionEvent event) {
        Person person= Person.deserializationBinary("personFile.ser");
        personLabel.setText("Binary:"+person.prettyString());

    }


    @FXML
    private void binarySerialization(ActionEvent event) {
        Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));
        Person.serializationBinary(person,"personFile.ser");

    }

    @FXML
    void csvDeserialization(ActionEvent event) {
        Person person= Person.deserializationCSV("person.csv");
        personLabel.setText("CSV: "+person.prettyString());
    }

    @FXML
    void csvSerialization(ActionEvent event) {
        Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));
        Person.serializationCSV(person,"person.csv");
    }

    @FXML
    void xmlDeserialization(ActionEvent event) {
        Person person= Person.deserializationXML("person.xml");
        personLabel.setText("XML: "+person.prettyString());
    }

    @FXML
    void xmlSerialization(ActionEvent event) {
        Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));
        Person.serializationXML(person,"person.xml");
    }

    @FXML
    void xstreamDeserialization(ActionEvent event){
        Person person= Person.deserializationXStream("xstream.xml");
        personLabel.setText("XStream: "+person.prettyString());

    }

    @FXML
    void xstreamSerialization(ActionEvent event){
        Person person=new Person(name.getText(),Long.parseLong(dateOfBirth.getText()));
        Person.serializationXStream(person,"xstream.xml");

    }



}