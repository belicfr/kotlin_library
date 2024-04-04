package entities

data class Book(var title: String,
                var author: String,
                var year: String,
                private var isBorrowed: Boolean = false) {

    fun isAvailable(): Boolean = this.isBorrowed

    fun toggleBorrowStatus() {
        this.isBorrowed = !this.isBorrowed
    }
}