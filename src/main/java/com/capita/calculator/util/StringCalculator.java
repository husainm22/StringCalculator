package com.capita.calculator.util;

import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringCalculator {

	public static String evaluate(String expression) {
		if(expression==null || expression.length()==0) {
			return "EMPTY EXPRESSION";
		}
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
			return String.valueOf((Integer) engine.eval(expression));
		} catch (ScriptException e) {
			return "INVALID EXPRESSION";
		}
	}
	
	public static boolean validate(String expression) {
		return Pattern.matches("[a-zA-Z0-9\\\\+\\\\-\\\\*/\\\\(\\\\)]*", expression);
	}
	

}
