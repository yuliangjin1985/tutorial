package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob11a;

@FunctionalInterface
public interface TriFunction<S,T,U,R> {
	R apply(S s, T t, U u);
}
