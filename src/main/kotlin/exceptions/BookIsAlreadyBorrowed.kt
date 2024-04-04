package exceptions

import entities.Book

class BookIsAlreadyBorrowed(val book: Book): Exception() {
    override val message: String = "[${book.title} by ${book.author} (${book.year})] " +
                                   "is already borrowed."
}