package com.github.rulasmur.netproject.services;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Invoice;

import javax.persistence.EntityManager;
import java.util.List;

public class InvoiceService {

    public static void persist(Invoice invoice)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(invoice);
        manager.getTransaction().commit();

    }
    public static List<Invoice> list()
    {
        return App.getEntityManager().createQuery("FROM Invoice", Invoice.class).getResultList();

    }
    public static Invoice find(Long id)
    {
        return App.getEntityManager().find(Invoice.class, id);
    }

    public static void delete(Long id)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        Invoice invoice = manager.find(Invoice.class, id);
        manager.remove(invoice);
        manager.getTransaction().commit();
    }
}
