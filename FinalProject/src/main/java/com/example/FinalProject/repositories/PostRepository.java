package com.example.FinalProject.repositories;

import com.example.FinalProject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
