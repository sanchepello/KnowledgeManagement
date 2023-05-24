package com.example.knowledgemanagement;

public class Card {
    String login;
    String title;
    String content;

    Card() {    }

    Card(String login, String title, String content) {
        this.login = login;
        this.title = title;
        this.content = content;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getLogin() {
        return login;
    }

    public String getTitle() {
        return title;
    }
}
