package com.chainsys.projectA.startup;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;
import org.springframework.context.ApplicationContext;					// Parent
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child
public class Main {

	public static void main(String[] args) {
		testB();
	}

	public static void testA() {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Omkumar");
		emp.print();
	}
	
	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee emp = (Employee)ac.getBean("emp");
		emp.setId(1);
		emp.setName("Omkumar");
		emp.print();
		Customer c = ac.getBean(Customer.class);
		c.setId(1);
		c.setName("Virat Kohli");
		c.print();
	}
	
	
}
