package entities

import exceptions.BookIsAlreadyBorrowed
import exceptions.BookIsNotBorrowed
import exceptions.LibraryDoesNotHaveBook
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest {
    private val book: Book = Book(
        "I love this book",
        "belicfr",
        "1945")

    private val notStoredBook: Book = Book(
        "I'm not stored...",
        "Mary",
        "2000")

    private val user: User = User.createUser("Mary")

    @BeforeEach
    fun setUp() {
        Library.clearBooks()
        Library.addBook(this.book)
    }

    @Test
    fun `Borrow a stored book that is available`() {
        assertDoesNotThrow {
            -> this.user.borrowBook(this.book)
        }
    }

    @Test
    fun `Borrow a stored book that is unavailable`() {
        this.user.borrowBook(this.book)

        org.junit.jupiter.api.assertThrows<BookIsAlreadyBorrowed> {
            -> this.user.borrowBook(this.book)
        }
    }

    @Test
    fun `Borrow a non stored book`() {
        org.junit.jupiter.api.assertThrows<LibraryDoesNotHaveBook> {
            -> this.user.borrowBook(this.notStoredBook)
        }
    }

    @Test
    fun `Return a stored and borrowed book`() {
        this.user.borrowBook(this.book)

        assertDoesNotThrow {
            -> this.user.returnBook(this.book)
        }
    }

    @Test
    fun `Return a stored and non borrowed book`() {
        assertThrows<BookIsNotBorrowed> {
            -> this.user.returnBook(this.book)
        }
    }

    @Test
    fun `Return a non stored and non borrowed book`() {
        assertThrows<LibraryDoesNotHaveBook> {
            -> this.user.returnBook(this.notStoredBook)
        }
    }
}