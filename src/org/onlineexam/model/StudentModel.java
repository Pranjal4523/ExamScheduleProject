package org.onlineexam.model;

public class StudentModel {
	
	private int id;
	private String name;
	private ExamSheduleModel model;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExamSheduleModel getModel() {
		return model;
	}
	public void setModel(ExamSheduleModel model) {
		this.model = model;
	}
	

}
