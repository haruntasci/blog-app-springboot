package com.haruntasci.springbootangularcrud.controller;

import com.haruntasci.springbootangularcrud.model.Category;
import com.haruntasci.springbootangularcrud.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Create category
    @PostMapping("/add")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category category1 = categoryService.createCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    //Read categories
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    //Get category by id
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    //Update category
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategoryById(@RequestBody Category category, @PathVariable Long id) {
        return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    //Delete category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }


}
