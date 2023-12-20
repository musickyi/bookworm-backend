package Dusigi.bookworm.domain.ai.service.impl;

import Dusigi.bookworm.domain.ai.presentation.data.response.BookResponse;
import Dusigi.bookworm.domain.ai.service.ConnectionService;
import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

import static Dusigi.bookworm.domain.bookshelf.data.entity.QBook.book;

@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {

    private final static String URI = "http://localhost:8000/test";

    private final WebClient webClient;
    private final JPAQueryFactory queryFactory;

    @Override
    public String execute() {
        Flux<String> response = webClient.post()
                .uri(URI)
                .header(HttpHeaders.CONTENT_TYPE)
                .bodyValue(hi().stream()
                        .map(book -> new BookResponse(Math.toIntExact(book.getId()), book.getText()))
                        .collect(Collectors.toList()))
                .retrieve()
                .bodyToFlux(String.class);
        return response.blockFirst();
    }

    private List<Book> hi() {
        return queryFactory
                .selectFrom(book)
                .where(book.report.goe(3))
                .fetch();
    }
}
