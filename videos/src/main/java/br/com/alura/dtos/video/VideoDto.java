package br.com.alura.dtos.video;

import br.com.alura.models.Video;
import lombok.Getter;


@Getter
public class VideoDto {

    private long videoId;

    private long categoryId;

    private String title;

    private String description;

    private String url;

    public VideoDto(Video video) {

        this.videoId = video.getVideoId();
        this.categoryId = video.getCategoryId();
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();

    }

}
