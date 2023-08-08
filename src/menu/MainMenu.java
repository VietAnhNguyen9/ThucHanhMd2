package menu;

import manager.StudentManager;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        StudentManager studentManager = new StudentManager();
        ArrangeMenu arrangeMenu = new ArrangeMenu();
        do {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file ");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println(" Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.displayListStudent();
                    break;
                case 2:
                    studentManager.addStudent();
                    break;
                case 3:
                    studentManager.updateStudent();
                    break;
                case 4:
                    studentManager.deleteStudent();
                    break;
                case 5:
                    arrangeMenu.arrangeMenu();
                    break;
                case 8:
                    System.exit(8);
            }
        }while (true);
    }
}
