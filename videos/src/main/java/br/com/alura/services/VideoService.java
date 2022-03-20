package br.com.alura.services;

import br.com.alura.models.Video;
import br.com.alura.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public Video save(Video video) {

        return videoRepository.save(video);
    }

    public Page<Video> findAll(Pageable pageable) {

        return videoRepository.findAll(pageable);
    }

    public Video findById(Long id) {

        Optional<Video> findVideo = videoRepository.findById(id);

        if (findVideo.isEmpty()) {

            throw new RuntimeException("Video not found!");
        }

        return findVideo.get();
    }

    public Video update(Video video, Long id) {

        Video originalVideo = this.findById(id);

        video.setIdVideo(originalVideo.getIdVideo());

        return videoRepository.save(video);
    }

    public void delete(Long id) {

        Video video = this.findById(id);

        videoRepository.delete(video);
    }
}
