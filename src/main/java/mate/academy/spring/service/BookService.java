package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
