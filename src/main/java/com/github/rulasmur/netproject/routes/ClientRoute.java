package com.github.rulasmur.netproject.routes;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Client;
import com.github.rulasmur.netproject.services.ClientService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class ClientRoute {

    public static Object find(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Client employee = ClientService.find(Long.valueOf(req.params(":id")));
        return new Gson().toJson(employee);
    }

    public static Object list(Request req, Response res) throws Exception {
        res.type(App.JSON);
        List<Client> employee = ClientService.list();
        return new Gson().toJsonTree(employee);
    }

    public static Object persist(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Client employee = new Gson().fromJson(req.body(), Client.class);
        ClientService.add(employee);
        return "";
    }
    public static Object delete(Request req, Response res) throws Exception {
        ClientService.delete(Long.valueOf(req.params(":id")));
        return "";
    }
}
