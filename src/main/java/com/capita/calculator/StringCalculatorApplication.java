package com.capita.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capita.calculator.util.StringCalculator;

@SpringBootApplication
public class StringCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringCalculatorApplication.class, args);
		
		int totalInputs = Integer.parseInt(args[0]);
		int counter = 1;
		if(totalInputs==args.length-1) {
			System.out.println("Number of inputs are validated - "+totalInputs);
			for(String arg:args) {
				if(arg.equals(totalInputs+"")) {
					continue;
				}
				if(!StringCalculator.validate(arg)) {
				    System.out.println("Case #"+counter+": "+StringCalculator.evaluate(arg));
				} else {
					System.out.println("Case #"+counter+": INVALID EXPRESSION");
				}
				counter++;
			}
		} else {
			System.out.println("ERROR: Input mismatch");	
		}
	}
	
}
