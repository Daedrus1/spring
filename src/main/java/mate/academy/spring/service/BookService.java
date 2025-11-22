package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.dto.BookDto;
import mate.academy.spring.dto.CreateBookRequestDto;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    BookDto createBook(CreateBookRequestDto bookDto);
}
