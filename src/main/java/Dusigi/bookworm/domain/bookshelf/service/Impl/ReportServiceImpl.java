package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.service.ReportService;
import Dusigi.bookworm.global.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final BookRepository bookRepository;
    @Override
    public void getReport(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new GlobalException("존재하지 않는 책입니다.", HttpStatus.NOT_FOUND));
        book.setReport(book.getReport() + 1);
        bookRepository.save(book);
    }
}
