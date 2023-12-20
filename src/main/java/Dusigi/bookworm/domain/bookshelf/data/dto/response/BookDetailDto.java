package Dusigi.bookworm.domain.bookshelf.data.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDto {
    private Long id;
    private String author;
    private String title;
    private String text;
}
