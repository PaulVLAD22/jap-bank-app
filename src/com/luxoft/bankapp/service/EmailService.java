package com.luxoft.bankapp.service;

import com.luxoft.bankapp.email.Email;
import com.luxoft.bankapp.generics.Queue;


public class EmailService {
    private Queue<Email> emailQueue;

    private Thread emailSenderThread;
    private boolean isRunning;

    public EmailService() {
        emailQueue = new Queue<>();
        isRunning = true;

        emailSenderThread = new Thread(this::sendEmails);
        emailSenderThread.start();
    }

    public void sendNotificationEmail(Email email) {
        emailQueue.add(email);
    }

}
