package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.easymock.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(EasyMockRunner.class)
public class DemoControllerTest extends EasyMockSupport {

    @TestSubject
    DemoController demoController = new DemoController();

    @Mock
    DemoService demoService;

    @Before
    public void setUp() {
    }

    @Test
    public void hashMessage() throws NoSuchAlgorithmException {

        String expectedHash = "hash";

        demoService.hashMessage(expectedHash);
        EasyMock.expectLastCall().andReturn(expectedHash);
        replayAll();

        String actualHash = demoController.hashMessage(expectedHash);
        assertEquals(expectedHash, actualHash);

        verifyAll();
    }

    @Test
    public void getMessageFromHash() throws NoSuchAlgorithmException {

        String hash = "hash";
        String expectedMessage = "message";

        demoService.getMessageFromHash(hash);
        EasyMock.expectLastCall().andReturn(expectedMessage);
        replayAll();

        String actualMessage = demoController.getMessageFromHash(hash);
        assertEquals(expectedMessage, actualMessage);

        verifyAll();
    }
}