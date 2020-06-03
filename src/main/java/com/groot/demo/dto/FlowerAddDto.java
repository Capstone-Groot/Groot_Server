package com.groot.demo.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
public class FlowerAddDto {

    private MultipartFile picture;

}
