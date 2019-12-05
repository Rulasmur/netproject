package com.github.rulasmur.netproject.services;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientService {

    public static void add(Client client)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();

    }
    public static List<Client> list()
    {
        return App.getEntityManager().createQuery("FROM Client", Client.class).getResultList();
    }
    public static Client find(Long id)
    {
        return App.getEntityManager().find(Client.class, id);
    }

    public static void delete(Long id)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        Client emp = manager.find(Client.class, id);
        manager.remove(emp);
        manager.getTransaction().commit();
    }
}
