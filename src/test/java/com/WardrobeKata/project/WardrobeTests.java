package com.WardrobeKata.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WardrobeTests {
	private Wardrobe w;

	@Test
	public void nothing() throws Exception{

	}

	@BeforeEach
	public void makeWardrobe() throws Exception{
		w = new Wardrobe50();
	}

	@Test
	public void testSize() throws Exception{
		Wardrobe w = new Wardrobe50();
		assertEquals(50, w.getSize());
	}

}
