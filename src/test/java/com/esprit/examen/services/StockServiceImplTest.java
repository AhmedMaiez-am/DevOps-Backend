package com.esprit.examen.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.StockServiceImpl;

@RunWith(SpringRunner.class)
public class StockServiceImplTest {
	@InjectMocks
	static StockServiceImpl stockServiceImpl;
	@Mock
	static StockRepository stockRepository;
	static List<Stock> stocks;
	
	
	@BeforeEach
	 void init() {
		MockitoAnnotations.openMocks(this);
		stocks =  new ArrayList<>();
		when(stockRepository.findAll()).thenReturn(stocks);
	}
	
	@Test
	void testRetrieveAllStocks(){
		assertTrue(stockServiceImpl.retrieveAllStocks().isEmpty());
		
		stocks.add(mock(Stock.class));
		
		assertFalse(stockServiceImpl.retrieveAllStocks().isEmpty());
		
	}
	
	@Test
	void testAddStock(){
		//assertTrue(stockServiceImpl.addStock().isEmpty());
		stockServiceImpl.addStock(mock(Stock.class));

		verify(stockRepository).save(any());
		

		
	}
	
	@Test
	void testUpdateStock(){
		//assertTrue(stockServiceImpl.addStock().isEmpty());
		stockServiceImpl.updateStock(mock(Stock.class));
		verify(stockRepository).save(any());
		
	}

}