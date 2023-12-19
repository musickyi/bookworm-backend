package Dusigi.bookworm.domain.bookshelf.service.Impl;

import Dusigi.bookworm.domain.bookshelf.data.dto.response.MyBookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import Dusigi.bookworm.domain.bookshelf.data.repository.BookRepository;
import Dusigi.bookworm.domain.bookshelf.mapper.BookMapper;
import Dusigi.bookworm.domain.bookshelf.service.FindMyBookService;
import Dusigi.bookworm.global.util.MemberUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class FindMyBookServiceImpl implements FindMyBookService {

    private final BookRepository bookRepository;
    private final MemberUtil memberUtil;
    private final BookMapper bookMapper;

    @Override
    public List<MyBookDto> execute() {
        List<Book> books = bookRepository.findBooksByMember(memberUtil.currentMember());
        List<MyBookDto> bookDtos = new ArrayList<>();
        for (Book book:books){
            bookDtos.add(bookMapper.bookToMyBookDto(book));
        }

        return bookDtos;
    }
}
