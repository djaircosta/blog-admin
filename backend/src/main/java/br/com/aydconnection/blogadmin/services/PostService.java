package br.com.aydconnection.blogadmin.services;

import br.com.aydconnection.blogadmin.entities.Post;
import br.com.aydconnection.blogadmin.repositories.PostRepository;
import br.com.aydconnection.blogadmin.dtos.PostResponseDTO;
import br.com.aydconnection.blogadmin.dtos.PostRequestDTO;
// Importação correta da sua exceção
import br.com.aydconnection.blogadmin.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDTO> findAllPosts() {
        return postRepository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public PostResponseDTO createPost(PostRequestDTO postRequestDTO) {
        Post post = convertToEntity(postRequestDTO);
        post.setCreatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return convertToResponseDto(savedPost);
    }

    public PostResponseDTO findPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return convertToResponseDto(post);
    }

    public PostResponseDTO updatePost(Long id, PostRequestDTO postRequestDTO) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));

        existingPost.setTitle(postRequestDTO.getTitle());
        existingPost.setContent(postRequestDTO.getContent());
        existingPost.setSlug(postRequestDTO.getSlug());
        existingPost.setAuthor(postRequestDTO.getAuthor());
        existingPost.setUpdatedAt(LocalDateTime.now());

        Post updatedPost = postRepository.save(existingPost);
        return convertToResponseDto(updatedPost);
    }

    public void deletePost(Long id) {
        // Verifica se o post existe antes de tentar deletar
        // Se não existir, lança ResourceNotFoundException
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        
        postRepository.delete(post); // Deleta o post do banco de dados
    }

    private PostResponseDTO convertToResponseDto(Post post) {
        PostResponseDTO postDTO = new PostResponseDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setSlug(post.getSlug());
        postDTO.setAuthor(post.getAuthor());
        postDTO.setCreatedAt(post.getCreatedAt());
        postDTO.setUpdatedAt(post.getUpdatedAt());
        return postDTO;
    }

    private Post convertToEntity(PostRequestDTO postRequestDTO) {
        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setContent(postRequestDTO.getContent());
        post.setSlug(postRequestDTO.getSlug());
        post.setAuthor(postRequestDTO.getAuthor());
        return post;
    }
}
