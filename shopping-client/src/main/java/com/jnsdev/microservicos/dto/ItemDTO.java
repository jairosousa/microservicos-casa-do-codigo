package com.jnsdev.microservicos.dto;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:01
 */
public class ItemDTO {

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

//    public static ItemDTO convert(Item item) {
//        ItemDTO itemDTO = new ItemDTO();
//        itemDTO.setProductIdentifier(
//                item.getProductIdentifier());
//        itemDTO.setPrice(item.getPrice());
//        return itemDTO;
//    }
}
