package com.jnsdev.microservicos.shoppingapi.model;

import com.jnsdev.microservicos.dto.ItemDTO;

import javax.persistence.Embeddable;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:59
 */
@Embeddable
public class Item {
    private String productIdentifier;
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(
                itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
