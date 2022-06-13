package com.chainsys.springproject.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;

public class TestXmlBeanFactory {

	public static void testA() {

		ClassPathResource res = new ClassPathResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		Employee emp = factory.getBean("emp2",Employee.class);
		emp.setId(35);
		emp.setName("jaav");
		emp.print();
		System.out.println(factory.isSingleton("emp"));
		System.out.println(factory.getBean("emp")instanceof Employee);
		System.out.println(factory.getBean("emp") instanceof Customer);
		System.out.println(factory.isPrototype("emp"));
		System.out.println(factory.isTypeMatch("emp", Employee.class));
//		Instanceof Employee and isTypeMatch both are same
		
	}
}
