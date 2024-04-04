package entities

import exceptions.BookIsAlreadyBorrowed
import exceptions.BookIsNotBorrowed
import exceptions.LibraryDoesNotHaveBook

data class User(var id: Int = lastIdDefined + 1,
                var name: String,
                var borrowedBooks: MutableList<Book> = arrayListOf()) {

    companion object {
        private var lastIdDefined: Int = 0

        fun setLastIdDefined(id: Int) {
            lastIdDefined = id
        }

        fun createUser(name: String): User {
            val user: User = User(name = name)
            lastIdDefined++

            return user
        }
    }

    fun borrowBook(book: Book) {
        if (!Library.hasBook(book)) {
            throw LibraryDoesNotHaveBook(book)
        }

        if (book.isAvailable()) {
            throw BookIsAlreadyBorrowed(book)
        }

        book.toggleBorrowStatus()
        this.borrowedBooks.add(book)
    }

    fun returnBook(book: Book) {
        if (!Library.hasBook(book)) {
            throw LibraryDoesNotHaveBook(book)
        }

        if (!book.isAvailable()) {
            throw BookIsNotBorrowed(book)
        }

        book.toggleBorrowStatus()
        this.borrowedBooks.remove(book)
    }
}
