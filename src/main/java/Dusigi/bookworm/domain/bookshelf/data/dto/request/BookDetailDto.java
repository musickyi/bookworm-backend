package Dusigi.bookworm.domain.bookshelf.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDto {
    @NotBlank(message = "저자는 공백을 허용하지 않습니다.")
    private String author;
    @NotBlank(message = "제목은 공백을 허용하지 않습니다.")
    private String title;
    @NotBlank(message = "내용은 공백을 허용하지 않습니다.")
    private String text;
}
