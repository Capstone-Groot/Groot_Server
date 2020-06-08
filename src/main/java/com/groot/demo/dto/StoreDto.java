package com.groot.demo.dto;

import com.groot.demo.entity.Store;
import lombok.Builder;

public class StoreDto {

    private String name;
    private String address;
    private String phoneNumber;
    private String explain;

    @Builder
    public StoreDto(String storeName, String address, String phoneNumber, String explain) {
        this.name = storeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.explain = explain;
    }

    public Store toEntity() {
        return Store.builder()
                    .name(name)
                    .address(address)
                    .phoneNumber(phoneNumber)
                    .explain(explain)
                    .build();
    }
}
