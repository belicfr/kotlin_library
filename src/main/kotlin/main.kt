import entities.Book
import entities.Library
import entities.User

fun main() {

    val book: Book = Book("L'étranger", "Albert Camus", "1942")

    println(Library.getBooks())
    Library.addBook(book)
    println(Library.getBooks())
    Library.removeBook(book)
    println(Library.getBooks())

}