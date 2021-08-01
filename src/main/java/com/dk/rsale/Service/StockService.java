package com.dk.rsale.Service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.StockDAO;
import com.dk.rsale.entity.Stock;

@Service
@Transactional
public class StockService {
@Autowired
StockDAO sdao;
public Stock saveStock(Stock s)
{
	Stock s1 = new Stock();
	s1.setAmount(s.getAmount());
	s1.setNor(s.getNor());
	s1.setStockon(s.getStockon());
	s1.setStocktype(s.getStocktype());
	return sdao.save(s1);
}

public Stock findstockid(String stockid)
{
	return sdao.findById(stockid).orElse(null);
}

public List<Stock> findstockall()
{
	return sdao.findAll();
}

public Stock uppstock( Stock stk) {
	
	Stock s1 = new Stock();
	s1.setStockid(stk.getStockid());
	s1.setAmount(stk.getAmount());
	s1.setNor(stk.getNor());
	s1.setStockon(stk.getStockon());
	s1.setStocktype(stk.getStocktype());
	return sdao.save(s1);
}
 

}
