

public class PersonDriver {

    public static void main(String[] args) throws Exception{

        System.out.println("I am in PersonDriver. This statement prints, so I do not get confused in which class I am testing.");
        Person bloop= new Person("081098","Meagan");

        bloop.serializaton(bloop);
        bloop.deserialization();
    }
}
