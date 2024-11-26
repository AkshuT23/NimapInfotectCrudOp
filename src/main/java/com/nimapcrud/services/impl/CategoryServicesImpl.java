package com.nimapcrud.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimapcrud.entities.Category;
import com.nimapcrud.repositories.CategoryRepo;
import com.nimapcrud.services.CategoryService;

@Service
public class CategoryServicesImpl implements CategoryService {
	
	
	@Autowired
    CategoryRepo categoryRepo;
	

	@Override
	public List<Category> getAllCategories(int pageNo, int pageSize) {
		
		Pageable p= PageRequest.of(pageNo, pageSize);
		
		Page<Category> categoriesPage= categoryRepo.findAll(p);
		List<Category> allCategories=categoriesPage.getContent();
		
		return allCategories;
	}

	@Override
	public Category getCategoryById(Long id) {
		
		return categoryRepo.findById(id).
				orElseThrow(()-> new RuntimeException("category for given ID is not found"));
	}

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		
		Category updatingCategory=categoryRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("category not found"));;
		updatingCategory.setName(category.getName());
		
		return categoryRepo.save(updatingCategory);
	}

	@Override
	public void deleteCategory(Long id) {
	categoryRepo.deleteById(id);
		
	}
	
	

}
