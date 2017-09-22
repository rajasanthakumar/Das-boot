package com.calypso.boot.das_boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.calypso.boot.das_boot.controller.HomeController;

public class AppTest {
	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Das boot, reporting for duty");
	}
}
