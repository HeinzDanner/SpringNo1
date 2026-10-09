package de.heinzdanner.springno1.dto;

import jakarta.validation.constraints.NotBlank;

public record NoteDto(Long id, @NotBlank String text) {
}
