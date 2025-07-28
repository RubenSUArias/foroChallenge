package com.foroChallenge.foro.domain.tema;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTema (@NotNull Long id, String titulo,
    String mensaje,
    String autor,
    String curso,
    Tema.Status status){
}
