package com.bridgelab.collectioninjection;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String name;
	private List<String>answer;
	public Question(int id, String name, List<String> answer) {
		super();
		this.id = id;
		this.name = name;
		this.answer = answer;
	}
	public void show() {
		System.out.println(id+"-"+name);
		System.out.println("answer is :-");
	Iterator<String>itr=answer.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
		
	}
	}

}
