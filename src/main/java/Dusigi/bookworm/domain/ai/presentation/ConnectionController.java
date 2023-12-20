package Dusigi.bookworm.domain.ai.presentation;

import Dusigi.bookworm.domain.ai.presentation.data.request.BookDetail;
import Dusigi.bookworm.domain.ai.service.ConnectionService;
import Dusigi.bookworm.domain.ai.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hi")
public class ConnectionController {

    private final ConnectionService connectionService;
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<Void> connection() {
        connectionService.execute();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> reply(@RequestBody List<BookDetail> list) {
        replyService.execute(list);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
