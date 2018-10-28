import java.io.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Person implements Serializable {

    /**
     * attributes
     */
    private String name;
    private String DOB; //Date of Birth

    /**
     * Default Contructor Creation
     */
    private Person(){
    }

    /**
     *
     * constructor
     */
    public Person(String name, String DOB){
        this.DOB=DOB;
        this.name=name;
    }

    /**
    *
    * setter methods
    * */
    public void setDOB(String DOB){
        this.DOB=DOB;
    }
    public void setName(String name){
        this.name=name;
    }


    /**
    *
    *this method is to serialize an object and store it in a file call personfile.ser
    *it takes an input of a person object and prints that the object has been serialized
     */
    public static void serializaton(Person p){
        try {
            FileOutputStream output = new FileOutputStream("personfile.ser");
            ObjectOutputStream out = new ObjectOutputStream(output);

            out.writeObject(p);
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
    public static void deserialization() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("personfile.ser"));
            Person personNew = (Person) in.readObject();
            System.out.println("The object has been deserialized");
            System.out.println("The person's name is "+personNew.name + ", and their DOB is " +personNew.DOB + ".");

            in.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
    }

    /**
     * serialization with a csv file
     */
    public static void serializationCSV(Person p){
        FileWriter fileWriter=null;
        try{

            //creates the csv
            fileWriter= new FileWriter("person.csv");
            //creates a header
            fileWriter.append("Name,DOB");
            //creates a line seperator
            fileWriter.append("\n");
            //writes a person to the CSV file
            fileWriter.append(String.valueOf(p.name));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(p.DOB));
            fileWriter.append(",");

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
    public static void deserializationCSV(){
        BufferedReader fileReader=null;

        try{
            String line="";
            //read CSV file header to skip it
            fileReader.readLine();
            System.out.println("right before line reader file loop");
            //while((line=fileReader.readLine())!=null){
                //get all tokens available in a line
                String[] token=line.split(",");
                if(token.length>0){
                    //create a new person object
                    //token 0 and 1 are the name and DOB
                    Person p= new Person(token[0],token[1]);
                    System.out.println("The person's name is "+p.name + ", and their DOB is " +p.DOB + ".");
                }

            //}
        }
        catch(Exception e){
            System.out.println("Error while reading csv");
        }
        finally{
            try{
                fileReader.close();
            }
            catch(IOException e){
                System.out.println("erro while closing file reader");
            }
        }


    }
    //followed this tutioral https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/


}
