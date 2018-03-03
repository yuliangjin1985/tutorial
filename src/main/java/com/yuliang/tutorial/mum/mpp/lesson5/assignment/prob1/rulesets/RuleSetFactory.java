package com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.rulesets;

import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.gui.BookWindow;
import com.yuliang.tutorial.mum.mpp.lesson5.assignment.prob1.gui.CDWindow;

import java.awt.Component;
import java.util.HashMap;



final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();

	static {
		map.put(BookWindow.class, new BookRuleSet());
		map.put(CDWindow.class, new CDRuleSet());
	}

	public static RuleSet getRuleSet(Component component) {
		return map.get(component.getClass());
	}
}
