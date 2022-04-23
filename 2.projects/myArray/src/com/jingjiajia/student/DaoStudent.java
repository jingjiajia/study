package com.jingjiajia.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DaoStudent {
	//����һ���������͵����ã�ͨ�����췽�����������ϴ���
	private List<Student> list;
	
	public DaoStudent(List<Student> list){
		this.list = list;
	}
	
	//�Զ��巽��ʵ�ֽ���������д�뵽�ļ���
	public void write() throws IOException{
		//1.����ObjectOutputStream���͵Ķ�����./student.txt�ļ�����
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("./student.txt"));
		//2.���������ϵ�ѧ����Ϣ��д�뵽�ļ���
		oos.writeObject(list);
		//System.out.println("д�����ݵ��ļ��ɹ���");
		//3.�ر��������ͷ��йص���Դ
		oos.close();
	}
	
	//�Զ��巽��ʵ�ֶ�ȡ�ļ��е�����ѧ����Ϣ
	@SuppressWarnings("unchecked")
	public List<Student> read() throws IOException, ClassNotFoundException{
		//��./student.txt�ļ�����ʱ������Ҫ��ȡ���������
		if(new File("./student.txt").exists()){
			//1.����ObjectInputStream���͵Ķ�����./student.txt�ļ�����
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("./student.txt"));
			//2.���ļ��е�����ѧ����Ϣ����ȡ����
			list = (List<Student>) ois.readObject();
			for(Student s : list){
				System.out.println(s);
			}
			//System.out.println("��ȡ�ļ��е����ݳɹ���");
			//3.�ر��������ͷ��йص���Դ
			ois.close();
		}
		return list;
	}
}
