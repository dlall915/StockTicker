package com.lalldavid.Controller;

import com.lalldavid.Dao.StockDao;
import com.lalldavid.Entity.Stock;
import com.lalldavid.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by David on 3/7/2017.
 */
@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Stock> getAllStocks() { return stockService.getAllStocks(); }

    @RequestMapping(method = RequestMethod.GET)
    public Stock getStockBySymbol(@PathVariable("symbol") String symbol) {
        return stockService.getStockBySymbol(symbol);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStock(@RequestBody Stock stock) {
        stockService.updateStock(stock);
    }
}
