package pratice.practice_8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainPractice8 {
    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readDtaFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Phuc", "C05"));
        students.add(new Student("Hao", "C05"));
        String path = "src/pratice/practice_8/studentpractice8.txt";
        writeDataToFile(path, students);
        System.out.println("Dữ liệu đã đươợc ghi thành công vào file: " + path);
        List<Student> studentDataFromFile = readDtaFromFile(path);
        System.out.println("Dữ liệu đã đươợc đọc thành công từ file: " + path);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
}
