package com.dk.rsale;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 
import com.dk.rsale.entity.MainGroup;

public class MainGroupTest {
	private static AnnotationConfigApplicationContext context;
	 @Autowired
	//private static MainGroupDAO MGDAO;
	private static MainGroup mg;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		// MainGroupDAO MGDAO;
	}

	@Test
	public void test() {
		mg= new MainGroup();
		 
		/*
		 * assertEquals("Successfully added MainGroup inside the table",true,MGDAO.
		 * addMGroup(mg));
		 */
	}

}
