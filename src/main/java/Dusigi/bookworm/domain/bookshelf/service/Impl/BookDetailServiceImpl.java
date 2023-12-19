package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.dto.request.BookDetailDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.service.BookDetailService;
import Dusigi.bookworm.global.error.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDetailServiceImpl implements BookDetailService {
    private final BookRepository bookRepository;
    @Override
    public BookDetailDto getBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new GlobalException("존재하지 않는 책입니다.", HttpStatus.NOT_FOUND));
        return new BookDetailDto(book.getAuthor(), book.getTitle(), book.getText());
    }
}
