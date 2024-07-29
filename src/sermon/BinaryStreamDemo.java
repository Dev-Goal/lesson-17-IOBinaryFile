package sermon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryStreamDemo {
    public static void main(String[] args) throws IOException{
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Phuc", 23));
        personList.add(new Person("Hao", 25));
        personList.add(new Person("Quang", 23));
        String filename = "src/sermon/person.txt";
        ObjectOutputStream oos;
        ObjectInputStream ois;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/sermon/person.txt"));
            oos.writeObject(personList);
            System.out.println("Đối tượng đã được lưu trữ thành công vào file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
            List<Person> outputPersonList = (List<Person>) ois.readObject();
            System.out.println("Đối tượng đã được đọc từ file " + filename + ":");
            for (Person person : outputPersonList) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
