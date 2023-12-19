package Dusigi.bookworm.domain.bookshelf.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @NotBlank(message = "제목은 공백을 허용하지 않습니다.")
    String title;
    @NotBlank(message = "내용은 공백을 허용하지 않습니다.")
    String text;
    @NotBlank(message = "책장은 공백을 허용하지 않습니다.")
    String bookshelf;
}
