package com.groot.demo.service.flower;

import com.groot.demo.command.flower.ImageResult;
import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.entity.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;

    public ResponseEntity add(FlowerAddDto flowerAddDto) {

        //사진 저장하기

        System.out.println(flowerAddDto.getPicture().getResource().getFilename());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<String>("image ok", headers, HttpStatus.CREATED);
    }
}
