package ra.bussiness;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BookManagement[] bookManagements = new BookManagement[100];
    static int currentIndex = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("****** Menu BookManagement ******");
            System.out.println("Chon 1_ Nhap so luong sach them moi va nhap thong tin cho tung cuon sach");
            System.out.println("Chon 2_ Hien thi thong tin tat ca sach trong thu vien");
            System.out.println("Chon 3_ Sap xep sach theo loi nhuan tang dan");
            System.out.println("Chon 4_ Xoa sach theo ma sach");
            System.out.println("Chon 5_ Tim kiem tuong doi sach theo ten sach va mo ta");
            System.out.println("Chon 6_ Thay doi thong tin sach theo ma sach");
            System.out.println("Chon 7_ Thoat");
            System.out.println("*** Moi nhap lua chon cua ban ***");
            int choise = Integer.parseInt(scanner.nextLine());
            handleMenu(choise);
        }
    }

    private static void handleMenu(int choise) {
        switch (choise) {
            case 1:
                Main.addCountBook();
                break;
            case 2:
                Main.allBook();
                break;
            case 3:
                Main.subBook();
                break;
            case 4:
                Main.deleteBook();
                break;
            case 5:
                Main.searchBook();
                break;
            case 6:
                Main.editBook();
                break;
            case 7:
                System.out.println("Thoat");
                break;
            default:
                System.exit(1);
        }
    }

    private static void addCountBook() {
        System.out.println("Nhap so luong sach can them: ");
        int addCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addCount; i++) {
            System.out.println("Them sach lan thu: " + i + 1);
            ra.bussiness.BookManagement bookManagement = new BookManagement();
            bookManagement.inputData(scanner);
            bookManagements[currentIndex++] = bookManagement;
            System.out.println("Da them thanh cong!");
        }
    }

    private static void allBook() {
        System.out.println("Danh sach tat ca thu vien sach: ");
        for (int i = 0; i < currentIndex; i++) {
            bookManagements[i].displayData();
        }
    }

    private static void subBook() {
        // tham so 1 la mang can sap xep bookManagements
        // tham so 2 chi muc bat dau cua phan tu sap xep 0
        // tham so 3 chi muc ket thuc cua phan tu sap xep currentIndex
        // tham so 4 la mot bieu thuc lamdba b1, b2
        Arrays.sort(bookManagements, 0, currentIndex, (b1, b2) ->
                // so sanh hai doi tuong trong mang
                Float.compare(b1.getInterest(), b2.getInterest()));
        System.out.println("Sap xep sach theo loi nhuan tang dan thanh cong!");
    }

    private static void deleteBook() {
        System.out.println("Hay nhap id cua cuon sach can xoa: ");
        int deletedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookId() == deletedId) {
                for (int j = i; j < currentIndex; j++) {
                    bookManagements[j] = bookManagements[j + 1];
                }
                currentIndex--;
            }
        }
        System.out.println("Khong tim thay cuon sach voi id " + deletedId);
    }

    private static void searchBook() {
        System.out.print("Nhap tu khoa tim kiem: ");
        String text = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookName().contains(text) || bookManagements[i].getDescription().contains(text)) {
                System.out.println("Cuon sach " + (i + 1) + ":");
                bookManagements[i].displayData();
                System.out.println("");
                check = true;
            }
        }
        if (!check) {
            System.out.println("Khong tim thay cuon sach nao voi tu khoa " + "\'" + text + "\'");
        }
    }

    private static void editBook() {
        System.out.println("hay nhap id cua cuon sach can sua: ");
        int editedId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (bookManagements[i].getBookId() == editedId) {
                System.out.println("thong tin cua cuon sach ma ban muon sua la: ");
                bookManagements[i].displayData();
                bookManagements[i].inputData(scanner);
                System.out.println("da cap nhat thong tin thanh cong!");
                return;
            }
        }
        System.out.println("khong tim thay cuon sach voi id " + editedId);
    }
}
