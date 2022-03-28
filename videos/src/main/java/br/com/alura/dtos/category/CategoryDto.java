package br.com.alura.dtos.category;

import br.com.alura.models.Category;
import lombok.Getter;

@Getter
public class CategoryDto {

    private long categoryId;

    private String title;

    private String color;

    public CategoryDto(Category category) {
        this.categoryId = category.getCategoryId();
        this.title = category.getTitle();
        this.color = category.getColor();

    }

}
