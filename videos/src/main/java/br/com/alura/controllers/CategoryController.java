package br.com.alura.controllers;

import br.com.alura.dtos.category.CategoryDto;
import br.com.alura.dtos.category.CategoryForm;
import br.com.alura.models.Category;
import br.com.alura.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody @Valid CategoryForm form) {

        Category category = categoryService.save(form.convertToEntity());

        return new ResponseEntity<>(new CategoryDto(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDto>> getAllCategories(@PageableDefault Pageable pageable) {

        return new ResponseEntity<>(categoryService.findAll(pageable).map(CategoryDto::new), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Long id) {

        Category category = categoryService.findById(id);
        return new ResponseEntity<>(new CategoryDto(category), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody @Valid CategoryForm form, @PathVariable Long id) {

        Category category = categoryService.Update(form.convertToEntity(), id);

        return new ResponseEntity<>(new CategoryDto(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {

        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
