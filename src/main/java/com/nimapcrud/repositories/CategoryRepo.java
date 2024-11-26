package com.nimapcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimapcrud.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> 
{
}