package exceptions

import entities.Book

class LibraryDoesNotHaveBook(val book: Book): Exception() {
    override val message: String = "The library does not longer have " +
                                   "[${book.title} by ${book.author} (${book.year})]."
}