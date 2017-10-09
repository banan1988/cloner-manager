package pl.com.b2d.cloner.manager;

import pl.com.b2d.cloner.manager.index.IndexController;

import static spark.Spark.*;

/**
 * Created by Łukasz Kucharski<kucharskilukasz88@gmail.com> on 09.10.2017.
 */
public class Application {

    public static void main(final String[] args) {
        // Configure Server
        port(4567);

        // Set up before-filters (called before each get/post)
        before((req, res) -> {
            String path = req.pathInfo();
            if (path.endsWith("/"))
                res.redirect(path.substring(0, path.length() - 1));
        });

        // Set up routes
        get("/hello", (req, res) -> "Hello World");
        get("/", IndexController.index);

        // Set up after-filters (called after each get/post)
        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
        });
    }

}
