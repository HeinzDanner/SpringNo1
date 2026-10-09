package de.heinzdanner.springno1.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Notiz mit ID " + id + " nicht gefunden");
    }
}
