package Dusigi.bookworm.domain.ai.service;

import Dusigi.bookworm.domain.ai.presentation.data.request.BookDetail;

import java.util.List;

public interface ReplyService {

    void execute(List<BookDetail> list);
}
