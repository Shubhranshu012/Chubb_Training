package com.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.MathOperation;
import com.example.Math2;
public class MockitoTest {
	@Test
    void testAddInMath2() {
        Math2 math2 = new Math2();
        int result = math2.add(2, 3);
        assertEquals(6, result); 
    }
	@BeforeAll
	public static void initialize() {
		System.out.println("setting up data and executing before al test cases");
	}
	
	
	@Test
    void testAddWithMock() {
		System.out.println(1);
		MathOperation mathMock = Mockito.mock(MathOperation.class);
        System.out.println(2);
        when(mathMock.add(2, 3)).thenReturn(100);
        System.out.println(3);
        int result = mathMock.add(2, 3);
        System.out.println(4);
        assertEquals(100, result);
        System.out.println(5);
    }
    
	@AfterAll
	public static void cleanup() {
		System.out.println("deleting data and executing before al test cases");
	}	
}
