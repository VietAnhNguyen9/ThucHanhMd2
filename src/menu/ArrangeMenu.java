package menu;

import manager.StudentManager;

import java.util.Scanner;

public class ArrangeMenu {
    StudentManager studentManager = new StudentManager();
    int choice;
    public void arrangeMenu() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1.Sắp sếp điểm trung bình tăng dần");
            System.out.println("2.Sắp xếp điểm trung bình giảm dần");
            System.out.println("3.Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManager.pointAvgIncreased();
                    break;
                case 2:
                    studentManager.pointAvgDecrease();
                    break;
                case 3:
                    System.exit(3);
            }
        }while (true);
    }


}
