package com.haruntasci.springbootangularcrud.repository;

import com.haruntasci.springbootangularcrud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
