package com.haruntasci.springbootangularcrud.service;

import com.haruntasci.springbootangularcrud.model.Category;
import com.haruntasci.springbootangularcrud.model.Post;
import com.haruntasci.springbootangularcrud.model.User;
import com.haruntasci.springbootangularcrud.repository.PostRepository;
import com.haruntasci.springbootangularcrud.requests.PostCreateRequest;
import com.haruntasci.springbootangularcrud.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;


    public List<Post> getAllPosts(Optional<Long> userId, Optional<Long> categoryId) {

        if (categoryId.isPresent() && userId.isPresent()) {
            return postRepository.findByUserIdAndCategoryId(userId.get(), categoryId.get());
        } else if (categoryId.isPresent()) {
            return postRepository.findByCategoryId(categoryId.get());
        } else if (userId.isPresent()) {
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post createPost(PostCreateRequest newPostRequest) {

        User user = userService.getUserById(newPostRequest.getUserId());
        Category category = categoryService.getCategoryById(newPostRequest.getCategoryId());
        if (user == null || category == null) {
            return null;
        }
        Post toSave = new Post();
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setContent(newPostRequest.getContent());
        toSave.setUser(user);
        toSave.setCategory(category);
        toSave.setViewCount(newPostRequest.getViewCount());
        toSave.setIsPublished(newPostRequest.getIsPublished());
        toSave.setCreationDate(newPostRequest.getCreationDate());

        return postRepository.save(toSave);
    }


    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }


    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }


    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }


    public Post updatePost(PostUpdateRequest post, Long id) {
        Post toUpdate = postRepository.findById(id).get();
        toUpdate.setTitle(post.getTitle());
        toUpdate.setContent(post.getContent());
        toUpdate.setViewCount(post.getViewCount());
        toUpdate.setIsPublished(post.getIsPublished());
        return postRepository.save(toUpdate);
    }

}
