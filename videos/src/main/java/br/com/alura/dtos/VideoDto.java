package br.com.alura.dtos;

import br.com.alura.models.Video;
import lombok.Getter;


@Getter
public class VideoDto {

    private long idVideo;

    private String title;

    private String description;

    private String url;

    public VideoDto(Video video) {

        this.idVideo = getIdVideo();
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.url = video.getUrl();

    }




}
