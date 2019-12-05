package com.github.rulasmur.netproject.routes;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Invoice;
import com.github.rulasmur.netproject.services.InvoiceService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class InvoiceRoute {

    public static Object find(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Invoice invoice = InvoiceService.find(Long.valueOf(req.params(":id")));
        return new Gson().toJson(invoice);
    }

    public static Object list(Request req, Response res) throws Exception {
        res.type(App.JSON);
        List<Invoice> invoice = InvoiceService.list();
        return new Gson().toJsonTree(invoice);
    }

    public static Object persist(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Invoice invoice = new Gson().fromJson(req.body(), Invoice.class);
        InvoiceService.persist(invoice);
        return "";
    }
    public static Object delete(Request req, Response res) throws Exception {
        InvoiceService.delete(Long.valueOf(req.params(":id")));
        return "";
    }
}
