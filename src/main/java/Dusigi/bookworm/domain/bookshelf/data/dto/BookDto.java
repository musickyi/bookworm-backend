package Dusigi.bookworm.domain.bookshelf.data.dto;

import io.lettuce.core.CompositeArgument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookDto {
    String author;
    String title;
    String text;
    String bookshelf;
    Integer report;
}
