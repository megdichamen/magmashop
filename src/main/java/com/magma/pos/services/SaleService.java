package com.magma.pos.services;

import com.magma.pos.entities.Product;
import com.magma.pos.entities.Sale;
import com.magma.pos.entities.SaleItem;

public class SaleService {
    private StockService stockService;
    public SaleService() {
        stockService = new StockService();
    }
    public boolean validateSale(Sale sale) {
        if (sale == null) {
            return false;
        }
        if (sale.getItems().isEmpty()) {
            return false;
        }
        return true;
    }


    public boolean processSale(Sale sale) {
        if (!validateSale(sale)) {
            return false;
        }
        else {
            for (SaleItem item : sale.getItems()) {
                if (item.getProduct().getQuantity() < item.getQuantity()) {
                    return false;
                }
            }
            for (SaleItem item : sale.getItems()) {
                stockService.sellProduct(item.getProduct(), item.getQuantity());
            }
            return true;
        }
    }
}
