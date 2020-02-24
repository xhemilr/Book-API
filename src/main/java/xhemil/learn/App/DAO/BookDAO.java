package xhemil.learn.App.DAO;

import xhemil.learn.App.model.Book;

import java.util.List;

public interface BookDAO {

    long save(Book book);

    Book get(long id);

    List<Book> getBooks();

    void update(long id, Book book);

    void delete(long id);
}
