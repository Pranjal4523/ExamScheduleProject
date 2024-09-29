package org.onlineexam.repository;

import java.util.ArrayList;

import org.onlineexam.model.ExamSheduleModel;


public class ExamRepository {

	static QuestionRepository qr = new QuestionRepository();
	
	ExamSheduleModel em=null;
	
	public boolean sheduleExam(ExamSheduleModel em) {
		
		this.em=em;
		ArrayList al = qr.getQutionPaper();
		if (al.size() > 0) {
			 em.setQuestionBanck(al);
			return true;
		} else
			return false;
	}
	
	public ExamSheduleModel getExamShedule()
	{
		return em!=null?em:null;
	}

}
