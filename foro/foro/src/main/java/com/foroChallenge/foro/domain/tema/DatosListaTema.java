package com.foroChallenge.foro.domain.tema;

import java.util.Date;

public record DatosListaTema(
        String titulo,
        String mensaje,
        String autor,
        String curso,
        Tema.Status status
) {
    public DatosListaTema(Tema tema) {
        this(
                tema.getTitulo(),
                tema.getMensaje(),
                tema.getAutor(),
                tema.getCurso(),
                tema.getStatus()
        );
    }
}
