package edu.csus.csc130;

import java.util.Stack;

/**
 * Created by FirstName LastName
 */
public class Expression {
	
    /**
     * Convert an arithmetic expression from infix to postfix
     * With infix expression, operators are written in-between their operands,
     * such as  10 * ( 15 + 3 ) / 5
     * With postfix expression, operators are written after their operands,
     * such as 10 15 3 + * 5 /
     * Assume an expression only consists of the following:
     * 1) left and right parentheses
     * 2) four operators: +, -, *, /
     * 3) integer operands
     * Make sure the return string does not have leading or trailing spaces,
     * and uses single space to separate elements
     */
    public static String infixToPostfix(String postFixExp) {
        Stack<String> operators = new Stack<String>();
        StringBuilder output = new StringBuilder();
        
        String[] tokens = postFixExp.split("\\s");
        
        for (String token : tokens) {
        	switch (token) {
        	
        	case "+":
        		operators.push(token);
        		break;
        	case "-":
        		operators.push(token);
        		break;
        	case "*":
        		operators.push(token);
        		break;
        	case "/":
        		operators.push(token);
        		break;
        	case ")":
        		output.append(operators.pop() + " " + operators.pop() + " ");
        		break;
        	case "(":
        		break;
        	default:
        		output.append(token + " ");
        	
        	}
        }
        while (!operators.isEmpty()) output.append(operators.pop());
        
        return output.toString();
    }

    /**
     * Evaluate a postfix expression and return it value
     * With postfix expression, operators are written after their operands,
     * such as 10 15 3 + * 5 /
     * Assume an expression only consists of the following:
     * 1) left and right parentheses
     * 2) four operators: +, -, *, /
     * 3) integer operands
     */
    public static double evaluatePostfix(String postFixExp) {
    	
    	Stack<String> operands = new Stack<String>();
        
        String[] tokens = postFixExp.split("\\s");
    	
        double temp1;
        double temp2;
        double temp3;
        
        for (String token : tokens) {
        	switch (token) {
        	
        	case "+":
        		temp1 = Double.parseDouble(operands.pop());
        		temp2 = Double.parseDouble(operands.pop());
        		temp3 = temp2 + temp1;
        		operands.push(String.valueOf(temp3));
        		break;
        	case "-":
        		temp1 = Double.parseDouble(operands.pop());
        		temp2 = Double.parseDouble(operands.pop());
        		temp3 = temp2 - temp1;
        		operands.push(String.valueOf(temp3));
        		break;
        	case "*":
        		temp1 = Double.parseDouble(operands.pop());
        		temp2 = Double.parseDouble(operands.pop());
        		temp3 = temp2 * temp1;
        		operands.push(String.valueOf(temp3));
        		break;
        	case "/":
        		temp1 = Double.parseDouble(operands.pop());
        		temp2 = Double.parseDouble(operands.pop());
        		temp3 = temp2 / temp1;
        		operands.push(String.valueOf(temp3));
        		break;
        	default:
        		operands.push(token);
        		break;
        	
        	}
        }
        return Double.parseDouble(operands.pop());
    }
}
