package Dusigi.bookworm.domain.bookshelf.data.repository;

import Dusigi.bookworm.domain.bookshelf.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByBookshelf(String bookshelf);
}
