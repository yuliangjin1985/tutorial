package com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.solu2;


import com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.Employee;
import com.yuliang.tutorial.mum.mpp.lesson10.labs.prob5.EmployeeCompanion;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void test() {
        Employee emp1 = new Employee("hi", "Neo", 110000);
        Assert.assertEquals(true, EmployeeCompanion.salaryGreaterThan100000(emp1));
        Assert.assertEquals(true, EmployeeCompanion.lastNameAfterM(emp1));
        Assert.assertEquals(true, EmployeeCompanion.lastNameAfterM.test(emp1));
        Assert.assertEquals(true, EmployeeCompanion.salaryGreaterThan100000.test(emp1));
    }
}
