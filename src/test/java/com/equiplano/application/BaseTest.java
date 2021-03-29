package com.equiplano.application;

import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.Before;

public class BaseTest {
	
	@Before
	public void before() {
		openMocks(this);
	}
}
