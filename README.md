Library System
Book Class: Represents a book in the library.
Member Class: Represents a member of the library.
Library Class: Manages the books and members, and provides methods for borrowing and returning books
Explanation
Book Class:

title: The title of the book.
author: The author of the book.
isBorrowed: Boolean indicating if the book is currently borrowed.
borrowBook(): Marks the book as borrowed.
returnBook(): Marks the book as returned.
toString(): Returns a string representation of the book.
Member Class:

name: The name of the member.
borrowedBooks: A list of books currently borrowed by the member.
borrowBook(Book book): Borrows a book if it is not already borrowed.
returnBook(Book book): Returns a borrowed book.
toString(): Returns a string representation of the member.
Library Class:

books: A list of books in the library.
members: A list of registered members.
addBook(Book book): Adds a new book to the library.
registerMember(Member member): Registers a new member.
displayBooks(): Displays all books in the library.
displayMembers(): Displays all members of the library.
findBook(String title): Finds and returns a book by title.
findMember(String name): Finds and returns a member by name.
LibrarySystem Class:

The main class that contains the main method to run the library system.
Provides a menu for the user to interact with the library system.
Uses a loop to repeatedly display the menu and process user input until the user chooses to exit.

Additional features:

Book Availability: Check how many copies of a book are available.
Member Borrowing Limit: Limit the number of books a member can borrow.
Book Details Update: Update book details (title, author).
Member Details Update: Update member details.
Search Books by Author: Find books by a specific author.
List of Borrowed Books: Display the list of all borrowed books.
Due Date for Borrowed Books: Add a due date feature for borrowed books.
