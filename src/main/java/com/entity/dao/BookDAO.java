package com.entity.dao;

import com.entity.Book;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.util.List;

@Data
@Component("bookdao")
public class BookDAO {
    @Autowired
    private SessionFactory sf;

    private Session session;

    @PostConstruct
    public void init(){
        this.session = sf.openSession();
        this.session.beginTransaction();
    }
    public List<Book> query(){
        return this.session.createQuery("from Book").list();
    }

    public void save(Book book){
        this.session.save(book);
        this.session.getTransaction().commit();
    }

    public int deleteById(int id){
        Query query = this.session.createQuery("delete from Book where id=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        this.session.getTransaction().commit();
        return result;
    }

    @PreDestroy
    public void destory(){

        this.session.close();
        this.sf.close();
    }
}
