package Dusigi.bookworm.domain.bookshelf.data.repository;

import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findTitlesAndIdByBookshelf(String bookshelf);
}
