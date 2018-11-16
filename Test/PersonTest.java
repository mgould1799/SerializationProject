import org.junit.Before;
import org.junit.Test;



public class PersonTest {


        static Person bloop=null;

        @Before
        public static void setUp() throws Exception{
            bloop= new Person("Meagan",5);

        }

        /**
         *
         * Test method for serializatoin
         */
        @Test
        public static void testSBinary(){
            Person.serializationBinary(bloop,"personfile.ser");

        }

        /**
         *
         * Test method for deserialization
         */
        @Test
        public static void testDBinary(){

            Person.deserializationBinary("personfile.ser");
        }

        /**
         *
         * Test for serializationCSV
         */
        @Test
        public static void testSCSV(){
            Person.serializationCSV(bloop,"person.csv");
        }

        /**
         * Test for deserializationCSV
         */
        @Test
        public static void testDCSV(){

            Person.deserializationCSV("person.csv");
        }

        /**
         * test for xmlS
         */
        @Test
        public static void testSXML(){
            Person.serializationXML(bloop,"person.xml");

        }

        /**
         * test for xmlD
         */
        public static void testDXML() {
            System.out.println(Person.deserializationXML("person.xml").prettyString());
        }


        public static void main(String[] args) throws Exception{
            System.out.println("Doing JUnit Test");
            setUp();
            testSBinary();
            testDBinary();
            testSCSV();
            testDCSV();
            testSXML();
            testDXML();


        }


}