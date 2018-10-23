import java.io.*;
import  java.io.FileOutputStream;

public class DriverForSeralization {

    public static void main(String[] args) throws Exception{

        Person person= new Person();

        FileOutputStream output= new FileOutputStream("personfile.txt");
        ObjectOutputStream out= new ObjectOutputStream(output);

        out.writeObject(person);
        out.flush();
        System.out.println("done");

    }
}
