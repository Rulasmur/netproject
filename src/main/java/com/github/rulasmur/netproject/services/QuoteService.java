package com.github.rulasmur.netproject.services;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Quote;

import javax.persistence.EntityManager;
import java.util.List;

public class QuoteService {

    public static void persist(Quote quote)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(quote);
        manager.getTransaction().commit();

    }
    public static List<Quote> list()
    {
        return App.getEntityManager().createQuery("FROM Quote", Quote.class).getResultList();

    }
    public static Quote find(Long id)
    {
        return App.getEntityManager().find(Quote.class, id);
    }

    public static void delete(Long id)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        Quote quote = manager.find(Quote.class, id);
        manager.remove(quote);
        manager.getTransaction().commit();
    }
}
