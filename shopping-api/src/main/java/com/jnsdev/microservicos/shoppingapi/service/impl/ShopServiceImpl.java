package com.jnsdev.microservicos.shoppingapi.service.impl;

import com.jnsdev.microservicos.shoppingapi.converter.DTOConverter;
import com.jnsdev.microservicos.shoppingapi.model.Shop;
import com.jnsdev.microservicos.shoppingapi.repository.ShopRepository;
import com.jnsdev.microservicos.shoppingapi.service.ProductService;
import com.jnsdev.microservicos.shoppingapi.service.ShopService;
import com.jnsdev.microservicos.shoppingapi.service.UserService;
import com.jnsdev.microservicos.shoppingclient.dto.ItemDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ProductDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ShopDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:11
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository
                .findAllByUserIdentifier(userIdentifier);
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThanEqual(shopDTO.getDate());
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO, String key) throws ParseException {
        if (userService
                .getUserByCpf(shopDTO.getUserIdentifier(), key) == null) {
            return null;
        }

        if (!validateProducts(shopDTO.getItems())) {
            return null;
        }

        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));
        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());
        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }

    @Override
    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo) {
        List<Shop> shops =
                shopRepository
                        .getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {
        return shopRepository
                .getReportByDate(dataInicio, dataFim);
    }

    private boolean validateProducts(List<ItemDTO> items) {
        for (ItemDTO item : items) {
            ProductDTO productDTO = productService
                    .getProductByIdentifier(
                            item.getProductIdentifier());
            if (productDTO == null) {
                return false;
            }
            item.setPrice(productDTO.getPreco());
        }
        return true;
    }
}
