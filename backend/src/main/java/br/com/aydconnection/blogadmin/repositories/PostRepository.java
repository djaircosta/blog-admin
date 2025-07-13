package br.com.aydconnection.blogadmin.repositories;

import br.com.aydconnection.blogadmin.entities.Post; // Importe sua classe Post (Entidade)
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Opcional, mas boa prática para indicar que é um repositório
public interface PostRepository extends JpaRepository<Post, Long> {
    // Spring Data JPA vai gerar automaticamente os métodos CRUD (create, read, update, delete)
    // para a entidade Post, usando Long como o tipo da chave primária (ID).
    // Você pode adicionar métodos de consulta personalizados aqui se precisar,
    // mas para o CRUD básico, esta interface vazia já é suficiente.
}
