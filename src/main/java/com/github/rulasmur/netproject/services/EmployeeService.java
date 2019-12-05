package com.github.rulasmur.netproject.services;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeService {

    public static void persist(Employee employee)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();

    }
    public static List<Employee> list()
    {
        return App.getEntityManager().createQuery("FROM Employee", Employee.class).getResultList();
    }
    public static Employee find(Long id)
    {
        return App.getEntityManager().find(Employee.class, id);
    }

    public static void delete(Long id)
    {
        EntityManager manager = App.getEntityManager();
        manager.getTransaction().begin();
        Employee emp = manager.find(Employee.class, id);
        manager.remove(emp);
        manager.getTransaction().commit();
    }
}
