package com.ecom.inventoryservice.mappers;

import com.ecom.inventoryservice.dto.InventoryResponse;
import com.ecom.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(target = "skuCode")
    @Mapping(target = "isInStock", source = "quantity", qualifiedByName = "mapIsInStock")
    InventoryResponse ModelToResponse(Inventory inventory);

    @Named("mapIsInStock")
    default boolean mapIsInStock(Integer value){
        return value > 0;
    }
}
