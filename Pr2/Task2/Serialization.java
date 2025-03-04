import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String password; 

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Password: " + (password != null ? password : "[Dont is saved]"));
    }
}

public class Serialization {
    private static final String FILE_NAME = "person.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Person person = new Person(name, age, password);
        saveToFile(person);
        System.out.println("Object is saved!\n");

        Person restoredPerson = loadFromFile();
        if (restoredPerson != null) {
            System.out.println("Restored object:");
            restoredPerson.display();
        }
    }

    private static void saveToFile(Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}