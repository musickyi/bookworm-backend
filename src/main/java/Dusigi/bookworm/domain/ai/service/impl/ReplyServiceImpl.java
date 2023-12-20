package Dusigi.bookworm.domain.ai.service.impl;

import Dusigi.bookworm.domain.ai.presentation.data.request.BookDetail;
import Dusigi.bookworm.domain.ai.service.ReplyService;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyServiceImpl implements ReplyService {

    private final BookRepository bookRepository;

    @Override
    public void execute(List<BookDetail> request) {
        log.info("Ai가 총 {}권 의 책을 지웠어요!", request.size());

        for (BookDetail bookDetail : request) {
            int bookId = bookDetail.getBookId();
            bookRepository.deleteById((long) bookId);
        }
    }
}