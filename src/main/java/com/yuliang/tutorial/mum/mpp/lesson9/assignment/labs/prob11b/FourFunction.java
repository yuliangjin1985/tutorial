package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob11b;

@FunctionalInterface
public interface FourFunction<S,T,U,V,R> {
	R apply(S s, T t, U u, V v);
}
