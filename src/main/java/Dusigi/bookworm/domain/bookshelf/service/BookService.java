package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(BookDto bookRequest);
    Optional<Book> getBook(Long id);
    List<BookshelfDto> getTitlesAndIdByBookshelf(String bookshelf);
    void getReport(Long id);
}
