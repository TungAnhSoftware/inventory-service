package com.ecom.inventoryservice.service;

import com.ecom.inventoryservice.dto.InventoryResponse;
import com.ecom.inventoryservice.mappers.InventoryMapper;
import com.ecom.inventoryservice.model.Inventory;
import com.ecom.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        List<Inventory> products = inventoryRepository.findBySkuCodeIn(skuCode);
        return products.stream().map(inventoryMapper::ModelToResponse).toList();
    }
}
