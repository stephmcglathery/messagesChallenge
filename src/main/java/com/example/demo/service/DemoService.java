package com.example.demo.service;

import java.security.NoSuchAlgorithmException;

public interface DemoService {

    String hashMessage(String message) throws NoSuchAlgorithmException;

    String getMessageFromHash(String hashString);
}
