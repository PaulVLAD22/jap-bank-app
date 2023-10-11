package com.luxoft.bankapp.domain;

public class Email {
    private Client client;
    private String from;
    private String to;

    // generate getters and setters

    public Email(Client client, String from, String to) {
        this.client = client;
        this.from = from;
        this.to = to;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
