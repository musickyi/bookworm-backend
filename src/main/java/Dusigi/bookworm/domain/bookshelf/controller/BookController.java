package Dusigi.bookworm.domain.bookshelf.controller;

import Dusigi.bookworm.domain.bookshelf.data.dto.BookDetailDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.service.BookDetailService;
import Dusigi.bookworm.domain.bookshelf.service.BookService;
import Dusigi.bookworm.domain.bookshelf.service.BookshelfService;
import Dusigi.bookworm.domain.bookshelf.service.ReportService;
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
    private final BookshelfService bookshelfService;
    private final ReportService reportService;
    private final BookDetailService bookDetailService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookRequest) {
        Book createdBook = bookService.createBook(bookRequest);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

   @GetMapping("/{id}")
    public ResponseEntity<BookDetailDto> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookDetailService.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/bookshelf/{bookshelf}")
    public ResponseEntity<List<BookshelfDto>> getTitlesAndIdsByBookshelf(@PathVariable String bookshelf) {
        List<BookshelfDto> bookshelfDtos = bookshelfService.getBooksByBookshelf(bookshelf);
        return new ResponseEntity<>(bookshelfDtos, HttpStatus.OK);
    }

    @PatchMapping("/report/{id}")
    public ResponseEntity<Book> getReport(@PathVariable Long id) {
        reportService.getReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}