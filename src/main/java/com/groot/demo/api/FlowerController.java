package com.groot.demo.api;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.service.flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class FlowerController {

    private final FlowerService flowerService;

    @PostMapping(value = "{userId}/flowers")
    public ResponseEntity addFlower(@RequestParam("picture") MultipartFile picture) throws Exception {

        return flowerService.add(FlowerAddDto.builder()
                                             .picture(picture)
                                             .build());
    }

    @GetMapping(value = "flowers")
    public ResponseEntity getFlower(@RequestParam("id") String id) throws IOException {
        return flowerService.getImage(Long.parseLong(id));
    }
}
