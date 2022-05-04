package com.micorservicesexample.stockmicroservice.controller;

import com.micorservicesexample.stockmicroservice.entity.StockEntity;
import com.micorservicesexample.stockmicroservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    public boolean stockAvalible(@PathVariable String code) {

        Optional<StockEntity> stock = stockRepository.findByCode(code);

        stock.orElseThrow(() -> new RuntimeException("Cannot find product" + code));

        return stock.get().getQuantity() > 0;
    }
}
