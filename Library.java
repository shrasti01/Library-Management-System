import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    // Add Book
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    // View Books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println("ID: " + b.id +
                    ", Title: " + b.title +
                    ", Author: " + b.author +
                    ", Issued: " + b.isIssued);
        }
    }

    // Add Student
    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
        System.out.println("Student added successfully.");
    }

    // Issue Book
    public void issueBook(int bookId, int studentId) {

        Book selectedBook = null;
        Student selectedStudent = null;

        for (Book b : books) {
            if (b.id == bookId) {
                selectedBook = b;
                break;
            }
        }

        for (Student s : students) {
            if (s.id == studentId) {
                selectedStudent = s;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found.");
            return;
        }

        if (selectedStudent == null) {
            System.out.println("Student not found.");
            return;
        }

        if (selectedBook.isIssued) {
            System.out.println("Book already issued.");
            return;
        }

        selectedBook.isIssued = true;
        selectedStudent.booksIssued++;
        System.out.println("Book issued successfully.");
    }

    // Return Book
    public void returnBook(int bookId, int studentId) {

        for (Book b : books) {
            if (b.id == bookId && b.isIssued) {
                b.isIssued = false;

                for (Student s : students) {
                    if (s.id == studentId) {
                        s.booksIssued--;
                        break;
                    }
                }

                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Invalid return attempt.");
    }
}
