package com.github.rulasmur.netproject;


import com.github.rulasmur.netproject.routes.*;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import spark.Spark;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class App  {

    public static String JSON = "application/json";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.github.rulasmur.netproject");


    public App() throws Exception {
        EntityManager manager = getEntityManager();
        if(!manager.isOpen())
        {
            throw new Exception("Fast Fail. No DB Connection");
        }
        manager.getTransaction().begin();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('1', 'CEO')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('2', 'CFO')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('3', 'Area Manager')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('4', 'Team Manager')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('5', 'Team Leader')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.position (id, name) VALUES ('6', 'Packer')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.person (id, address, contactNumber, firstname, lastname) VALUES ('1', 'my address', '27841234569', 'Huey', 'Micheals')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.person (id, address, contactNumber, firstname, lastname) VALUES ('2', 'another address', '27841234569', 'John', 'Doe')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.employee (employeeNumber, id, position_id) VALUES ('1', '1', '1')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.employee (employeeNumber, id, position_id) VALUES ('2', '2', '4')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.invoice (id, person_id) VALUES ('1', '1')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.invoice (id, person_id) VALUES ('2', '2')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.quote (id, person_id) VALUES ('1', '1')").executeUpdate();
        manager.createNativeQuery("INSERT INTO ecms.quote (id, person_id) VALUES ('2', '2')").executeUpdate();

        manager.getTransaction().commit();
    }

    public static void main(String[] args) throws Exception {
        new App();

        Spark.get("/employee", EmployeeRoute::list);
        Spark.post("/employee", JSON, EmployeeRoute::persist);
        Spark.get("/employee/:id", EmployeeRoute::find);
        Spark.delete("/employee/:id", EmployeeRoute::delete);

        Spark.get("/client", ClientRoute::list);
        Spark.post("/client", JSON, ClientRoute::persist);
        Spark.get("/client/:id", ClientRoute::find);
        Spark.delete("/client/:id", ClientRoute::delete);

        Spark.get("/quote", QuoteRoute::list);
        Spark.post("/quote", JSON, QuoteRoute::persist);
        Spark.get("/quote/:id", QuoteRoute::find);
        Spark.delete("/quote/:id", QuoteRoute::delete);

        Spark.get("/invoice", InvoiceRoute::list);
        Spark.post("/invoice", JSON, InvoiceRoute::persist);
        Spark.get("/invoice/:id", InvoiceRoute::find);
        Spark.delete("/invoice/:id", InvoiceRoute::delete);

        Spark.exception(NoResultException.class, ExceptionRoute::handleNotFound);
        Spark.exception(MalformedJsonException.class, ExceptionRoute::handleBadJson);
        Spark.exception(JsonSyntaxException.class, ExceptionRoute::handleBadJson);
        Spark.exception(Exception.class, ExceptionRoute::handleGeneral);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
