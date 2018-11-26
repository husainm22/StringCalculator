package com.capita.calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capita.calculator.util.StringCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringCalculatorApplicationTests {

	@Test
	public void validateEmptyString() {
		assertThat(StringCalculator.validate(""), is(true));
	}
	@Test
	public void validateSingleValue() {
		assertThat(StringCalculator.validate("1"), is(true));
	}
	@Test
	public void validateExpression() {
		assertThat(StringCalculator.validate("(8*5/8)-(3/1)-5"), is(false));
	}
	@Test
	public void validateInvalidExpression() {
		assertThat(StringCalculator.validate("8*+7"), is(true));
	}
	
	@Test
	public void evaluateEmptyString() {
		assertThat(StringCalculator.evaluate(""), is("EMPTY EXPRESSION"));
	}
	@Test
	public void evaluateSingleValue() {
		assertThat(StringCalculator.evaluate("1"), is("1"));
	}
	@Test
	public void evaluateExpression() {
		assertThat(StringCalculator.evaluate("(8*5/8)-(3/1)-5"), is("-3"));
	}
	@Test
	public void evaluateInvalidExpression() {
		assertThat(StringCalculator.evaluate("abc"), is("INVALID EXPRESSION"));
	}
}
