package com.bridgelab.spring.main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bridgelab.spring.model.Student;

public class Demo {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("com/bridgelab/spring/applicationContext/xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		   
	    Student student=(Student)factory.getBean("studentbean");  
	    student.displayInfo();  

	}

}
