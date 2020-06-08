package com.groot.demo.service.store;

import com.groot.demo.dto.StoreDto;
import com.groot.demo.entity.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public ResponseEntity create(StoreDto storeDto) {

        storeRepository.save(storeDto.toEntity());

        return ResponseEntity.ok("저장됨!!!");
    }
}
