package br.com.alura.dtos;


import br.com.alura.models.Video;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class VideoForm {

    @NotNull
    @NotEmpty(message = "Title cannot be blank")
    @Length(min = 5, max = 40)
    private String title;

    @NotNull
    @NotEmpty(message = "Description cannot be blank")
    @Length(min = 5, max = 50)
    private String description;

    @NotNull
    @NotEmpty(message = "Url cannot be blank")
    @Length(min = 10, max = 80)
    private String url;

    public Video convertToEntity() {

        return new Video(title, description, url);

    }

}
