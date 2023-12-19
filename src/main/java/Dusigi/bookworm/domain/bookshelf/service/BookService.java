package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.request.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.response.NewBookDto;


public interface BookService {
    NewBookDto createBook(BookDto bookRequest);
}
