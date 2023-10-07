data class Book(val title: String, val author: String, val isbn: String)

class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun findTheBook(title: String): List<Book> {
        return books.filter { it.title.equals(title, ignoreCase = true) }
    }

    fun findTheAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun findTheISBN(isbn: String): List<Book> {
        return books.filter { it.isbn.equals(isbn, ignoreCase = true) }
    }

    fun addBook(book: Book) {
        books.add(book)
    }

    fun listOfBooks() {
        if (books.isEmpty()) {
            println("There is no books in the shelf")
        } else {
            println("List of Books in the shelf")
            books.forEachIndexed { index, book ->
                println("${index + 1}. ${book.title} by ${book.author} #code:${book.isbn}")
            }
        }
    }
}