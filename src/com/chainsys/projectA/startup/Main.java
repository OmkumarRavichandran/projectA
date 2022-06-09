package com.chainsys.projectA.startup;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;
import com.chainsys.projectA.getbeans.TestClassPathXml;

import org.springframework.context.ApplicationContext;					// Parent
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child
public class Main {

	public static void main(String[] args) {
		TestClassPathXml.testBeanWithConstructor();
	}
}
