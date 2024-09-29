package org.onlineexam.repository;

import java.util.ArrayList;

import org.onlineexam.model.Question;

public class QuestionRepository {

	static ArrayList al = new ArrayList();

	public int getId() {
		return al.size();
	}

	public boolean isAddQuestion(Question q) {
		boolean b = al.add(q);
		return b;
	}

	public ArrayList getQutionPaper() {
		return al;
	}
}
