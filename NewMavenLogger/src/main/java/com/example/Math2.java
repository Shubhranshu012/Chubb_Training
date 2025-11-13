package com.example;

public class Math2 extends MathOperation {
	@Override
    public int add(int a, int b) {
        return super.add(a, b) + 1;
    }
}
