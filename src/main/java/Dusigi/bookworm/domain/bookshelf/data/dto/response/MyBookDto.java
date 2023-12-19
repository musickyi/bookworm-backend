package Dusigi.bookworm.domain.bookshelf.data.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyBookDto {

    private Long id;
    private String title;

}
