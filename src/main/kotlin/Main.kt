//make regex that, if contains numbers and special characters ask again the name nof the user
fun containsInvalid(username: String): Boolean {
    val regex = Regex("^[0-9!?#$%^&*()_=+-,<.>/{}' ]")
    //use contain match to check if the username is integer, if it has then looped again
    return regex.containsMatchIn(username)
}

// println("Want to end the program? Y/N")
fun continueProgram(): Boolean {
    while (true) {
        println("Want to end the program? Y/N")
        val options = readln()
        val uppercase = options.uppercase()
        return if (uppercase != "Y" && uppercase != "N") {
            println("Please input right options")
            continue
        } else if (uppercase == "N") {
            false
        } else {
            true
        }
    }
}

fun main() {
    val library = Library()
    var username: String?
    var options: String
    val oldBooks = listOf(
        Book("The Great Gatsby", "F. Scott Fitzgerald", "12345"),
        Book("Pride and Prejudice", "Jane Austen", "978-0141439518"),
        Book("Sense and Sensibility", "Jane Austen", "978-0141439662"),
        Book("1984", "George Orwell", "978-0451524935"),
        Book("Animal Farm", "George Orwell", "978-0451526342")
    )
    for (book in oldBooks) {
        library.addBook(book)
    }
    //library.listOfBooks()
    println("Welcome to digital Library")
    println("Log in")


    while (true) {
        println("Enter username")
        username = readlnOrNull()
        if (username.isNullOrEmpty()) {
            println("Please input valid username")
        } else if (containsInvalid(username)) {
            println("Please input valid username")
        } else {
            println("Welcome to the digital Library, $username!")
            break
        }
    }
    while (true) {
        println(" ")
        println("1. Find Book")
        println("2. Find Author")
        println("3. Find International Standard Book Number ")
        println("4. Add Book")
        println("5. Lists of Book")
        println("6. Exit")
        val input = readlnOrNull()
        when (input) {
            "1" -> {
                println("Title of the Book: ")
                val title = readln()
                val foundBook = library.findTheBook(title)
                if (foundBook.isEmpty()) {
                    println("No found titled '$title'.")
                } else {
                    println("Book found titled '$title'.")
                    foundBook.forEachIndexed { index, book ->
                        println("${index + 1}. ${book.title} by ${book.author} ${book.isbn}")
                    }
                }
                if (continueProgram()) {
                    break
                } else {
                    continue
                }
            }

            "2" -> {
                println("Author of the Book: ")
                val author = readln()
                val foundAuthor = library.findTheAuthor(author)
                if (foundAuthor.isEmpty()) {
                    println("Author '${author}' can't be found")
                } else {
                    println("Author '${author}' is found")
                    foundAuthor.forEachIndexed { index, book ->
                        println("${index + 1}. ${book.author} of ${book.title}")
                    }
                }
                if (continueProgram()) {
                    break
                } else {
                    continue
                }
            }

            "3" -> {
                println("International Standard Book Number: ")
                val number = readln()
                val foundNumber = library.findTheISBN(number)
                if (foundNumber.isEmpty()) {
                    println("ISBN can't be found")
                } else {
                    println("ISBN is found")
                    foundNumber.forEachIndexed { index, book ->
                        println("${index + 1}. ${book.isbn} titled ${book.title} by ${book.author}")
                    }
                }
                if (continueProgram()) {
                    break
                } else {
                    continue
                }
            }
            // maghimo ug tagsa tagsa para sa (Book(title,author,isbn))
            "4" -> {
                //println("Add book: ")
                println("Enter Title of the book: ")
                val addTitle = readln()
                println("Enter Author of the book: ")
                val addAuthor = readln()
                println("Enter ISBN of the book: ")
                val addIsbn = readln()
                library.addBook(Book(addTitle, addAuthor, addIsbn))
                if (continueProgram()) {
                    break
                } else {
                    continue
                }
            }

            "5" -> {
                library.listOfBooks()
                if (continueProgram()) {
                    break
                } else {
                    continue
                }
            }

            "6" -> {
                println("Exiting program")
                break
            }

            else -> {
                println("\nPlease enter options ranging 1 - 6")

            }
        }
    }
}
