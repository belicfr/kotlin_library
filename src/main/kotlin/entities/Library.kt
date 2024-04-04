package entities

import exceptions.BookIsAlreadyStored
import exceptions.LibraryDoesNotHaveBook

object Library {
    private var books: MutableList<Book> = arrayListOf()

    fun getBooks(): MutableList<Book> {
        return this.books
    }

    fun addBook(book: Book) {
        if (this.books.contains(book)) {
            throw BookIsAlreadyStored(book)
        }

        this.books.add(book)
    }

    fun hasBook(book: Book): Boolean {
        return this.books.contains(book)
    }

    fun removeBook(book: Book) {
        if (!this.books.contains(book)) {
            throw LibraryDoesNotHaveBook(book)
        }

        this.books.remove(book)
    }

    fun clearBooks() {
        this.books.clear()
    }

    fun getAvailableBooks(): MutableList<Book> {
        return this.books.filter { it.isAvailable() }
            .toMutableList()
    }
}