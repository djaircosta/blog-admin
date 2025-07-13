package br.com.aydconnection.blogadmin.errors;

import java.time.Instant; // Importe Instant em vez de LocalDateTime
import com.fasterxml.jackson.annotation.JsonFormat; // Para formatar o timestamp no JSON

public class StandardError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp; // Usar Instant para padronização global (GMT)
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
    }
}