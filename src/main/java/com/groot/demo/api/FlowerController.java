package com.groot.demo.api;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.service.flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FlowerController {

    private final FlowerService flowerService;

    private String url = "http://localhost:5000/";

    @PostMapping(value = "{userId}/flowers")
    public ResponseEntity addFlower(@RequestParam("picture") MultipartFile picture) throws Exception {

        return flowerService.add(FlowerAddDto.builder()
                                             .picture(picture)
                                             .build());
    }
}
