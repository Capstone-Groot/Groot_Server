package com.groot.demo.command.store;

import com.groot.demo.dto.StoreDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StoreCommand {

    private String storeName;
    private String address;
    private String phoneNumber;
    private String storeExplain;

    public StoreDto toDto() {
        return StoreDto.builder()
                       .storeName(storeName)
                       .address(address)
                       .phoneNumber(phoneNumber)
                       .explain(storeExplain)
                       .build();
    }
}
