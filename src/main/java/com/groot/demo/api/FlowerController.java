package com.groot.demo.api;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.service.flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "flowers/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getFlower(@PathVariable("id") String id) throws IOException {
        return flowerService.getImage(Long.parseLong(id));
    }

    @GetMapping(value = "history/{userId}")
    public ResponseEntity getHistory(@PathVariable String userId) throws IOException{
        return flowerService.getHistory(userId);
    }
}
