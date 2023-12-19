package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;

import java.util.List;

public interface BookshelfService {
    List<BookshelfDto> getBooksByBookshelf(String bookshelf);
}
