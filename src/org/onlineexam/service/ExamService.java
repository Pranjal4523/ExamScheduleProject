package org.onlineexam.service;

import org.onlineexam.model.ExamSheduleModel;
import org.onlineexam.repository.ExamRepository;

public class ExamService {

	ExamRepository er = new ExamRepository();

	public boolean sheduleExam(ExamSheduleModel em) {

		boolean b = er.sheduleExam(em);
		return b;
	}
	
	public ExamSheduleModel getExamShedule()
	{
		return er.getExamShedule();
	}

}
