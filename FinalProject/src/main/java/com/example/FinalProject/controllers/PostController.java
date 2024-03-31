package com.example.FinalProject.controllers;

import com.example.FinalProject.model.Post;
import com.example.FinalProject.services.PostService;
import com.example.FinalProject.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseHandler.createResponse("Post Found", HttpStatus.OK, postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseHandler.createResponse("Found", HttpStatus.OK, postService.get(id));
    }

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Post post) {
        Object createPost = postService.create(post);
        if (createPost != null) {
            return ResponseHandler.createResponse("Post Created", HttpStatus.CREATED, createPost);
        }
        return ResponseHandler.createResponse("Post not created", HttpStatus.CONFLICT, null);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return ResponseHandler.createResponse("Post Updated", HttpStatus.OK, updatedPost);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletePost(@PathVariable Long id) {
//        postService.deletePost(id);
//        return ResponseHandler.deleteResponse("Post Deleted", HttpStatus.OK);
//    }
}
