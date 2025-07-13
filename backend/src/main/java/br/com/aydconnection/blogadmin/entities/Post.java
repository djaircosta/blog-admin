package br.com.aydconnection.blogadmin.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor; // Mantenha este se você o adicionou
import lombok.AllArgsConstructor; // Mantenha este se você o adicionou
import java.time.LocalDateTime;

@Entity
@Data // Lombok vai gerar getters e setters
@NoArgsConstructor // Para o construtor padrão, necessário para JPA
@AllArgsConstructor // Construtor com todos os campos (útil para testes, por exemplo)
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(unique = true, nullable = false)
    private String slug;

    private String author;

    @Column(name = "created_at", nullable = false) // Remova 'updatable = false' se estiver aqui
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // **REMOVA ESTES MÉTODOS SE ELES ESTIVEREM AQUI:**
    // @PrePersist
    // protected void onCreate() {
    //     this.createdAt = LocalDateTime.now();
    // }

    // @PreUpdate
    // protected void onUpdate() {
    //     this.updatedAt = LocalDateTime.now();
    // }
}