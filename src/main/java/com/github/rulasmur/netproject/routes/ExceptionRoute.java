package com.github.rulasmur.netproject.routes;

import com.github.rulasmur.netproject.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;

public class ExceptionRoute {
    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void handleNotFound(NoResultException e, Request request, Response response) {
        response.status(404);
        response.body("Resource not found");
    }

    public static void handleGeneral(Exception e, Request request, Response response) {
        log.error("Route Failed", e);
        response.status(500);
        response.body("Internal Server Error");
    }
    public static void handleBadJson(Exception e, Request request, Response response) {
        response.status(400);
        response.body("Bad Json");
    }
}
