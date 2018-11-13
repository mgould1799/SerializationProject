import org.junit.Before;
import org.junit.Test;



public class PersonTest {


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
        public static void testSBinary(){
            bloop.sBinary(bloop);

        }

        /**
         *
         * Test method for deserialization
         */
        @Test
        public static void testDBinary(){

            bloop.dBinary().toString();
        }

        /**
         *
         * Test for serializationCSV
         */
        @Test
        public static void testSCSV(){
            bloop.sCSV(bloop);
            //random.serializationCSV(random);
        }

        /**
         * Test for deserializationCSV
         */
        @Test
        public static void testDCSV(){

            bloop.dCSV().toString();
        }

        /**
         * test for xmlS
         */
        @Test
        public static void testSXML(){
            bloop.sXML(bloop);

        }

        /**
         * test for xmlD
         */
        public static void testDXML() {
            System.out.println(bloop.dXML().toString());
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