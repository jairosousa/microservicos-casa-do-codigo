package com.jnsdev.microservicos.shoppingapi.converter;

import com.jnsdev.microservicos.shoppingapi.model.Item;
import com.jnsdev.microservicos.shoppingapi.model.Shop;
import com.jnsdev.microservicos.shoppingclient.dto.ItemDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ShopDTO;

import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 18:14
 */
public class DTOConverter {
    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(
                item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        shopDTO.setItems(shop.getItems().stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }


}
