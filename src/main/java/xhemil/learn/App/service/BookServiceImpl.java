package xhemil.learn.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xhemil.learn.App.DAO.BookDAO;
import xhemil.learn.App.model.Book;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public long save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public Book get(long id) {
        return bookDAO.get(id);
    }

    @Override
    public List<Book> getBooks() {
        return Collections.unmodifiableList(bookDAO.getBooks());
    }

    @Override
    public void update(long id, Book book) {
        bookDAO.update(id, book);
    }

    @Override
    public void delete(long id) {
        bookDAO.delete(id);
    }
}
