package org.onlineexam.service;

import org.onlineexam.repository.QuestionRepository;

import java.util.ArrayList;

import org.onlineexam.model.Question;
public class QuestionService {

	QuestionRepository qRepo = new QuestionRepository();
	
    public boolean isAddQuestion(Question q)
	{
    	int qid = qRepo.getId();
    	
    	qid+=1;
    	q.setId(qid);
    	boolean b = qRepo. isAddQuestion(q);
    	return b;
	}
    
    public ArrayList getQutionPaper()
    {
    	ArrayList v = qRepo.getQutionPaper();
    	return v!=null?v:null;
    }
}
