package com.jnsdev.microservicos.dto;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:00
 */
public class ShopDTO {

    private String userIdentifier;

    private Float total;

    private Date date;
    private List<ItemDTO> items;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

//    public static ShopDTO convert(Shop shop) {
//        ShopDTO shopDTO = new ShopDTO();
//        shopDTO.setUserIdentifier(shop.getUserIdentifier());
//        shopDTO.setTotal(shop.getTotal());
//        shopDTO.setDate(shop.getDate());
//        shopDTO.setItems(shop.getItems().stream()
//                .map(ItemDTO::convert)
//                .collect(Collectors.toList()));
//        return shopDTO;
//    }
}
