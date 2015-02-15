package edu.csus.csc130;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void testInfixToPostfix() throws Exception {
        String infixExp = "10 * ( 15 + 3 ) / 5";
        String actualValue = Expression.infixToPostfix(infixExp);
        assertEquals("10 15 3 + * 5 /", actualValue);
    }

    @Test
    public void testEvaluatePostfix() throws Exception {
        String postfixExp = "10 15 3 + * 5 /";
        double actualValue = Expression.evaluatePostfix(postfixExp);
        assertEquals(36, actualValue, 0.001);
    }
}