package com.personapp.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;



public class Person implements Serializable, Converter {

    /**
     * attributes
     */
    private String name;
    private long DOB; //Date of Birth

    /**
     * Default Contructor Creation
     */
    public Person(){
        name="";
        DOB=0;
    }

    /**
     *
     * constructor
     */
    public Person(String name, long DOB){
        this.DOB=DOB;
        this.name=name;
    }

    /**
    *
    * setter methods
    * */
    public void setDOB(long DOB){

        this.DOB=DOB;
    }
    public void setName(String name){

        this.name=name;
    }

    public long getDOB(){
        return DOB;
    }
    public String getName(){
        return name;
    }


    /**
    *
    *this method is to serialize an object and store it in a file call personfile.ser
    *it takes an input of a person object and prints that the object has been serialized
     */
    public static void serializationBinary(Person person,String fileName){
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(output);

            out.writeObject(person);
            out.flush();
            System.out.println("The object has been serialized.");
        }
        catch(Exception e){
            System.out.println("error");
        }
    }

    /**
    *
    *this method is deserialize a person object from the file personfile.ser
    *the method prints weather is has been deserialized and prints out the persons name and DOB
    */
    public static Person deserializationBinary(String fileName) {
        Person personNew=null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            personNew = (Person) in.readObject();
            //System.out.println("The object has been deserialized");
            //System.out.println("The person's name is "+personNew.name + ", and their DOB is " +personNew.DOB + ".");

            in.close();
            return personNew;
        }
        catch(Exception e){
            System.out.println("error");
        }
        return personNew;
    }

    /**
     * serialization with a csv file
     */
    public static void serializationCSV(Person person, String fileName){
        FileWriter fileWriter=null;
        try{

            //creates the csv
            fileWriter= new FileWriter(fileName);
            //creates a header
            fileWriter.append("Name,DOB");
            //creates a line seperator
            fileWriter.append("\n");
            //writes a person to the CSV file
            fileWriter.append(String.valueOf(person.name));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(person.DOB));
            //fileWriter.append(",");

            System.out.println("CSV file created");
        }
        catch (Exception e){
            System.out.println("something went wrong");
            e.printStackTrace();
        }
        finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e){
                System.out.println("error while flushing");
            }
        }
    }

    /**
     * deseralization with a csv file
     */
    public static Person deserializationCSV(String fileName){
        BufferedReader fileReader=null;
        Person person=null;

        try{
            fileReader=new BufferedReader(new FileReader(fileName));
            String line="";
            //read CSV file header to skip it
            fileReader.readLine();
            while((line=fileReader.readLine())!=null){
                //get all tokens available in a line
                String[] token=line.split(",");
                if(token.length>0){
                    //create a new person object
                    //token 0 and 1 are the name and DOB
                     person= new Person(token[0],Long.parseLong(token[1]));
                    return person;
                }

            }
        }
        catch(Exception e){
            System.out.println("Error while reading csv");
        }
        finally{
            try{
                fileReader.close();
            }
            catch(IOException e){
                System.out.println("error while closing file reader");
            }
        }
        return person;

    }
    //followed this tutioral https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/

    /**
     * serialization with xml
     * @param person
     */
    public static void serializationXML(Person person,String fileName) {
        XMLEncoder encoder=null;
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(fileName);
            encoder = new XMLEncoder(fos);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        encoder.writeObject(person);
         try {
                encoder.close();
                fos.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("The object has been serialized in xml");

    }

    /**
     * xml deserialization
     */
    public static Person deserializationXML(String fileName){
        XMLDecoder decoder=null;
        FileInputStream fis=null;
        try{
            //decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("person.xml")));
            fis=new FileInputStream(fileName);
            decoder= new XMLDecoder(fis);
        }
        catch(Exception e){
            System.out.println(e);
        }
        Person decodedP=(Person) decoder.readObject();
        decoder.close();
        return decodedP;
    }

    public static void  serializationXStream(Person person, String file){

        FileOutputStream fos=null;
        XStream xstream=new XStream(new DomDriver());
        try {
            fos=new FileOutputStream(file);
            xstream.toXML(person,fos);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            if(fos!=null){
                try{
                    fos.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }

        }

    }

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context){
        Person person = (Person) value;
        writer.startNode("name");
        writer.setValue(person.getName());
        writer.endNode();

        writer.startNode("DOB");
        writer.setValue(person.getDOB());
        writer.endNode();


    }

    public Person unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context){
        Person person = new Person();

        reader.moveDown();
        person.setName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setDOB(Long.parseLong( reader.getValue()));
        reader.moveUp();

        reader.moveDown();

        return person;


    }

    //https://howtodoinjava.com/java/serialization/xmlencoder-and-xmldecoder-example/
    public static Person deserializationXStream(String file){
        XStream xstream= new XStream(new DomDriver());
        Person person=new Person();
        try{
            FileInputStream fis= new FileInputStream(file);
            xstream.fromXML(fis,person);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return person;
    }

    public String prettyString(){

        return "The person's name is "+name+", and their DOB is "+DOB+".";
    }




}
