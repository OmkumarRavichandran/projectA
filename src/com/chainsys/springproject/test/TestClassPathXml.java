package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext; // Parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDisposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClassPathXml {

	public static void testA() {

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Omkumar");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		Employee emp = (Employee) ac.getBean("emp"); // OverLoaded method of getBean(Class) returns Object, type casting
														// is required
		Employee emp2 = ac.getBean(Employee.class);// OverLoaded method of getBean(Class) returns object of the class
													// employee.
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

	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ScoreBoard sb = ac.getBean("sb1", ScoreBoard.class);
		sb.targetScore = 195;
		System.out.println(sb.targetScore);
		ScoreBoard sb2 = ac.getBean("sb2", ScoreBoard.class);
		// sb2.targetScore=300;
		System.out.println(sb2.targetScore);
	}

	public static void testCalendarFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calendar today = ac.getBean(Calendar.class);
		today.day = 10;
		today.month = "June";
		today.year = 2000;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		System.out.println("----");
		nvsilunch.serve();
		System.out.println("----");
		vsilunch.serve();
		System.out.println("----");
		nilunch.serve();
		System.out.println("----");
		chlunch.serve();
	}

	public static void testLifeCycle() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("lc.xml");
		LifeCycleBean life = ac.getBean(LifeCycleBean.class);
		life.print();
		LifeCycleBean life1 = ac.getBean(LifeCycleBean.class);
		LifeCycleBean life2 = ac.getBean(LifeCycleBean.class);
		ac.close();
	}

	public static void testInitDestroyBean() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("lc.xml");
		InitDisposeBean init = ac.getBean(InitDisposeBean.class);
		init.print();
	}

	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc ann = ac1.getBean(AnnotationLc.class);
		ann.print();
		ann = null;
		ac1.close();
	}

	public static void testAutowire() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		Car carobj = ac1.getBean("car",Car.class);
		carobj.start();
		carobj.move();
		carobj = null;
		ac1.close();
	}

	public static void testAutoWireQualifier() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		CarServices cs = ac1.getBean(CarServices.class);
		cs.startTrip();
		cs=null;
		ac1.close();
	}

}
