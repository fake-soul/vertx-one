package com.techprimers.vertx;

//import sun.security.provider.certpath.Vertex;
import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

//        Route handler1 = router
//                .route("/hello")
//                .handler(routingContext -> {
//                    HttpServerResponse response = routingContext.response();
//                    response.setChunked(true);
//                    response.write("Hey Bharat 1");
//                    routingContext
//                            .vertx()
//                            .setTimer(5000, tid -> routingContext.next());
//                });
//
//        Route handler2 = router
//                .route("/hello")
//                .handler(routingContext -> {
//                    HttpServerResponse response = routingContext.response();
////                    response.setChunked(true);
//                    response.write("Hey Bharat 2");
//                    routingContext
//                            .vertx()
//                            .setTimer(5000, tid -> routingContext.next());
//                });
//
//        Route handler3 = router
//                .route("/hello")
//                .handler(routingContext -> {
//                    HttpServerResponse response = routingContext.response();
////                    response.setChunked(true);
//                    response.write("Hey Bharat 3");
//                    response.end("Lest's end this");
//                });
//

        Route handler1 = router
                .get("/hello")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Hey Bharat 1");
                    response.end("Ending this get");
                });

        Route handler2 = router
                .post("/hello")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Hey Bharat 1");
                    response.end("ending this post");
                });

        Route handler3 = router
                .get("/hello/:name")
                .handler(routingContext -> {
                    String name = routingContext.request().getParam("name");
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    response.write("Hey Bharat "+ name);
                    response.end("Ending this get");
                });




        httpServer
                .requestHandler(router::accept)
                 .listen(3000);

    }
}
