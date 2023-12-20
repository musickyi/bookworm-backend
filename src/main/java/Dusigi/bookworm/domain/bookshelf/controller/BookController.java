package Dusigi.bookworm.domain.bookshelf.controller;

import Dusigi.bookworm.domain.bookshelf.data.dto.response.BookDetailDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.request.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.response.BookshelfDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.response.MyBookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.response.NewBookDto;
import Dusigi.bookworm.domain.bookshelf.service.*;
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
    private final FindMyBookService findMyBookService;

    @PostMapping
    public ResponseEntity<NewBookDto> createBook(@RequestBody BookDto bookRequest) {
        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
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
    public ResponseEntity<Void> getReport(@PathVariable Long id) {
        reportService.getReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/my")
    public ResponseEntity<List<MyBookDto>> findMyBook(){
        return new ResponseEntity<>(findMyBookService.execute(), HttpStatus.OK);
    }

}