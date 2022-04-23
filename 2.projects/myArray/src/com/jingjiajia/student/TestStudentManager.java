package com.jingjiajia.student;

import java.util.LinkedList;
import java.util.List;

public class TestStudentManager {

	public static void main(String[] args) {
	
		try{
			List<Student> list = new LinkedList<Student>();
			
			DaoStudent ds = new DaoStudent(list);
			list = ds.read();	
			
			ManagerStudent ms = new ManagerStudent(list);
			ViewStudent vs = new ViewStudent(ms);
			vs.show();
			
			ds.write();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
