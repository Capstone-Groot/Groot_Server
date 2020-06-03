package com.groot.demo.service.flower;

import com.groot.demo.dto.FlowerAddDto;
import com.groot.demo.entity.Flower;
import com.groot.demo.entity.FlowerRepository;
import com.groot.demo.entity.User;
import com.groot.demo.entity.UserRepository;
import com.groot.demo.exception.NotFoundFlowerException;
import com.groot.demo.util.ResourceManger;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.simple.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@RequiredArgsConstructor
@Service
public class FlowerService {

    private final UserRepository userRepository;
    private final FlowerRepository flowerRepository;
    private final RestTemplate restTemplate;

    public ResponseEntity getImage(Long id) throws IOException {
        Flower flower = flowerRepository.findById(id).orElseThrow(() -> new NotFoundFlowerException("꽃을 찾지 못하였습니다."));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        File file = new File(flower.getFilePath());
        byte[] fileContent = Files.readAllBytes(file.toPath());
        ByteArrayResource fileResource = new ByteArrayResource(fileContent) {
            @Override
            public String getFilename() {
                return "imageFile.jpg";
            }
        };
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        return new ResponseEntity<MultiValueMap<String, Object>>(body, httpHeaders, HttpStatus.OK);
    }

    public ResponseEntity add(FlowerAddDto flowerAddDto) throws IOException {

        MultipartFile file = flowerAddDto.getPicture();
        String userId = file.getOriginalFilename();
        userId = userId.substring(0, userId.length() - 4);

        User writer = userRepository.findByUserId(userId);

        JSONObject response = requestAIModel(flowerAddDto.getPicture());
        File convertFile = saveFile(file);

        Flower flower = new Flower((String) response.get("image"), convertFile.getName(), writer);
        flowerRepository.save(flower);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<JSONObject>(response, headers, HttpStatus.CREATED);
    }

    private File saveFile(MultipartFile file) throws IOException {
        File convertFile = new File(ResourceManger.getIndex() + ".jpg");

        System.out.println(file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        return convertFile;
    }

    private JSONObject requestAIModel(MultipartFile multipartFile) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        ByteArrayResource fileResource = new ByteArrayResource(multipartFile.getBytes()) {
            @Override
            public String getFilename() {
                return "imageFile.jpg";
            }
        };
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<JSONObject> response = restTemplate.postForEntity("http://127.0.0.1:5000/predict", requestEntity, JSONObject.class);

        return response.getBody();
    }
}
