package ca.cpr.hmem.handlerTest;

import ca.cpr.hmeventmanagement.HmEventManagementApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HmEventManagementApplication.class)
@AutoConfigureWebTestClient
public class SampleHandlerClassTest {

    @Autowired
    private WebTestClient client;

    @Test
    @WithMockUser
    public void testIfOkReturned(){

        Flux<Integer> fluxRespone = client.get().uri("/functions/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();
        StepVerifier.create(fluxRespone)
                .expectSubscription()
                .expectNext(1)
                .expectNext(2)
                .verifyComplete();
    }

}
