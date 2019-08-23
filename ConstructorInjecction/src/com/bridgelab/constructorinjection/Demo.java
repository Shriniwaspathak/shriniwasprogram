package com.bridgelab.constructorinjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Demo {
	public static void main(String args[]) {
		Resource rs = new ClassPathResource("com/bridgelab/constructorinjection/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(rs);

		Employee emp = (Employee) factory.getBean("e");
		emp.show();

	}

}
