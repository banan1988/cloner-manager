package pl.com.b2d.cloner.manager.index;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Created by Łukasz Kucharski<kucharskilukasz88@gmail.com> on 09.10.2017.
 */
public class IndexController {

    public static Route index = (Request request, Response response) -> "Hello World";

}
