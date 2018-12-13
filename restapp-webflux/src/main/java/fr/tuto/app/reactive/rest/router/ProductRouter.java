package fr.tuto.app.reactive.rest.router;

import fr.tuto.app.reactive.rest.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {


    @Bean
    public RouterFunction<ServerResponse> route(ProductHandler productHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/products")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), productHandler::getProduct);
    }
}
