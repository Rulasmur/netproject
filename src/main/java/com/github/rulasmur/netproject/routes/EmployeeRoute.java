package com.github.rulasmur.netproject.routes;

import com.github.rulasmur.netproject.App;
import com.github.rulasmur.netproject.models.Employee;
import com.github.rulasmur.netproject.services.EmployeeService;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class EmployeeRoute {

    public static Object find(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Employee employee = EmployeeService.find(Long.valueOf(req.params(":id")));
        return new Gson().toJson(employee);
    }

    public static Object list(Request req, Response res) throws Exception {
        res.type(App.JSON);
        List<Employee> employee = EmployeeService.list();
        return new Gson().toJsonTree(employee);
    }

    public static Object persist(Request req, Response res) throws Exception {
        res.type(App.JSON);
        Employee employee = new Gson().fromJson(req.body(), Employee.class);
        EmployeeService.persist(employee);
        return "";
    }
    public static Object delete(Request req, Response res) throws Exception {
        EmployeeService.delete(Long.valueOf(req.params(":id")));
        return "";
    }
}
