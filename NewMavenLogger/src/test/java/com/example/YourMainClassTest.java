package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.BinarySearch;
import com.example.MathOperations;


public class YourMainClassTest {

    @Test
    void testAdd() {
    	int x=5;
        assertEquals(5, x);
    }
    
    
    @Test
    void testSearchNotFound() {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5};
        assertFalse(bs.search(arr, 6));
    }
    @Test 
    void math() {
    	int i=10;
    	int j=10;
    	MathOperations math=new MathOperations();
    	assertEquals(math.adding(i,j),20);
    }
}
