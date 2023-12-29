public class Book {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}

// Novel.java
public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, int yearOfPublication, String genre) {
        super(title, author, yearOfPublication);
        this.genre = genre;
    }

    public void displayInformation() {
        System.out.println("Novel Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year of Publication: " + getYearOfPublication());
        System.out.println("Genre: " + genre);
    }
}

// Textbook.java
public class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int yearOfPublication, String subject) {
        super(title, author, yearOfPublication);
        this.subject = subject;
    }

    public void displayInformation() {
        System.out.println("Textbook Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Year of Publication: " + getYearOfPublication());
        System.out.println("Subject: " + subject);
    }
}

// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Book removed from the library: " + book.getTitle());
    }

    public void listAllBooks() {
        System.out.println("Books currently in the library:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}

// LibraryUser.java
public interface LibraryUser {
    void borrowBook(Book book);
    void returnBook(Book book);
}

// Student.java
public class Student implements LibraryUser {
    private String studentId;
    private String name;
    private LibraryCard libraryCard;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.libraryCard = new LibraryCard();
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println(name + " (Student) is borrowing the book: " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println(name + " (Student) is returning the book: " + book.getTitle());
    }
}

// Teacher.java
public class Teacher implements LibraryUser {
    private String employeeId;
    private String name;
    private LibraryCard libraryCard;

    public Teacher(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
        this.libraryCard = new LibraryCard();
    }

    @Override
    public void borrowBook(Book book) {
        System.out.println(name + " (Teacher) is borrowing the book: " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println(name + " (Teacher) is returning the book: " + book.getTitle());
    }
}

// LibraryCard.java
public class LibraryCard {
    private int cardNumber;

    public LibraryCard() {
        // Generate a unique card number (you can implement your logic here)
        this.cardNumber = generateCardNumber();
    }

    private int generateCardNumber() {
        // Implement your logic to generate a unique card number
        return (int) (Math.random() * 100000);
    }

    public int getCardNumber() {
        return cardNumber;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Novel novel = new Novel("Novel 1", "Author", 2000, "Comedy");
        Textbook textbook = new Textbook("Introduction to Java", "mootez", 2023, "Programming");

        library.addBook(novel);
        library.addBook(textbook);
        library.listAllBooks();

        Student student = new Student("S1", "souilem");
        Teacher teacher = new Teacher("T1", "hachem");

        student.borrowBook(novel);
        teacher.borrowBook(textbook);

        student.returnBook(novel);
        teacher.returnBook(textbook);
    }
}
