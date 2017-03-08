package com.lalldavid.Dao;

import com.lalldavid.Entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by David on 3/7/2017.
 */
@Repository
public class StockDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StockRowMapper implements RowMapper<Stock> {

        @Override
        public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
            Stock stock = new Stock();
            stock.setSymbol(resultSet.getString("symbol"));
            stock.setPrice(resultSet.getFloat("price"));
            return stock;
        }
    }

    public Collection<Stock> getAllStocks() {
        //SELECT column_name(s) FROM table_name
        final String sql = "SELECT id, name, course FROM stocks";
        List<Stock> stocks = jdbcTemplate.query(sql, new StockRowMapper());
        return stocks;
    }

    public Stock getStockBySymbol(String symbol) {
        //SELECT column_name(s) FROM table_name WHERE column_name operator value
        final String sql = "SELECT id, name, course FROM stocks WHERE symbol = ?";
        Stock stock = jdbcTemplate.queryForObject(sql, new StockRowMapper(), symbol);
        return stock;
    }

    public void updateStock(Stock stock) {
        //UPDATE table_name
        //SET column1=value, column2=value2, ...
        //WHERE some_column=some_value
        final String sql = "UPDATE stocks SET price = ? WHERE symbol = ?";
        final String symbol = stock.getSymbol();
        final float price = stock.getPrice();
        jdbcTemplate.update(sql, new Object[] {price, symbol});
    }
}
