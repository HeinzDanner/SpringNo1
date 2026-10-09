package de.heinzdanner.springno1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("messages")
public class Message {

    private String id;
    private String name;
    private String message;

    // Leerer Konstruktor: braucht Spring/Jackson, um JSON in ein Objekt umzuwandeln
    public Message() {
    }

    public Message(String id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}