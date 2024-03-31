package com.example.FinalProject.services;


import com.example.FinalProject.exceptions.EntityNotFoundException;
import com.example.FinalProject.model.Post;
import com.example.FinalProject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    // fetch all Posts
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    // fetch Post by id
    public Post get(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        throw new EntityNotFoundException("Post not found");
    }


    //To create a new Post
    public Post create(Post post) {
        return postRepository.save(post);
    }

    //To update post by id
    public Post updatePost(Long id, Post postDetails) {
        Optional<Post> optionalProduct = postRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Post post = optionalProduct.get();
            post.setAuthorName(postDetails.getAuthorName());
            post.setContent(postDetails.getContent());
            post.setImageUrl(postDetails.getImageUrl());
            return postRepository.save(post);
        }
        throw new EntityNotFoundException("Post with id " + id + " not found");
    }

    //To delete post by id
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
