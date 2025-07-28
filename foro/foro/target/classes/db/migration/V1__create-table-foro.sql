CREATE TABLE foro (
    id bigint not null AUTO_INCREMENT PRIMARY KEY, -- Identificador único
    titulo VARCHAR(255) NOT NULL,      -- Título del tópico
    mensaje TEXT NOT NULL,             -- Mensaje del tópico
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP, -- Fecha de creación
    status ENUM('activo', 'cerrado', 'pendiente') DEFAULT 'activo', -- Estado del tópico
    autor VARCHAR(100) NOT NULL,       -- Autor del tópico
    curso VARCHAR(100) NOT NULL        -- Curso relacionado
);