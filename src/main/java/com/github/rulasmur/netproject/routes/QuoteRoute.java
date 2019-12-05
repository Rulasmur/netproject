package com.github.rulasmur.netproject.routes;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Quote;
import com.github.rulasmur.netproject.services.QuoteService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class QuoteRoute {

    public static Object find(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Quote quote = QuoteService.find(Long.valueOf(req.params(":id")));
        return new Gson().toJson(quote);
    }

    public static Object list(Request req, Response res) throws Exception {
        res.type(App.JSON);
        List<Quote> quote = QuoteService.list();
        return new Gson().toJsonTree(quote);
    }

    public static Object persist(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Quote quote = new Gson().fromJson(req.body(), Quote.class);
        QuoteService.persist(quote);
        return "";
    }
    public static Object delete(Request req, Response res) throws Exception {
        QuoteService.delete(Long.valueOf(req.params(":id")));
        return "";
    }
}
