import java.util.Arrays;
import java.util.List;

class Animal {
    private int age;
    private String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void speak(){
        System.out.println("None");
    }
}

class Dog extends Animal{
    String breed;

    public Dog(int age, String name, String breed) {
        super(age, name);
        this.breed = breed;
    }

    @Override
    public void speak(){
        System.out.println("Waf Waf");
    }
}

class Cat extends Animal{
    String breed;

    public Cat(int age, String name, String breed) {
        super(age, name);
        this.breed = breed;
    }

    @Override
    public void speak(){
        System.out.println("Meow");
    }
}

class Test{
    public static void main(String[] args) {
        Animal dog = new Dog(12, "George", "Haski");
        Animal cat = new Cat(8,"Tom", "Ji");

        List<Animal> pets = Arrays.asList(dog,cat);

        for (Animal d: pets) {
            d.speak();
        }
    }
}

