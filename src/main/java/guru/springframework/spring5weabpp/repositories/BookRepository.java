package guru.springframework.spring5weabpp.repositories;

import guru.springframework.spring5weabpp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
