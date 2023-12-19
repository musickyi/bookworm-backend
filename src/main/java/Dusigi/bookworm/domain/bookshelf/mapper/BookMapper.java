package Dusigi.bookworm.domain.bookshelf.mapper;


import Dusigi.bookworm.domain.bookshelf.data.dto.response.MyBookDto;
import Dusigi.bookworm.domain.bookshelf.data.dto.response.NewBookDto;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public MyBookDto bookToMyBookDto(Book book){
        return MyBookDto.builder()
                .id(book.getId())
                .title(book.getTitle()).build();
    }

    public NewBookDto bookToNewBookDto(Book book){
        return NewBookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .text(book.getText())
                .bookshelf(book.getBookshelf())
                .build();
    }



}
