package guru.springframework.spring5weabpp.repositories;

import guru.springframework.spring5weabpp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
