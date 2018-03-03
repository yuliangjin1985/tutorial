package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.rulesets;

import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.gui.BookWindow;

import java.awt.Component;



/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	private BookWindow bookWindow;

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		bookWindow = (BookWindow) ob;
		noneEmptyRule();
		isbnRule();
		priceRule();
	}

	private void priceRule() {
		String price = bookWindow.getPriceValue().trim();
		Float aFloat;
		try {
			aFloat = Float.valueOf(price);
		} catch (NumberFormatException e) {
			throw new RuleException("price must be numeric");
		}

		if (price.charAt(price.length() - 3) != '.') {
			throw new RuleException("price must has two decimal place.");
		}

		if ((aFloat - 0.49f) <= 0) {
			throw new RuleException("price must be greater than 0.49.");
		}

	}

	public static void main(String[] args) {
	    String a = "2342342342.09";
		System.out.println(a.charAt(a.length()-3));
	}

	private void isbnRule() {
		String isbnValue = bookWindow.getIsbnValue().trim();
		int length = isbnValue.length();
		if(length != 10 || length != 13) {
			throw new RuleException("Isbn should either be 10 or 13 characters");
		}

		try {
			double v = Double.parseDouble(isbnValue);
		} catch (NumberFormatException e) {
			throw new RuleException("Isbn shoule be numeric.");
		}

		char c = isbnValue.charAt(0);
		if (length == 10 && !((c == '0') || (c == '1'))) {
		    throw new RuleException("10 character isbn has to begin either with 0 or 1.");
		}

		String substring = isbnValue.substring(0, 3);
		if (!(substring == "978" || substring == "979")) {
			throw new RuleException("13 character isbn has to begin either with 978 or 979.");
		}
	}

	private void noneEmptyRule() {
	    if(bookWindow.getIsbnValue().trim().isEmpty() ||
				bookWindow.getPriceValue().trim().isEmpty() ||
				bookWindow.getTitleValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
}
