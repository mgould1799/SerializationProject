

public class PersonDriver {

    public static void main(String[] args) throws Exception{

        System.out.println("I am in PersonDriver. This statement prints, so I do not get confused in which class I am testing.");
        Person bloop= new Person("Meagan","081098");

        bloop.serializaton(bloop);
        bloop.deserialization();

        System.out.println("before serialization");
        bloop.serializationCSV(bloop);
        System.out.println("before deserialization");
        bloop.deserializationCSV();
        System.out.println("after deserialization");
    }
}
