package de.heinzdanner.springno1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404, wenn eine Ressource nicht existiert
    @ExceptionHandler(NoteNotFoundException.class)
    public ProblemDetail handleNotFound(NoteNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Nicht gefunden");
        return problem;
    }

    // 400 bei Validierungsfehlern (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Ungültige Eingabe");
        problem.setTitle("Validierungsfehler");
        problem.setProperty("errors", errors);
        return problem;
    }

    // 500 als Auffangnetz für alles andere
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleAll(Exception ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR, "Ein unerwarteter Fehler ist aufgetreten");
        problem.setTitle("Serverfehler");
        return problem;
    }
}