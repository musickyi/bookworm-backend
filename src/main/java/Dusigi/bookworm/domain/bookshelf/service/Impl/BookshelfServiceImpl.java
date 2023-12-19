package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.service.BookshelfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookshelfServiceImpl implements BookshelfService {
    private final BookRepository bookRepository;
    @Override
    public List<BookshelfDto> getBooksByBookshelf(String bookshelf) {
        List<Book> books = bookRepository.findBooksByBookshelf(bookshelf);
        List<BookshelfDto> bookshelfDtos = new ArrayList<>();

        for (Book book : books) {
            BookshelfDto bookshelfDto = new BookshelfDto();
            bookshelfDto.setId(book.getId());
            bookshelfDto.setTitle(book.getTitle());
            bookshelfDtos.add(bookshelfDto);
        }

        return bookshelfDtos;
    }
}
