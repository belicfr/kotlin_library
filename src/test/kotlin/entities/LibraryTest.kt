package entities

import exceptions.BookIsAlreadyStored
import exceptions.LibraryDoesNotHaveBook
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LibraryTest {

    @BeforeEach
    fun setUp() {
        Library.clearBooks()
    }

    @Test
    fun `Add a book to library that library does not have`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        val filledBooksList: MutableList<Book> = arrayListOf(defaultBook)

        Library.addBook(defaultBook)

        assertEquals(Library.getBooks(), filledBooksList)
    }

    @Test
    fun `Add a boot to library that library already has`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        Library.addBook(defaultBook)

        org.junit.jupiter.api.assertThrows<BookIsAlreadyStored> {
            -> Library.addBook(defaultBook)
        }
    }

    @Test
    fun `If library has a stored book`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        Library.addBook(defaultBook)

        assertTrue(Library.hasBook(defaultBook))
    }

    @Test
    fun `If library has not a non stored book`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        assertFalse(Library.hasBook(defaultBook))
    }

    @Test
    fun `Remove a book from the library that has it`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        val emptyBookList: MutableList<Book> = arrayListOf()

        Library.addBook(defaultBook)
        Library.removeBook(defaultBook)

        assertEquals(emptyBookList, Library.getBooks())
    }

    @Test
    fun `Remove a book that the library has not`() {
        val defaultBook: Book = Book(
            "A good book!",
            "Mary",
            "2004")

        org.junit.jupiter.api.assertThrows<LibraryDoesNotHaveBook> {
            -> Library.removeBook(defaultBook)
        }
    }

    @Test
    fun `Clear the library books list`() {
        val emptyBooksList: MutableList<Book> = arrayListOf()

        Library.clearBooks()

        assertEquals(emptyBooksList, Library.getBooks())
    }

    @Test
    fun `Get a valid list of available books`() {
        val book1: Book = Book("Book 1", "John", "2010")
        val book2: Book = Book("Book 2", "Doe", "1999")

        val validList: MutableList<Book> = arrayListOf()
    }

    @Test
    fun `Get an invalid list of available books`() {
        // TODO
    }
}