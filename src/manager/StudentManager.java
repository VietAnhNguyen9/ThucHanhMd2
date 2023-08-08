package manager;

import model.Student;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    Scanner scanner = new Scanner(System.in);
    List<Student>listStudent = new ArrayList<>();
    boolean check = false;
    public void writeData(List<Student> listStudent) throws IOException {
        FileOutputStream fos = new FileOutputStream("student.csv");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.listStudent);
        oos.close();
        oos.close();
    }
    public void readData() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("student.avg");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.readObject();
        ois.close();
        fis.close();
    }
    public void addStudent() {
        System.out.println("Nhập mã sinh viên: ");
        String code = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình: ");
        double score = Double.parseDouble(scanner.nextLine());
        listStudent.add(new Student(code, name, age, gender, address, score));
        System.out.println("Thành công!");

    }


    public void displayListStudent() {
        for (Student student:listStudent
             ) {
            System.out.println(student);
        }
    }
    public void updateStudent() {
        System.out.println("Nhập mã sinh viên : ");
        String code = scanner.nextLine();
        for (int i = 0; i < listStudent.size();i++) {
            if (listStudent.get(i).getCodeStudent().equals(code)) {
                check = true;
                System.out.println("Nhập mã sinh viên mới: ");
                listStudent.get(i).setCodeStudent(scanner.nextLine());
                System.out.println("Nhập tên: ");
                listStudent.get(i).setName(scanner.nextLine());
                System.out.println("Nhập tuổi: ");
                listStudent.get(i).setAge(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập giới tính: ");
                listStudent.get(i).setGender(scanner.nextLine());
                System.out.println("Nhập địa chỉ: ");
                listStudent.get(i).setAddress(scanner.nextLine());
                System.out.println("Nhập điểm trung bình: ");
                listStudent.get(i).setMediumScore(Double.parseDouble(scanner.nextLine()));
                System.out.println("Chỉnh sửa thành công !");
            }
        }
        if (!check) {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }
    public void deleteStudent() {
        System.out.println("Nhập mã sinh viên : ");
        String code = scanner.nextLine();
        for (int i = 0; i < listStudent.size();i++) {
            if (listStudent.get(i).getCodeStudent().equals(code)) {
                check = true;
                System.out.println("Bạn có thực sự muốn xóa không?");
                System.out.println("Nhập Y để xóa: ");
                String test = scanner.nextLine();
                if (test.equals("Y")){
                    listStudent.remove(i);
                    System.out.println("Xóa thành công !");
                }

            }
        }
        if (!check) {
            System.out.println("Không tìm được sinh viên với mã sinh viên trên !");
        }
    }
    public void pointAvgIncreased() {
        for (int i = 0; i < listStudent.size() - 1;i++) {
            for (int j = listStudent.size() - 1;j > i;j--) {
                if (listStudent.get(j).getMediumScore() < listStudent.get(j-1).getMediumScore()) {
                    double temp = listStudent.get(j).getMediumScore();
                    listStudent.get(j).setMediumScore(listStudent.get(j-1).getMediumScore());
                    listStudent.get(j-1).setMediumScore(temp);
                }
            }
        }
        for (Student student:listStudent
             ) {
            System.out.println(student);
        }
    }
    public void pointAvgDecrease() {
        for (int i = 0; i < listStudent.size() - 1;i++) {
            for (int j = listStudent.size() - 1;j > i;j--) {
                if (listStudent.get(j).getMediumScore() > listStudent.get(j-1).getMediumScore()) {
                    double temp = listStudent.get(j).getMediumScore();
                    listStudent.get(j).setMediumScore(listStudent.get(j-1).getMediumScore());
                    listStudent.get(j-1).setMediumScore(temp);
                }
            }
        }
        for (Student student:listStudent
        ) {
            System.out.println(student);
        }
    }
}
