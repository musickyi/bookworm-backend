package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.dto.response.NewBookDto;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.mapper.BookMapper;
import Dusigi.bookworm.domain.bookshelf.service.BookService;
import Dusigi.bookworm.domain.bookshelf.data.dto.request.BookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final MemberUtil memberUtil;
    private final BookMapper bookMapper;


    @Override
    public NewBookDto createBook(BookDto bookRequest) {
        Book book = Book.builder()
                .author(memberUtil.currentNickName())
                .title(bookRequest.getTitle())
                .text(bookRequest.getText())
                .bookshelf(bookRequest.getBookshelf())
                .member(memberUtil.currentMember())
                .report(0)
                .build();

        return bookMapper.bookToNewBookDto(bookRepository.save(book));

    }
}
