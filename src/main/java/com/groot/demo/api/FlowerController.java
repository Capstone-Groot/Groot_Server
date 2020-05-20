package com.groot.demo.api;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.service.flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FlowerController {

    private final FlowerService flowerService;

    @PostMapping(value = "{userId}/flowers", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity addFlower(MultipartFile picture) {

        return flowerService.add(FlowerAddDto.builder()
                                             .picture(picture)
                                             .build());
    }
}
