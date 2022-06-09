package com.chainsys.projectA.getbeans;

import org.springframework.context.ApplicationContext;						// Parent
import org.springframework.context.support.ClassPathXmlApplicationContext;	// Child

import com.chainsys.projectA.beans.Actor;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;

public class TestClassPathXml {
	
	public static void testA() {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Omkumar");
		emp.print();
	}
	
	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = (Employee)ac.getBean("emp"); // OverLoaded method of getBean(Class) returns Object, type casting is required
		Employee emp2 = ac.getBean(Employee.class);// OverLoaded method of getBean(Class) returns object of the class employee.
		emp.setId(1);
		emp.setName("Omkumar");
		emp.print();
		Customer c = ac.getBean(Customer.class);
		c.setId(1);
		c.setName("Virat Kohli");
		c.print();
	}
	public static void testC() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean(Employee.class);
		Customer c = ac.getBean(Customer.class);
// lazy-init="true" for customer.An object is created now (firstCall to getBean() method for Customer.class).		
		Employee Emp = ac.getBean(Employee.class);
		Customer C = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(Emp.hashCode());
		System.out.println(c.hashCode());
		System.out.println(C.hashCode());
	}
	
	public static void testPrototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor heroin = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		Actor friend = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroin.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friend.hashCode());	
	}
	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}
}
