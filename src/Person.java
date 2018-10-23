import java.io.Serializable;




public class Person implements Serializable {

    String name="Bob";
    int age=10;



    public void setAge(int age){
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }

}
