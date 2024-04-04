package exceptions

import entities.Book

class BookIsAlreadyStored(val book: Book): Exception() {
    override val message: String = "[${book.title} by ${book.author} (${book.year})] " +
                                   "is already stored by library."
}