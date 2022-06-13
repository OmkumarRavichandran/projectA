package com.chainsys.springproject.startup;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClassPathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;
import com.chainsys.springproject.view.EmployeeSprings;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;					// Parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; // Child
public class Main {

	public static void main(String[] args) {

//		TestAnnotationConfig.testPhone();
//		TestClassPathXml.testAutoWireQualifier();
		employeeMenu();
	}
	public static void employeeMenu() {
		ConfigurableApplicationContext apcontext=new ClassPathXmlApplicationContext("Employee.xml");
		EmployeeSprings empspring = apcontext.getBean(EmployeeSprings.class);
		Scanner sc=new Scanner(System.in);
		empspring.setApcontext(apcontext);
		empspring.setSc(sc);
		System.out.println("1.) To add New employee in to table");
		System.out.println("2.) To Get all employee datails from table");
		System.out.println("3.) To Update employee details");
		System.out.println("4.) To Delete Employee details");
		int vCase=sc.nextInt();
		switch(vCase) {
		case 1:
			empspring.addNewEmployee();
			break;
		case 2:
			empspring.GetEmplyeeById();
			break;
		case 3:
			empspring.UpdateEmployee();
			break;
		case 4:
			empspring.DeleteEmployee();
			break;
		default:
			System.out.println("enter valid number");
		}
		apcontext.close();
		sc.close();
	}
	
}
