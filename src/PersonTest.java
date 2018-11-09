import org.junit.Before;
import org.junit.Test;

class PersonTest {

    static Person bloop=null;
    static Person random=null;

    @Before
    public static void setUp() throws Exception{
        bloop= new Person("Meagan","081098");
        random= new Person( "Bob","081098");
    }

    /**
     *
     * Test method for serializatoin
     */
    @Test
    public static void testSerializaton(){
        bloop.serializaton(bloop);

    }

    /**
     *
     * Test method for deserialization
     */
    @Test
    public static void testDeserialization(){
        bloop.deserialization();
    }

    /**
     *
     * Test for serializationCSV
     */
    @Test
    public static void testSerializationCSV(){
        bloop.serializationCSV(bloop);
        //random.serializationCSV(random);
    }

    /**
     * Test for deserializationCSV
     */
    @Test
    public static void testDeserializationCSV(){
        bloop.deserializationCSV();
    }

    /**
     * test for xmlS
     */
    @Test
    public static void testXmlS(){
        bloop.xmlS(bloop);

    }

    /**
     * test for xmlD
     */
    public static void testXmlD() {
        System.out.println(bloop.xmlD());
    }


    public static void main(String[] args) throws Exception{
        System.out.println("Doing JUnit Test");
        setUp();
        testSerializaton();
        testDeserialization();
        testSerializationCSV();
        testDeserializationCSV();
        testXmlS();
        testXmlD();


    }
}
