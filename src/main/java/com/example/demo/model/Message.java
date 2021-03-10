package com.example.demo.model;

public class Message {

    private String message;
    private String hash;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
