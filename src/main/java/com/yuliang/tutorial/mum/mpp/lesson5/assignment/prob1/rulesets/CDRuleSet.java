package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.rulesets;

import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.gui.CDWindow;

import java.awt.Component;


/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	private CDWindow cdWindow;
	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		cdWindow = (CDWindow) ob;
		String trim = cdWindow.getArtistValue().trim();
		String price = cdWindow.getPriceValue().trim();
		String title = cdWindow.getTitleValue().trim();
		noneEmptyRule();
		priceRule(price);
	}

	private void priceRule(String price) {
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


	private void noneEmptyRule() {
		String artist = cdWindow.getArtistValue().trim();
		String price = cdWindow.getPriceValue().trim();
		String title = cdWindow.getTitleValue().trim();

		if (artist.isEmpty() || price.isEmpty() || title.isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

}
