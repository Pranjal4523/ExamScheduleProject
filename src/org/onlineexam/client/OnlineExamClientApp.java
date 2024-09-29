package org.onlineexam.client;

import java.util.*;
import org.onlineexam.model.ExamSheduleModel;
import org.onlineexam.model.Question;
import org.onlineexam.model.StudentModel;
import org.onlineexam.service.QuestionService;
import org.onlineexam.service.ExamService;
import org.onlineexam.model.StudentModel;

public class OnlineExamClientApp {

	public static void main(String[] args) {

		QuestionService qservise = new QuestionService();
		ExamService es = new ExamService();
		ExamSheduleModel model = null;

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1 : Add new Question ");
			System.out.println("2 : View all Question ");
			System.out.println("3 : Create an exam ");
			System.out.println("4 : view question examwise ");
			System.out.println("5 : Attempt Exam by student");
			System.out.println("6 : Delete questions");

			System.out.println("Enter your choise :");
			int choise = sc.nextInt();
			switch (choise) {
			case 1:
				sc.nextLine();
				System.out.println("Enter the question");
				String qName = sc.nextLine();
				System.out.println("Enter the Option1");
				String op1 = sc.nextLine();
				System.out.println("Enter the Option2");
				String op2 = sc.nextLine();
				System.out.println("Enter the Option3");
				String op3 = sc.nextLine();
				System.out.println("Enter the Option4");
				String op4 = sc.nextLine();
				System.out.println("Enter the Ans");
				String ans = sc.nextLine();

				Question q = new Question(qName, op1, op2, op3, op4, ans);

				boolean b = qservise.isAddQuestion(q);

				if (b) {
					System.out.println("Question added succesfully....!");
				} else {
					System.out.println("Some Error....!");
				}
				break;
			case 2:
				ArrayList al = qservise.getQutionPaper();
				System.out.println("size of arraylist " + al.size());

				if (al != null) {
					Iterator i = al.iterator();
					while (i.hasNext()) {
						Object obj = i.next();

						Question que = (Question) obj;

						System.out.println(que.getId() + "\t" + que.getName() + "\t" + que.getOp1() + "\t"
								+ que.getOp2() + "\t" + que.getOp3() + "\t" + que.getOp4());

					}
				} else {
					System.out.println("NO Question available..!");
				}
				break;
			case 3:
				System.out.println("Enter the examid :");
				int eid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the examName :");
				String examName = sc.nextLine();
				System.out.println("Enter the Date :");
				String date = sc.nextLine();
				System.out.println("Enter the StartTime,EndTime :");
				String startTime = sc.nextLine();
				String endTime = sc.nextLine();

				ExamSheduleModel em = new ExamSheduleModel(eid, examName, date, startTime, endTime);

				b = es.sheduleExam(em);

				if(b) 
				{
					System.out.println("Exam sheduel successfully.....!");
				} else
					System.out.println("There is no question banck No exam sheduel..!");
				
				break;
			case 4:
				model = es.getExamShedule();
				if (model != null) {
					System.out.println(model.getId() + "\t" + model.getName() + "\t" + model.getDate() + "\t"
							+ model.getStartTime() + "\t" + model.getEndTime());
					al = model.getQuestionBanck();

					System.out.println("=============================================================================");
					for (Object obj : al) {
						Question que = (Question) obj;
						System.out.println(que.getId() + "\t" + que.getName() + "\t" + que.getOp1() + "\t"
								+ que.getOp2() + "\t" + que.getOp3() + "\t" + que.getOp4() + "\t" + que.getAns());

					}
				} else {
					System.out.println("There is no exam shedule...!");
				}
				break;
			case 5:

				StudentModel smodel = new StudentModel();
				System.out.println("Enter student id and Name :");
				int id = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				smodel.setId(id);
				smodel.setName(name);
				if (model != null) {
					smodel.setModel(model);
					al = model.getQuestionBanck();
					if (al.size() > 0) {
						int index = 0;
						do {
							Question que = (Question) al.get(index);
							System.out.println("Question is : " + que.getName());
							System.out.println("option1 :" + que.getOp1());
							System.out.println("option2 : " + que.getOp2());
							System.out.println("option3 : " + que.getOp3());
							System.out.println("option4 : " + que.getOp4());

							System.out.println("Enter your Answer :");
							ans = sc.nextLine();
							if (ans.equals(que.getAns())) {
								que.setSatus(true);
							}
							++index;

						} while (index != al.size());
						System.out.println("Print all Questions :");
						int count = 0;
						for (Object obj : al) {
							Question que = (Question) obj;
							System.out.println(que.getId() + "\t" + que.getName() + "\t" + que.getOp1() + "\t"
									+ que.getOp2() + "\t" + que.getOp3() + "\t" + que.getOp4() + "\t" + que.getAns()
									+ "\t" + que.isSatus());
							if (que.isSatus()) {
								count++;
							}
						}
						int wrongQuestion = al.size() - count;
						float percentage = ((((float)count / al.size())) * 100);
						System.out.println(" Hey "+ name +" your total percentage is = " + percentage);
						System.out.println("Total number of questions = " + al.size());
						System.out.println("Correct solve questions = " + count);
						System.out.println("wrong questions count = " + wrongQuestion);

					} else {
						System.out.println("wait for question paper..!");
					}
				} else
					System.out.println("There is no exam..!");

				break;

			default:
				break;
			}

		} while (true);

	}

}
