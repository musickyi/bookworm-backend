package Dusigi.bookworm.domain.bookshelf.data.dto;

import io.lettuce.core.CompositeArgument;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BookDto {
    @NotBlank(message = "저자는 공백을 허용하지 않습니다.")
    String author;
    @NotBlank(message = "제목은 공백을 허용하지 않습니다.")
    String title;
    @NotBlank(message = "내용은 공백을 허용하지 않습니다.")
    String text;
    @NotBlank(message = "책장은 공백을 허용하지 않습니다.")
    String bookshelf;
}
