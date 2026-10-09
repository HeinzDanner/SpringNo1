package de.heinzdanner.springno1.controller;

import de.heinzdanner.springno1.model.Message;
import de.heinzdanner.springno1.repository.MessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageRepository repository;

    // Constructor Injection: Spring übergibt das Repository automatisch
    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    // GET /api/messages
    @GetMapping
    public List<Message> getAll() {
        return repository.findAll();
    }

    // GET /api/messages/1
    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable String id) {
        Optional<Message> message = repository.findById(id);

        if (message.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(message.get());
    }

    // POST /api/messages
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message create(@RequestBody Message message) {
        return repository.save(message);
    }

    // PUT /api/messages/1
    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable String id, @RequestBody Message message) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        message.setId(id);
        Message updated = repository.save(message);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/messages/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}