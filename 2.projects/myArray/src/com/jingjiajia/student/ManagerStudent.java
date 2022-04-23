package com.jingjiajia.student;

import java.util.List;
import java.util.Scanner;

public class ManagerStudent {
	//����һ���������洢ѧ����Ϣ
	private List<Student> list;
	
	public ManagerStudent(List<Student> list){
		super();
		this.list = list;
	}
	
	//����ѧ����Ϣ��������
	public void addStudent() throws Exception{
		System.out.println("������Ҫ���ӵ�ѧ����Ϣ(ѧ��,����,����)��");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		//���ն��Ž����ַ�����֣�����Student������뼯����
		String[] ss = str.split(",");
		Student s = new Student(Integer.parseInt(ss[0]), ss[1], 
				Integer.parseInt(ss[2]));
		
		//�ж������ѧ����Ϣ�Ƿ���ڣ�����������������
		for(Student ts : list){
			if(ts.equals(s)){
				System.out.println("��ѧ���Ѿ����ڣ�����ʧ��");
				return;
			}
		}
		list.add(s);
		System.out.println("����ѧ����Ϣ�ɹ�");
	}
	
	//�Ӽ�����ɾ��ѧ����Ϣ
	public void delStudent(){
		//���Ҹ�ѧ����Ϣ�Ƿ���ڣ������������ɾ��ʧ��
		Student fs = findStudent();
		if(null == fs){
			System.out.println("��ѧ����Ϣ�����ڣ�ɾ��ʧ��");
			return;
		}
		//���������ɾ���ɹ�
		list.remove(fs);
		
	}
	
	//�޸�ѧ����Ϣ�Ӽ�����
	public void modifyStudent() throws Exception{
		//��ԭ����ѧ����Ϣ�Ӽ�����ɾ����
		delStudent();
		//�����µ�ѧ����Ϣ��������
		addStudent();
		
	}
	
	//����ѧ����Ϣ�Ӽ�����
	public Student findStudent(){
		System.out.println("�������ѧ����ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		//ʹ����ǿ��forѭ��ȥ����ѧ����Ϣ
		for(Student s : list){
			if(id == s.getId()){
				System.out.println(s);
				return s;
			}
		}
		//��Ϊ����ʧ�ܵĴ���ʽ
		return null;
	}
	
	//��ʾ����ѧ����Ϣ
	public void printStudent(){
		System.out.println("---------------------------------------------");
		for(Student s : list){
			System.out.println(s);
		}
		System.out.println("---------------------------------------------");
	}
}
