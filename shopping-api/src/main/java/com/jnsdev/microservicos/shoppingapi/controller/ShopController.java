package com.jnsdev.microservicos.shoppingapi.controller;

import com.jnsdev.microservicos.shoppingapi.service.ShopService;
import com.jnsdev.microservicos.shoppingclient.dto.ShopDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ShopReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:13
 */
@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> getShops() {
        List<ShopDTO> produtos = shopService.getAll();
        return produtos;
    }

    @GetMapping("/shopping/shopsByUser/{userIdentifier}")
    public List<ShopDTO> getShops(@PathVariable String userIdentifier) {
        List<ShopDTO> produtos =
                shopService.getByUser(userIdentifier);
        return produtos;
    }

    @GetMapping("/shopping/shopByDate")
    public List<ShopDTO> getShops(@RequestBody ShopDTO shopDTO) {
        List<ShopDTO> produtos = shopService.getByDate(shopDTO);
        return produtos;
    }

    @GetMapping("/shopping/{id}")
    public ShopDTO findById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @GetMapping("/shopping/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "dataInicio", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required=false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
            @RequestParam(name = "valorMinimo", required=false)
                    Float valorMinimo) {
        return shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
    }

    @GetMapping("/shopping/report")
    public ShopReportDTO getReportByDate(
            @RequestParam(name = "dataInicio", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
            @RequestParam(name = "dataFim", required=true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return shopService.getReportByDate(dataInicio, dataFim);
    }

    @PostMapping("/shopping")
    public ShopDTO newShop(
            @RequestHeader(name = "key", required = true) String key,
            @Valid @RequestBody ShopDTO shopDTO) throws ParseException {
        return shopService.save(shopDTO, key);
    }
}
