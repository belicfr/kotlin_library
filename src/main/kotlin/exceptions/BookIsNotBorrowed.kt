package exceptions

import entities.Book

class BookIsNotBorrowed(val book: Book): Exception() {
    override val message: String = "[${book.title} by ${book.author} (${book.year})] " +
                                   "is not borrowed."
}