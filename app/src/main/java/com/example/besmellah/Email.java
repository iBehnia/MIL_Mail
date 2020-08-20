package com.example.besmellah;

import java.util.ArrayList;

/**
 * Created by Seyyed Parsa Neshaei on 7/31/20
 * All Rights Reserved
 */
public class Email {
    private int id = 0;
    private String sender = "";
    private String subject = "";
    private String body = "";
    private String imageURL = "";

    public Email() {
    }

    public Email(int id, String sender, String subject, String body, String imageURL) {
        this.id = id;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
        this.imageURL = imageURL;
    }

    static ArrayList<Email> allEmails = new ArrayList<>();

    public static ArrayList<Email> getAllEmails() {

        return allEmails;
    }

    public static void setAllEmails(ArrayList<Email> newAllEmails) {
        allEmails = newAllEmails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getImageURL() {
        return imageURL;
    }
}