package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookDetailDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;


public interface BookService {
    Book createBook(BookDto bookRequest);
}
