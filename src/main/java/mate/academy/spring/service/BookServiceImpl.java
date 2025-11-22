package mate.academy.spring.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.spring.dto.BookDto;
import mate.academy.spring.dto.CreateBookRequestDto;
import mate.academy.spring.mapper.BookMapper;
import mate.academy.spring.model.Book;
import mate.academy.spring.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found: id=" + id));
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto createBook(CreateBookRequestDto bookDto) {
        Book book = bookMapper.toModel(bookDto);
        return bookMapper.toDto(bookRepository.save(book));
    }
}
