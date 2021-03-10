package com.example.demo.service;

import com.example.demo.dao.DemoDao;
import com.example.demo.model.Message;
import org.apache.log4j.Logger;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class DemoServiceImpl implements DemoService {

    private final static Logger log = Logger.getLogger(DemoServiceImpl.class);

    @Autowired
    DemoDao demoDao;

    public String hashMessage(String messageString) throws NoSuchAlgorithmException {

        log.debug("Attempting to save message/hash: " + messageString);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                messageString.getBytes(StandardCharsets.UTF_8));

        String hashString = new String(Hex.encode(hash));

        Message message = new Message();
        message.setMessage(messageString);
        message.setHash(hashString);

        int messageHashedInserted = demoDao.insertHashedMessage(message);
        log.debug("Message hashed inserted: " + messageHashedInserted);

        return hashString;
    }

    public String getMessageFromHash(String hashString) {

        log.debug("Attempting to get message from hash: " + hashString);

        String message = demoDao.getMessageFromHash(hashString);
        log.debug("Message found: " + message);

        return message;
    }
}