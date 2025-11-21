package mate.academy.spring.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import mate.academy.spring.model.Book;

public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book save(Book book) {
        try {
            if (book.getId() == null) {
                entityManager.persist(book);
                return book;
            }
            return entityManager.merge(book);

        } catch (Exception e) {
            throw new RuntimeException("Cannot save book: " + book, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return entityManager
                    .createQuery("FROM Book", Book.class)
                    .getResultList();

        } catch (Exception e) {
            throw new RuntimeException("Cannot fetch books", e);
        }
    }
}
