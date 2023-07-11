package com.haruntasci.springbootangularcrud.repository;

import com.haruntasci.springbootangularcrud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);
    List<Post> findByCategoryId(Long categoryId);
    List<Post> findByUserIdAndCategoryId(Long userId, Long categoryId);
}
