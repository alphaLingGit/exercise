package com.example;

import io.vertx.core.*;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VertxApp extends AbstractVerticle {

    private static final Integer PORT = 8090;

    private static final Vertx vertx = Vertx.vertx(new VertxOptions().setEventLoopPoolSize(20).setWorkerPoolSize(20));

    public static void main(String[] args) {
//        createHttpServer(vertx);
        // 基于 Verticle 的方式
        vertx.deployVerticle(new VertxApp());
    }

    private static void createHttpServer() {
        /*vertx.createHttpServer().requestHandler(ctx -> {
            String param = ctx.getParam("param");
            log.info("param：{}", param);
            log.info("absoluteURI: {}", ctx.absoluteURI());
            log.info("uri:{}", ctx.uri());
            ctx.response().putHeader("content-type", "text/plain").end("success");
        }).listen(PORT, "0.0.0.0", res -> {
            if (res.succeeded()) {
                log.info("vert.x success to listen： " + PORT);
            } else {
                log.info("vert.x fail:" + res.cause().getMessage());
            }
        });*/

        Router router = Router.router(VertxApp.vertx);

//        router.route().handler(VertxApp::handler);
        // 阻塞式处理器以并行的方式执行
//        router.route().blockingHandler(VertxApp::handler, false);
        // 自定义 Worker 线程执行
        router.route().handler(VertxApp::workerExecutorHandler);

        VertxApp.vertx.createHttpServer().requestHandler(router).listen(PORT, "0.0.0.0", res -> {
            if (res.succeeded()) {
                log.info("vert.x success to listen： " + PORT);
            } else {
                log.info("vert.x fail:" + res.cause().getMessage());
            }
        });
    }

    private static void handler(RoutingContext ctx) {
        HttpServerRequest request = ctx.request();
        String param = request.getParam("param");
        log.info("method: {}", request.method());
        log.info("param：{}", param);

        ctx.request().bodyHandler(h -> Optional.ofNullable(h).ifPresent(c -> log.info("接口json参数：{}", c.toString())));

        log.info("absoluteURI: {}", request.absoluteURI());
        log.info("uri:{}", request.uri());
        log.info("thread: {}", Thread.currentThread().getName());

        ctx.response().putHeader("content-type", "text/plain").end("success");
    }

    private static void workerExecutorHandler(RoutingContext ctx) {
        WorkerExecutor executor = vertx.createSharedWorkerExecutor("my-worker-pool", 10, 2, TimeUnit.SECONDS);
        executor.executeBlocking(h -> {
            log.info("thread1: {}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            h.complete("success");
        }, false, res -> {
            log.info("thread2: {}", Thread.currentThread().getName());
            ctx.response().putHeader("content-type", "text/plain").end(res.result().toString());
            executor.close();
        });
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        createHttpServer();
    }
}
