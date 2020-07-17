package ca.cpr.hmem.router;

import ca.cpr.hmem.handler.SampleHandlerClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class SampleRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(SampleHandlerClass sampleHandlerClass){

        return RouterFunctions
                .route(RequestPredicates.GET("/functions/flux").and(accept(MediaType.APPLICATION_JSON))
                ,sampleHandlerClass::fluxRequest);
    }
}

