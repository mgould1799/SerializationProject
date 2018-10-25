import java.io.*;


public class Person implements Serializable {

    private String name;
    private String DOB;

    public Person(String DOB, String name){
        this.DOB=DOB;
        this.name=name;
    }



    public void setDOB(String DOB){
        this.DOB=DOB;
    }
    public void setName(String name){
        this.name=name;
    }

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
