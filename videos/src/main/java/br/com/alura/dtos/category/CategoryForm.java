package br.com.alura.dtos.category;

import br.com.alura.models.Category;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
public class CategoryForm {

    @NotNull
    @NotEmpty(message = "Title cannot be blank")
    @Length(min = 5, max = 30)
    private String title;

    @NotNull
    @NotEmpty(message = "Color cannot be blank")
    @Length(min = 4, max = 10)
    private String color;

    public Category convertToEntity() {

        return new Category(this.title, this.color);
    }
}
