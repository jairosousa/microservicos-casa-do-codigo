package com.jnsdev.microservicos.shoppingapi.service;

import com.jnsdev.microservicos.dto.ShopDTO;
import com.jnsdev.microservicos.dto.ShopReportDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:08
 */
public interface ShopService {

    public List<ShopDTO> getAll();

    public List<ShopDTO> getByUser(String userIdentifier);

    public List<ShopDTO> getByDate(ShopDTO shopDTO);

    public ShopDTO findById(long ProductId);

    public ShopDTO save(ShopDTO shopDTO, String key) throws ParseException;

    public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
