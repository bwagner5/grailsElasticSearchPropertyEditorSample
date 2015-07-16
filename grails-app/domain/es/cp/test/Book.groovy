package es.cp.test

class Book {

    String name

    Date bookReleaseDate

    static constraints = {
        name nullable: false
    }
}
