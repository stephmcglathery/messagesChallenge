package com.example.demo.dao;

import com.example.demo.model.Message;

public interface DemoDao {

    int insertHashedMessage(Message message);

    String getMessageFromHash(String hash);
}
