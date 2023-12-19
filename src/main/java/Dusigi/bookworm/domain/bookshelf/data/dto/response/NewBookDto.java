package Dusigi.bookworm.domain.bookshelf.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class NewBookDto {
    private Long id;
    private String author;
    private String title;
    private String text;
    private String bookshelf;


}
