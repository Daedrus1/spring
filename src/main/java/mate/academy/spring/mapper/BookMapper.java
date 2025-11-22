package mate.academy.spring.mapper;

import mate.academy.spring.dto.BookDto;
import mate.academy.spring.dto.CreateBookRequestDto;
import mate.academy.spring.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto dto);

    void updateBookFromDto(CreateBookRequestDto dto, @MappingTarget Book book);
}
