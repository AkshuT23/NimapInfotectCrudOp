package com.nimapcrud.services;

import java.util.List;

import com.nimapcrud.entities.Category;

public interface CategoryService {
	List<Category> getAllCategories(int pageNo, int pageSize);
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);

}
