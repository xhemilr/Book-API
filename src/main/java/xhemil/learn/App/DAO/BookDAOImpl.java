package xhemil.learn.App.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xhemil.learn.App.model.Book;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    @Override
    public Book get(long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> getBooks() {
        List bookList = sessionFactory.getCurrentSession().createQuery("from Book").list();
        return bookList;
    }

    @Override
    public void update(long id, Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book oldBook = session.byId(Book.class).load(id);
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.byId(Book.class).load(id);
        session.delete(book);
    }
}
