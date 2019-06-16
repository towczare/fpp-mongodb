package pl.sda.nosql.mongo;

import java.util.List;

public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findOne(String id) {
        return null;
    }

    public void save(Book book) {

    }

    public Book update(String id, Book book) {
        return null;
    }
}
