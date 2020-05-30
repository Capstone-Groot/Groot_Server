package com.groot.demo.service.flower;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.entity.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;
    private final RestTemplate restTemplate;

    public ResponseEntity add(FlowerAddDto flowerAddDto) throws IOException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        ByteArrayResource fileResource = new ByteArrayResource(flowerAddDto.getPicture().getBytes()) {
            @Override
            public String getFilename() {
                return "imageFile.jpg";
            }
        };
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<JSONObject> response = restTemplate.postForEntity("http://127.0.0.1:5000/predict", requestEntity, JSONObject.class);

        System.out.println(response.getBody().get("image"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<JSONObject>(response.getBody(), headers, HttpStatus.CREATED);
    }
}
