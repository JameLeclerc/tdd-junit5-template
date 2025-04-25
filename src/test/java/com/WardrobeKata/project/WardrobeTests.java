package com.WardrobeKata.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WardrobeTests {
	private Wardrobe w1;
	private Wardrobe w2;
	private Wardrobe w3;
	private Wardrobe w4;
	private WardrobeCalc wCalc;

	@Test
	public void nothing() throws Exception{

	}

	@BeforeEach
	public void makeWardrobe() throws Exception{
		w1 = new Wardrobe50();
		w2 = new Wardrobe75();
		w3 = new Wardrobe100();
		w4 = new Wardrobe120();
		wCalc = new WardrobeCalc(Arrays.asList(w1, w2, w3, w4));
	}

	@Test
	public void testSize() throws Exception{
		assertEquals(50, w1.getSize());
	}

	@Test
	public void testPrice() throws Exception{
		assertEquals(59, w1.getPrice());
	}

	@Test
	public void testComboCalc50() throws Exception{
		ArrayList<ArrayList<Wardrobe>> knownCombo = new ArrayList<ArrayList<Wardrobe>>();
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w1)));
		assertEquals(knownCombo, wCalc.combosCalc(50));
	}

	@Test
	public void testComboCalc100() throws Exception{
		ArrayList<ArrayList<Wardrobe>> knownCombo = new ArrayList<ArrayList<Wardrobe>>();
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w3)));
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w1, w1)));
		assertEquals(knownCombo, wCalc.combosCalc(100));
	}

	@Test
	public void testComboCalc150() throws Exception{
		ArrayList<ArrayList<Wardrobe>> knownCombo = new ArrayList<ArrayList<Wardrobe>>();
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w1, w1, w1)));
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w2, w2)));
		knownCombo.add(new ArrayList<Wardrobe>(Arrays.asList(w3, w1)));
		assertEquals(knownCombo, wCalc.combosCalc(150));
	}

	@Test
	public void testComboCalcOrder() throws Exception{
		WardrobeCalc randCalc = new WardrobeCalc(Arrays.asList(w1, w3, w2, w4));
		ArrayList<Wardrobe> knownOrder = new ArrayList<Wardrobe>();
		knownOrder.add(w4);
		knownOrder.add(w3);
		knownOrder.add(w2);
		knownOrder.add(w1);
		assertEquals(knownOrder, randCalc.getWrdbs());
	}

}
