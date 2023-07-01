package com.ecom.inventoryservice.controller;

import com.ecom.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/inventory")
public class InventoryController {
    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        logger.info("Received Request: skuCode=" + skuCode);
        return inventoryService.isInStock(skuCode);
    }

}
