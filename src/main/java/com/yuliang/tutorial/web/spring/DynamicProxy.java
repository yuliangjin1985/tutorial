package com.yuliang.tutorial.web.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

    private Object delegate;

    public Object bind(Object target) {
        this.delegate = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("add log before method call");
        Object invoke = method.invoke(this.delegate, args);
        System.out.println("add log after method call");
        return invoke;
    }

    public static void main(String[] args) {
        Helloimplements helloimplements = new Helloimplements();
        Object bind = new DynamicProxy().bind(helloimplements);
        IHello iHello = (IHello) bind;
        iHello.sayHello("jim");
        iHello.sayGoogBye("jim");
    }
}
