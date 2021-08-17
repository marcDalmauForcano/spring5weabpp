package guru.springframework.spring5weabpp.bootstrap;

import guru.springframework.spring5weabpp.model.Author;
import guru.springframework.spring5weabpp.model.Book;
import guru.springframework.spring5weabpp.model.Publisher;
import guru.springframework.spring5weabpp.repositories.AuthorRepository;
import guru.springframework.spring5weabpp.repositories.BookRepository;
import guru.springframework.spring5weabpp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setAdressLine1("rue du cloitre");
        publisher.setCity("Bruxelles");
        publisher.setZip("3080");
        publisherRepository.save(publisher);



        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","393939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in boostrap");
        System.out.println("Number of books " + bookRepository.count());

/*        Publisher pub1 = new Publisher("rue du cloitre","Bruxelles","Bruxelles-Capitale",3080);
        publisherRepository.save(pub1);*/


        System.out.println("Number of publishers " + publisherRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());

    }
}
