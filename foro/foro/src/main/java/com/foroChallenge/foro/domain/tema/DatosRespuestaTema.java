package com.foroChallenge.foro.domain.tema;

public record DatosRespuestaTema(Long id, String titulo,
                                 String mensaje,
                                 String autor,
                                 String curso,
                                 Tema.Status status){
}
