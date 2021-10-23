package com.jnsdev.microservicos.shoppingapi.repository;

import com.jnsdev.microservicos.shoppingapi.model.Shop;
import com.jnsdev.microservicos.shoppingclient.dto.ShopReportDTO;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 15:39
 */
public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);
}
