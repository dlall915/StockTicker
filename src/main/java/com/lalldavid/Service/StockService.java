package com.lalldavid.Service;

import com.lalldavid.Dao.StockDao;
import com.lalldavid.Entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by David on 3/7/2017.
 */
@Service
public class StockService {

    @Autowired
    private StockDao stockDao;

    public Collection<Stock> getAllStocks() {
        return this.stockDao.getAllStocks();
    }

    public Stock getStockBySymbol(String symbol) {
        return this.stockDao.getStockBySymbol(symbol);
    }

    public void updateStock(Stock stock) {
        this.stockDao.updateStock(stock);
    }
}
