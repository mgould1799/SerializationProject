import java.io.*;


public class Person implements Serializable {

    //attributes
    private String name;
    private String DOB; //Date of Birth

    //constructor
    public Person(String DOB, String name){
        this.DOB=DOB;
        this.name=name;
    }


    //setter methods
    public void setDOB(String DOB){
        this.DOB=DOB;
    }
    public void setName(String name){
        this.name=name;
    }


    //this method is to serialize an object and store it in a file call personfile.ser
    //it takes an input of a person object and prints that the object has been serialized
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

    //this method is deserialize a person object from the file personfile.ser
    //the method prints weather is has been deserialized and prints out the persons name and DOB
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

    public static void main(String[] args) throws Exception{
        Person bloop= new Person("081098","Meagan");

        serializaton(bloop);
        deserialization();
    }

}
