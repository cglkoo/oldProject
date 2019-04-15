package com.java.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathCalTest {
	
	private MathCal mc = new MathCal();

	@Test
	public void testAdd() {
		 assertEquals(3, mc.add(1, 2));
	}

	@Test
	public void testMin() {
		 assertEquals(1, mc.min(2, 1));
	}

	@Test
	public void testMul() {
		 assertEquals(200, mc.mul(20, 10));
	}

	@Test
	public void testDiv() {
		 assertEquals(2, mc.div(20, 10));
	   
	}
	
	@Test
	public void testCompl(){
		assertFalse(mc.compl(1,2));
	}

}
