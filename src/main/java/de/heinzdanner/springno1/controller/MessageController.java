package de.heinzdanner.springno1.controller;

import de.heinzdanner.springno1.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final List<Message> messages = new ArrayList<>();

    // Ein paar Beispieldaten zum Testen
    public MessageController() {
        messages.add(new Message("1", "John", "Hallo zusammen"));
        messages.add(new Message("2", "Anna", "Spring macht Spaß"));
    }

    // GET /api/messages
    @GetMapping
    public List<Message> getAll() {
        return messages;
    }

    // POST /api/messages
    @PostMapping
    public Message create(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    // DELETE /api/messages/1  (Bonus)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean removed = messages.removeIf(m -> m.getId().equals(id));

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}