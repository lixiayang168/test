package com.Lisa;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TestCalculator {
    Calculator objCalculator = null;
    CalculatorService service = mock(CalculatorService.class);

    @Before
    public void setUp(){
        objCalculator = new Calculator();
    }

    @Test
    public void testMyAdd(){
        when(service.add(2,3)).thenReturn(5);
        assertEquals(5,objCalculator.myAdd(2,3));
    }
}
