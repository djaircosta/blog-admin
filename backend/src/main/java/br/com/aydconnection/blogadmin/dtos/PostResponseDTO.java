package br.com.aydconnection.blogadmin.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String slug;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
