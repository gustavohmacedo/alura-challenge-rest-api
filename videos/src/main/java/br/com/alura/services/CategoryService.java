package br.com.alura.services;

import br.com.alura.models.Category;
import br.com.alura.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category) {

        return categoryRepository.save(category);

    }

    public Page<Category> findAll(Pageable pageable) {

        return categoryRepository.findAll(pageable);

    }

    public Category findById(Long id) {

        Optional<Category> findCategory = categoryRepository.findById(id);

        if (findCategory.isEmpty()) {

            throw new RuntimeException("Category not found!");
        }

        return findCategory.get();
    }

    public Category Update(Category category, Long id) {

        Category originalCategory = this.findById(id);

        category.setCategoryId(originalCategory.getCategoryId());

        return categoryRepository.save(category);

    }

    public void delete(Long id) {

        Category category = this.findById(id);

        categoryRepository.delete(category);

    }


}
