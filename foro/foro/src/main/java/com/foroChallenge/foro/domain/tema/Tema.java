package com.foroChallenge.foro.domain.tema;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "foro")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = new Date();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.activo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String curso;

    public Tema() {}

    public Tema(DatosTema datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.status = datos.status() != null ? Status.valueOf(datos.status()) : Status.activo;
        this.fechaCreacion = new Date(); // se asigna automáticamente
    }

    public void desactivarTema() {this.status = Status.cerrado;
    }

    public void actualizarDatos(DatosActualizarTema datosActualizarTema) {

        if (datosActualizarTema.id() != null) {
            this.id = datosActualizarTema.id();
        }
        if (datosActualizarTema.autor() != null) {
            this.autor = datosActualizarTema.autor();
        }
        if (datosActualizarTema.curso() != null) {
            this.curso = datosActualizarTema.curso();
        }
        if (datosActualizarTema.mensaje() != null) {
            this.mensaje = datosActualizarTema.mensaje();
        }
        if (datosActualizarTema.titulo() != null) {
            this.titulo = datosActualizarTema.titulo();
        }

        if (datosActualizarTema.status() != null) {
            this.status = datosActualizarTema.status();
        }
    }

    // Enum interno para el campo status
    public enum Status {
        activo, cerrado, pendiente
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }

    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public Date getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public String getAutor() { return autor; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getCurso() { return curso; }

    public void setCurso(String curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "Foro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", curso='" + curso + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
