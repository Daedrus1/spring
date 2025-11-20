package mate.academy.spring.repository;

import java.util.List;
import mate.academy.spring.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
