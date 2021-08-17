package guru.springframework.spring5weabpp.repositories;

import guru.springframework.spring5weabpp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository  extends CrudRepository<Publisher,Long> {
}
