import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int copiesAvailable;
    private boolean isBorrowed;

    public Book(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void borrowBook() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
            System.out.println("Borrowed " + title);
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        copiesAvailable++;
        System.out.println("Returned " + title);
    }

    public void updateDetails(String newTitle, String newAuthor) {
        this.title = newTitle;
        this.author = newAuthor;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Copies Available: " + copiesAvailable;
    }
}

class Member {
    private String name;
    private int borrowLimit = 3;
    private ArrayList<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < borrowLimit && book.getCopiesAvailable() > 0) {
            borrowedBooks.add(book);
            book.borrowBook();
            System.out.println(name + " borrowed " + book.getTitle());
        } else if (borrowedBooks.size() >= borrowLimit) {
            System.out.println(name + " has reached the borrow limit.");
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println("You don't have " + book.getTitle() + " borrowed.");
        }
    }

    public void updateDetails(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Member Name: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }

    public void listBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }
}

class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added " + book.getTitle() + " by " + book.getAuthor());
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Registered member: " + member.getName());
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayMembers() {
        System.out.println("Library members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public Member findMember(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        System.out.println("Member not found.");
        return null;
    }

    public void updateBookDetails(String title, String newTitle, String newAuthor) {
        Book book = findBook(title);
        if (book != null) {
            book.updateDetails(newTitle, newAuthor);
            System.out.println("Updated book details.");
        }
    }

    public void updateMemberDetails(String name, String newName) {
        Member member = findMember(name);
        if (member != null) {
            member.updateDetails(newName);
            System.out.println("Updated member details.");
        }
    }

    public void searchBooksByAuthor(String author) {
        System.out.println("Books by " + author + ":");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    public void listBorrowedBooks() {
        System.out.println("List of all borrowed books:");
        for (Member member : members) {
            member.listBorrowedBooks();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Members");
            System.out.println("7. Update Book Details");
            System.out.println("8. Update Member Details");
            System.out.println("9. Search Books by Author");
            System.out.println("10. List Borrowed Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter number of copies available: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    library.addBook(new Book(title, author, copies));
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.registerMember(new Member(name));
                    break;
                case 3:
                    System.out.print("Enter member name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    Member member = library.findMember(name);
                    Book bookToBorrow = library.findBook(title);
                    if (member != null && bookToBorrow != null) {
                        member.borrowBook(bookToBorrow);
                    }
                    break;
                case 4:
                    System.out.print("Enter member name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    title = scanner.nextLine();
                    member = library.findMember(name);
                    Book bookToReturn = library.findBook(title);
                    if (member != null && bookToReturn != null) {
                        member.returnBook(bookToReturn);
                    }
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    library.displayMembers();
                    break;
                case 7:
                    System.out.print("Enter current book title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new book author: ");
                    String newAuthor = scanner.nextLine();
                    library.updateBookDetails(title, newTitle, newAuthor);
                    break;
                case 8:
                    System.out.print("Enter current member name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new member name: ");
                    String newName = scanner.nextLine();
                    library.updateMemberDetails(name, newName);
                    break;
                case 9:
                    System.out.print("Enter author name: ");
                    author = scanner.nextLine();
                    library.searchBooksByAuthor(author);
                    break;
                case 10:
                    library.listBorrowedBooks();
                    break;
                case 11:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}
