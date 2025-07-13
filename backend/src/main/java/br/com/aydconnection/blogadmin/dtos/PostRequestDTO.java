package br.com.aydconnection.blogadmin.dtos;


import lombok.Data;
import jakarta.validation.constraints.NotBlank; // <<< DESCOMENTADA

@Data
public class PostRequestDTO {
    @NotBlank(message = "Title cannot be empty") // <<< DESCOMENTADA
    private String title;

    @NotBlank(message = "Content cannot be empty") // <<< DESCOMENTADA
    private String content;

    @NotBlank(message = "Slug cannot be empty") // <<< DESCOMENTADA
    private String slug;

    @NotBlank(message = "Author cannot be empty") // <<< DESCOMENTADA
    private String author;
}
