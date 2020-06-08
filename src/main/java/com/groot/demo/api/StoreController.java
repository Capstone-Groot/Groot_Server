package com.groot.demo.api;

import com.groot.demo.command.store.StoreCommand;
import com.groot.demo.service.store.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/api")
@Controller
public class StoreController {

    private final StoreService storeService;

    @PostMapping(value = "/store")
    public ResponseEntity create(@RequestBody StoreCommand storeCommand){
        return storeService.create(storeCommand.toDto());
    }
}
