package Dusigi.bookworm.domain.bookshelf.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookshelfDto {
    private Long id;
    private String title;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookshelfDto() {
        this.id = id;
        this.title = title;
    }
}
