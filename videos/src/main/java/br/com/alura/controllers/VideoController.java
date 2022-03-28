package br.com.alura.controllers;

import br.com.alura.dtos.video.VideoDto;
import br.com.alura.dtos.video.VideoForm;
import br.com.alura.models.Video;
import br.com.alura.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @PostMapping
    public ResponseEntity<VideoDto> saveVideo(@RequestBody @Valid VideoForm form) {

        Video video = videoService.save(form.convertToEntity());

        return new ResponseEntity<>(new VideoDto(video), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<VideoDto>> getAllVideos(@PageableDefault Pageable pageable) {

        return new ResponseEntity<>(videoService.findAll(pageable).map(VideoDto::new), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getOneVideo(@PathVariable Long id) {

        Video video = videoService.findById(id);

        return new ResponseEntity<>(new VideoDto(video), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoDto> updateVideo(@RequestBody @Valid VideoForm form, @PathVariable Long id) {

        Video video = videoService.update(form.convertToEntity(), id);

        return new ResponseEntity<>(new VideoDto(video), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable Long id) {

        videoService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
