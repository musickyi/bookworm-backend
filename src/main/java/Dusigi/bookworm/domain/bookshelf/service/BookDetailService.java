package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.response.BookDetailDto;

public interface BookDetailService {
    BookDetailDto getBook(Long id);
}
