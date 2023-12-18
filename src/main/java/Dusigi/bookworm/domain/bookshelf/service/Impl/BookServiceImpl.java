package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.service.BookService;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.global.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BookshelfDto> getTitlesAndIdByBookshelf(String bookshelf) {
        List<Book> books = bookRepository.findTitlesAndIdByBookshelf(bookshelf);
        List<BookshelfDto> bookshelfDtos = new ArrayList<>();

        for (Book book : books) {
            BookshelfDto bookshelfDto = new BookshelfDto();
            bookshelfDto.setId(book.getId());
            bookshelfDto.setTitle(book.getTitle());
            bookshelfDtos.add(bookshelfDto);
        }

        return bookshelfDtos;
    }

    @Override
    public void getReport(Long id) {
        Book book = bookRepository.findById(id)
                        .orElseThrow(() -> new GlobalException("존재하지 않는 책입니다.", HttpStatus.BAD_REQUEST));
        book.setReport(book.getReport() + 1);
        bookRepository.save(book);
    }
}
