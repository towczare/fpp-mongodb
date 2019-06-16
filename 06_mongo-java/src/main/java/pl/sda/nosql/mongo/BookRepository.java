package pl.sda.nosql.mongo;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
}
