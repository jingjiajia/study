package com.jingjiajia.game;

import java.util.Scanner;

/**
 * 
 * ������<br/>
 * 1.����һ��int��ά����,�洢ֵ�ú���.0:δ����;1:player1;2:player2.<br/>
 * 
 * @author ʯ��ΰ
 *
 */
public class Five {

	public static void main(String[] args) {
		int arr[][] = new int[15][15];
		// ��ӡ����
		print(arr);
		// ��ҽ�������ı��.true:player1;false:player2.
		boolean playerShift = true;

		while (true) {// ��ʼ����
			// ʤ��������
			String winner = null;
			if (playerShift) {
				// player1����.
				winner = play(arr, 1);
				// player1�����,���ȡ��,�´���player2����
				playerShift = !playerShift;
			} else {
				// player2����.
				winner = play(arr, 2);
				// player2�����,���ȡ��,�´���player1����
				playerShift = !playerShift;
			}
			// ������Ӻ�ˢ������
			print(arr);
			if (winner != null) {
				System.out.println("���:" + winner + "ʤ��!!!");
				break;
			}
		}
	}
	/**
	 * ��ӡ����
	 * 
	 * @param arr
	 *            ���������Ϣ������ 0:δ����;1:player1-->��;2:player2-->��
	 */
	private static void print(int[][] arr) {
		System.out.print("   ");
		for (int i = 0; i < arr.length; i++) {
			// ��ӡ��ߵ��к�
			if (i < 9) {
				System.out.print(" " + (i + 1) + " ");
			} else {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			// ��ӡ��ߵ��к�
			if (i < 9) {
				System.out.print(" " + (i + 1) + "|");
			} else {
				System.out.print((i + 1) + "|");

			}
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {// δ���Ӵ�ӡ+
					System.out.print("-+-");
				} else if (arr[i][j] == 1) {// player1���Ӵ�ӡ��
					System.out.print("-��-");
				} else if (arr[i][j] == 2) {// player2���Ӵ�ӡ��
					System.out.print("-��-");
				}
			}
			System.out.println("-|");
		}
	}

	/**
	 * 
	 * @param arr
	 *            ������Ϣ
	 * @param playerVal
	 *            Ҫ����������Ϣ��ֵ
	 * @return ʤ���������
	 */
	private static String play(int[][] arr, int playerVal) {
		Scanner sc = new Scanner(System.in);
		String name = null;
		// �������̴���ֵ(1,2),�趨�������name��player1��player2
		if (playerVal == 1) {
			name = "player1--��";
		} else {
			name = "player2--��";
		}
		int x = -1;
		int y = -1;
		while (true) {
			System.out.println("�����" + name + "����.��������x��y,�ÿո����.");
			// ����ĺ�������-1��,��������.
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
//			����ֵ�Ƿ��ж�
			if (x<0||x>=15||y<0||y>=15) {
				System.out.println("��������겻��ȷ�����������룡");
				continue;// ���������Ĳ���,��ǰ�����������.
			}
			// �ж�����������Ƿ��Ѿ����������
			if (arr[x][y] != 0) {// �����Ѿ�����
				System.out.println("���λ���Ѿ���������.");
				continue;// ���������Ĳ���,��ǰ�����������.
			}
			// �ѵ�ǰ��ҵ�ֵ���뵽������Ϣ����
			arr[x][y] = playerVal;
			break;
		}

		boolean win = getWinner(arr, x, y, playerVal);
		// ��ǰ��һ�ʤ �����������
		if (win) {
			return name;
		} else {// ǰ���δ��ʤ����null
			return null;
		}

	}

	/**
	 * �����������Ϊ��׼,�жϺ���\��ֱ\���ϵ�����\���ϵ�����,4�������Ƿ����5��������ͬ������.����ʱ�жϻ�ʤ.
	 * 
	 * @param arr
	 *            ������Ϣ
	 * @param x
	 *            ��ǰ���Ӻ�����
	 * @param y
	 *            ��ǰ���Ӻ�����
	 * @param playerVal
	 *            ��ǰ��������д�ŵ�ֵ
	 * @return ��ǰ����Ƿ�Ӯ�����.��ʤ:true,δ��ʤ:false
	 */
	private static boolean getWinner(int[][] arr, int x, int y, int playerVal) {
		// �����ж�
		{
			int count = 0;
			// �ӵ�ǰ�����Ҳ�����ͬ������
			for (int i = y; i < arr.length; i++) {
				if (arr[x][i] == playerVal) {
					count++;
				} else {
					break;
				}

			}
			// �ӵ�ǰ�����������ͬ������,������һ���Ѿ��ѻ�׼�����ȥ��,��β���ȡֵ��׼��
			for (int i = y - 1; i >= 0; i--) {
				if (arr[x][i] == playerVal) {
					count++;
				} else {
					break;
				}
			}

			System.out.println("�����ĺ���----��ͬ��������:" + count);
			if (count == 5) {
				return true;
			}

		}
		// ��ֱ�����ж�
		{
			int count = 0;
			// �ӵ�ǰ�����²�����ͬ������
			for (int i = x; i < arr.length; i++) {
				if (arr[i][y] == playerVal) {
					count++;
				} else {
					break;
				}

			}
			// �ӵ�ǰ�����ϲ�����ͬ������,������һ���Ѿ��ѻ�׼�����ȥ��,��β���ȡֵ��׼��
			for (int i = x - 1; i >= 0; i--) {
				if (arr[i][y] == playerVal) {
					count++;
				} else {
					break;
				}
			}

			System.out.println("�����Ĵ�ֱ----��ͬ��������:" + count);
			if (count == 5) {
				return true;
			}

		}
		// ���ϵ�����
		{
			int count = 0;
			// �ӵ�ǰ�������²�����ͬ������
			int i = x;
			int j = y;
			for (; i < arr.length && j < arr.length;) {
				if (arr[i][j] == playerVal) {
					count++;
				} else {
					break;
				}
				i++;
				j++;

			}
			// �ӵ�ǰ�������ϲ�����ͬ������,������һ���Ѿ��ѻ�׼�����ȥ��,��β���ȡֵ��׼��
			i = x - 1;
			j = y - 1;
			for (; i >= 0 && j >= 0;) {
				if (arr[i][j] == playerVal) {
					count++;
				} else {
					break;
				}
				i--;
				j--;
			}

			System.out.println("����������/����----��ͬ��������:" + count);
			if (count == 5) {
				return true;
			}

		}
		// ���ϵ�����
		{
			int count = 0;
			// �ӵ�ǰ�������²�����ͬ������
			int i = x;
			int j = y;
			for (; i < arr.length && j >= 0;) {
				if (arr[i][j] == playerVal) {
					count++;
				} else {
					break;
				}
				i++;
				j--;
			}
			// �ӵ�ǰ�������ϲ�����ͬ������,������һ���Ѿ��ѻ�׼�����ȥ��,��β���ȡֵ��׼��
			i = x - 1;
			j = y + 1;
			for (; i >= 0 && j < arr.length;) {
				if (arr[i][j] == playerVal) {
					count++;
				} else {
					break;
				}
				i--;
				j++;
			}
			System.out.println("����������/����----��ͬ��������:" + count);
			if (count == 5) {
				return true;
			}
		}
		return false;
	}

}
