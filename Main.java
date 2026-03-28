import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(bookId, title, author);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    library.addStudent(studentId, name);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();
                    System.out.print("Enter Student ID: ");
                    int issueStudentId = sc.nextInt();
                    library.issueBook(issueBookId, issueStudentId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter Student ID: ");
                    int returnStudentId = sc.nextInt();
                    library.returnBook(returnBookId, returnStudentId);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
