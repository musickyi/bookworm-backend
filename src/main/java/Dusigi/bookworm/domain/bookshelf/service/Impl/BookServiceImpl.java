package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.service.BookService;
import Dusigi.bookworm.domain.bookshelf.data.dto.request.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(BookDto bookRequest) {
        Book book = Book.builder()
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .text(bookRequest.getText())
                .bookshelf(bookRequest.getBookshelf())
                .report(0)
                .build();

        return bookRepository.save(book);
    }
}
