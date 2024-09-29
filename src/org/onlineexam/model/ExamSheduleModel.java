package org.onlineexam.model;

import java.util.ArrayList;

public class ExamSheduleModel {

	private int id;
	private String name;
	private String date;
	private String startTime, endTime;
	private ArrayList questionBanck;
	
	public ExamSheduleModel()
	{
		
	}
	public ExamSheduleModel(int id,String name,String date,String startTime,String endTime)
	{
		this.id=id;
		this.name=name;
		this.date=date;
		this.startTime=startTime;
		this.endTime=endTime;
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ArrayList getQuestionBanck() {
		return questionBanck;
	}

	public void setQuestionBanck(ArrayList questionBanck) {
		this.questionBanck = questionBanck;
	}

}
