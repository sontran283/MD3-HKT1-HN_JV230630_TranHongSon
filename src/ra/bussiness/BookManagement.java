package ra.bussiness;

import java.util.Scanner;

public class BookManagement {
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;
    private static int idCount = 1;

    public BookManagement() {
        this.bookId = idCount++;
        this.bookStatus = true;
    }

    public BookManagement(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner) {
        System.out.println("*** Nhap thong tin ***");

        System.out.println("Moi nhap ten sach: ");
        while (true) {
            this.bookName = scanner.nextLine();
            if (!this.bookName.isEmpty()) {
                break;
            } else {
                System.out.println("Ten sach khong duoc de trong, moi nhap lai");
            }
        }

        System.out.println("Moi nhap ten tac gia: ");
        while (true) {
            this.author = scanner.nextLine();
            if (!this.author.isEmpty()) {
                break;
            } else {
                System.out.println("Ten tac gia khong duoc de trong, moi nhap lai");
            }
        }

        System.out.println("Moi nhap mo ta cuon sach: ");
        while (true) {
            this.description = scanner.nextLine();
            if (this.description.length() < 10) {
                System.out.println("Mo ta phai co it nhat 10 ki tu, moi nhap lai: ");
            } else {
                break;
            }
        }

        System.out.print("Moi nhap gia nhap khau: ");
        this.importPrice = Double.parseDouble(scanner.nextLine());
        while (this.importPrice <= 0) {
            System.out.println("Gia nhap khau phai lon hon 0");
            System.out.print("Moi nhap importPrice: ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Nhap gia xuat khau: ");
        this.exportPrice = Double.parseDouble(scanner.nextLine());
        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("Gia xuat khau phai toi thieu bang 1/2 gia nhap khau");
            System.out.print("Moi nhap exportPrice: ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
        }

        System.out.println("Tinh toan loi nhuan (interest): ");
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void displayData() {
        System.out.println("*** Thong tin tat ca sach trong thu vien ***");
        System.out.println(
                "BookManagement {" +
                        ", bookId=" + bookId + "\n" +
                        ", bookName='" + bookName + '\'' + "\n" +
                        ", author='" + author + '\'' + "\n" +
                        ", description='" + description + '\'' + "\n" +
                        ", importPrice=" + importPrice + "\n" +
                        ", exportPrice=" + exportPrice + "\n" +
                        ", interest=" + interest + "\n" +
                        ", bookStatus=" + bookStatus + "\n" +
                        '}'
        );
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
