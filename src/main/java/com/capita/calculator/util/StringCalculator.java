package com.capita.calculator.util;

import java.util.Stack;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringCalculator {

	public static boolean validate(String expression) {
		return Pattern.matches("[a-zA-Z0-9\\\\+\\\\-\\\\*/\\\\(\\\\)]*", expression);
	}

	/**
	 * Evaluate the string
	 * 				
	 * @param expression
	 * @return
	 */
	public static String evaluate(String expression) 
	{ 
		if(expression==null || expression.length()==0) {
			return "EMPTY EXPRESSION";
		}
		char[] chars = expression.toCharArray(); 

		Stack<Integer> numbers = new Stack<Integer>(); 

		Stack<Character> operands = new Stack<Character>(); 

		for (int i = 0; i < chars.length; i++) 
		{ 
			if (chars[i] >= '0' && chars[i] <= '9') 
			{ 
				numbers.push(Integer.parseInt(chars[i]+"")); 
			} else if (chars[i] == '(') {
				operands.push(chars[i]); 
			} else if (chars[i] == ')') { 
				while (operands.peek() != '(') {
					numbers.push(eval(operands.pop(), numbers.pop(), numbers.pop())); 
				}
				operands.pop(); 
			} else if (chars[i] == '+' || chars[i] == '-' || 
					chars[i] == '*' || chars[i] == '/') { 
				while (!operands.empty() && isPrecedence(chars[i], operands.peek())) {
					numbers.push(eval(operands.pop(), numbers.pop(), numbers.pop()));
				}
				operands.push(chars[i]); 
			} 
		} 

		while (!operands.empty()) {
			numbers.push(eval(operands.pop(), numbers.pop(), numbers.pop()));
		}
		
		return numbers.pop()+""; 
	} 

	private static int eval(char operand, int val1, int val2) 
	{ 
		switch (operand) 
		{ 
			case '+': 
				return val2 + val1; 
			case '-': 
				return val2 - val1; 
			case '*': 
				return val2 * val1; 
			case '/': 
				return val2 / val1; 
			default:
				return 0;
		} 
	} 

	private static boolean isPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
}
