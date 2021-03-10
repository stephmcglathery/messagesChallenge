package com.example.demo.controller;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpEntity<String> httpEntity;
    HttpHeaders headers = new HttpHeaders();


    @Test
    public void hashMessage() {

        httpEntity = new HttpEntity<>("Message", headers);
        ResponseEntity<String> actualResponse = restTemplate.exchange(
                createURLWithPort("/demo/messages"),
                HttpMethod.POST, httpEntity, String.class);

        String hash = actualResponse.getBody();

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertNotNull(hash);
    }

    @Test
    public void getMessageFromHash() {

        String hash = "2f77668a9dfbf8d5848b9eeb4a7145ca94c6ed9236e4a773f6dcafa5132b2f91";
        String url = "/demo/messages/" + hash;

        httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> actualResponse = restTemplate.exchange(
                createURLWithPort(url),
                HttpMethod.GET, httpEntity, String.class);

        String message = actualResponse.getBody();

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertNotNull(message);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
