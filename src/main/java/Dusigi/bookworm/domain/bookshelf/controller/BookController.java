package Dusigi.bookworm.domain.bookshelf.controller;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookRequest) {
        Book createdBook = bookService.createBook(bookRequest);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return bookService.getBook(Long.valueOf(id))
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bookshelf/{bookshelf}")
    public ResponseEntity<List<BookshelfDto>> getTitlesAndIdsByBookshelf(@PathVariable String bookshelf) {
        List<BookshelfDto> bookshelfDtos = bookService.getTitlesAndIdByBookshelf(bookshelf);
        return new ResponseEntity<>(bookshelfDtos, HttpStatus.OK);
    }

    @PostMapping("/report/{id}")
    public ResponseEntity<Book> getReport(@PathVariable String id) {
        bookService.getReport(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}