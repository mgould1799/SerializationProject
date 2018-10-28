import org.junit.Before;
import org.junit.Test;

class PeronTest{

    static Person bloop=null;

    @Before
    public static void setUp() throws Exception{
        bloop= new Person("Meagan","081098");
    }

    /**
     *
     * Test method for serializatoin
     */
    @Test
    public static void testSerializaton(){
        bloop.serializaton(bloop);
        System.out.println("It has been serializated.");

    }

    /**
     *
     * Test method for deserialization
     */
    @Test
    public static void testDeserialization(){
        bloop.deserialization();
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Doing JUnit Test");
        setUp();
        testSerializaton();
        testDeserialization();


    }
}
