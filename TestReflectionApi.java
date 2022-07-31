import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
    String name;
    int age;
    public Person(int age, String name){
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello " + getAge()+ " !");
    }

    public void sayAge(){
        System.out.println("You are " + getAge() + " years old");
    }
}

public class TestReflectionApi {
    public static void main(String[] args) {
        Class personClass = Person.class;

        Method[] methods = personClass.getMethods();
        for (Method method: methods) {
            System.out.println(method.getName() + " " + method.getReturnType());
        }

        System.out.println("--------------------------------");

        Field[] fields = personClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName());
        }

        System.out.println("--------------------------------");

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation: annotations) {
            if (annotation instanceof Autowired){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
