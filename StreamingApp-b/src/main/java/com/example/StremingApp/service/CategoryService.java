package com.example.StremingApp.service;

import com.example.StremingApp.model.Category;
import com.example.StremingApp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category updated) {
        Category existing = categoryRepository.findById(id).orElseThrow();
        existing.setNom(updated.getNom()); // adapte selon les champs
        return categoryRepository.save(existing);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
