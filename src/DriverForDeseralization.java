
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DriverForDeseralization {
    public static void main(String args[]) throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("personfile.txt"));
        Person personNew=(Person)in.readObject();
        System.out.println(personNew.name+personNew.age);

        in.close();

    }
}
