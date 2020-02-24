package xhemil.learn.App.service;

import xhemil.learn.App.model.Book;

import java.util.List;

public interface BookService {

    long save(Book book);

    Book get(long id);

    List<Book> getBooks();

    void update(long id, Book book);

    void delete(long id);
}
