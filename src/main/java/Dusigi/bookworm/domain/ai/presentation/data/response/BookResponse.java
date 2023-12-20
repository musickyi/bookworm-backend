package Dusigi.bookworm.domain.ai.presentation.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Integer bookId;
    private String content;
}
