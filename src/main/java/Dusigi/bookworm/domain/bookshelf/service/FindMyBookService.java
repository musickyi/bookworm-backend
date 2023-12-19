package Dusigi.bookworm.domain.bookshelf.service;

import Dusigi.bookworm.domain.bookshelf.data.dto.response.MyBookDto;

import java.util.List;

public interface FindMyBookService {

    public List<MyBookDto> execute();

}
