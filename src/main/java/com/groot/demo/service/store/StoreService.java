package com.groot.demo.service.store;

import com.groot.demo.dto.StoreDto;
import com.groot.demo.entity.Store;
import com.groot.demo.entity.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public ResponseEntity create(StoreDto storeDto) {

        storeRepository.save(storeDto.toEntity());

        return ResponseEntity.ok("저장됨!!!");
    }

    public ResponseEntity find(String flower) {
        List<Store> stores = storeRepository.findAll();

        List<Store> response = stores.stream().filter((x) -> x.getExplain().contains(flower)).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
