package com.example.demo.service;

import com.example.demo.dao.DemoDao;
import com.example.demo.model.Message;
import org.easymock.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest()
@RunWith(EasyMockRunner.class)
public class DemoServiceTest extends EasyMockSupport {

    @TestSubject
    DemoService demoService = new DemoServiceImpl();

    @Mock
    DemoDao demoDao;

    private List expectedResult;


    @Test
    public void hashMessage() throws NoSuchAlgorithmException {

        String expectedHash = "ab530a13e45914982b79f9b7e3fba994cfd1f3fb22f71cea1afbf02b460c6d1d";

        demoDao.insertHashedMessage(EasyMock.anyObject(Message.class));
        EasyMock.expectLastCall().andReturn(1);
        replayAll();

        String actualHash = demoService.hashMessage("message");
        assertEquals(expectedHash, actualHash);

        verifyAll();
    }

    @Test
    public void getMessageFromHash() throws NoSuchAlgorithmException {

        String hash = "hash";
        String expectedMessage = "message";

        demoDao.getMessageFromHash(hash);
        EasyMock.expectLastCall().andReturn(expectedMessage);
        replayAll();

        String actualMessage = demoService.getMessageFromHash(hash);
        assertEquals(expectedMessage, actualMessage);

        verifyAll();
    }
}