package com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.soln1;

import com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.Employee;
import com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnitTest {

    @Test
    public void testAsString() {

        String expected = "Alice Richards, Joe Stevens, John Sims, Steven Walters";
        Stream<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000)).stream();

        Assert.assertEquals(expected, Main.asString(emps.collect(Collectors.toList())));
    }
}
