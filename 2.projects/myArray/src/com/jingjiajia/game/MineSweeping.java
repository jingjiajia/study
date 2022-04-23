package com.jingjiajia.game;

import java.util.Scanner;

public class MineSweeping {
	private static Mine mine = null;
	private static int mineCount = 0;
	private static int findMineCount = 0;

	public static void main(String[] args) {
		mine = new Mine();
		Scanner sc = new Scanner(System.in);
		System.out.println("��ӭ����ɨ����Ϸ����ѡ����Ϸ�Ѷȣ�1���ͼ���2���м���3���߼�");
		int selNum = sc.nextInt();
		Mine arr[][] = null;
		a: while (true) {
			switch (selNum) {
			case 1:
				// ��������Ķ�ά����
				arr = new Mine[9][9];
				// ���õ��׸���10
				mineCount = 10;
				// �������10���ײ�������ڶ�ά������
				arr = addMine(arr);
				// ������Ϣ��ŵ�������
				arr = addMineInfo(arr);
				// ����
				draw(arr);
				// ɨ�׿�ʼ
				boolean outFalg = inXY(arr, sc);
				// ������Ϸ
				if (outFalg) {
					break a;
				} else {
					// ���¿�ʼ
					break;
				}
			case 2:
				// ��������Ķ�ά����
				arr = new Mine[16][16];

				// ���õ��׸���40
				mineCount = 40;
				// �������40���ײ�������ڶ�ά������
				arr = addMine(arr);
				// ������Ϣ��ŵ�������
				arr = addMineInfo(arr);
				draw(arr);
				// ɨ�׿�ʼ
				outFalg = inXY(arr, sc);
				// ������Ϸ
				if (outFalg) {
					break a;
				} else {
					// ���¿�ʼ
					break;
				}
			case 3:
				// ��������Ķ�ά����
				arr = new Mine[16][30];
				// ���õ��׸���99
				mineCount = 99;
				// �������99���ײ�������ڶ�ά������
				arr = addMine(arr);
				// ������Ϣ��ŵ�������
				arr = addMineInfo(arr);
				draw(arr);
				// ɨ�׿�ʼ
				outFalg = inXY(arr, sc);
				// ������Ϸ
				if (outFalg) {
					break a;
				} else {
					// ���¿�ʼ
					break;
				}
			}

		}

	}

	/**
	 * 
	 * @param mineCount
	 * @param nineArr����Ķ�ά����
	 * @return ������׺�Ķ�ά����
	 */
	private static Mine[][] addMine(Mine[][] nineArr) {
		for (int i = 0; i < nineArr.length; i++) {
			for (int j = 0; j < nineArr[0].length; j++) {
				nineArr[i][j] = new Mine(false, 0, 0);
			}
		}
		for (int i = 0; i < mineCount;) {
			int intRandom1 = (int) (nineArr.length * Math.random());
			int intRandom2 = (int) (nineArr[0].length * Math.random());
			// �жϵ�ǰλ���Ƿ��ǵ���
			if (!nineArr[intRandom1][intRandom2].isMine()) {
				nineArr[intRandom1][intRandom2].setMine(true);
				i++;
			}
		}
		return nineArr;
	}

	/**
	 * 
	 * @param nineArr��������
	 * @return ������Ϣ��Ӻ������
	 */
	private static Mine[][] addMineInfo(Mine[][] nineArr) {
		// ��Χ���׸���
		for (int i = 0; i < nineArr.length; i++) {
			for (int j = 0; j < nineArr[0].length; j++) {
				int count = 0;
				// �ж�����λ���Ƿ�Ϊ����
				if (i > 0 && j > 0) {
					if (nineArr[i - 1][j - 1].isMine()) {
						count++;
					}
				}
				// �ж�����λ���Ƿ�Ϊ����
				if (i > 0) {
					if (nineArr[i - 1][j].isMine()) {
						count++;
					}
				}
				// �ж�����λ���Ƿ�Ϊ����
				if (i > 0 && j < nineArr.length - 1) {
					if (nineArr[i - 1][j + 1].isMine()) {
						count++;
					}
				}
				// �ж����λ���Ƿ�Ϊ����
				if (j > 0) {
					if (nineArr[i][j - 1].isMine()) {
						count++;
					}
				}
				// �ж��ұ�λ���Ƿ�Ϊ����
				if (j < nineArr.length - 1) {
					if (nineArr[i][j + 1].isMine()) {
						count++;
					}
				}
				// �ж�����λ���Ƿ�Ϊ����
				if (i < nineArr.length - 1 && j > 0) {
					if (nineArr[i + 1][j - 1].isMine()) {
						count++;
					}
				}
				// �ж�����λ���Ƿ�Ϊ����
				if (i < nineArr.length - 1) {
					if (nineArr[i + 1][j].isMine()) {
						count++;
					}
				}
				// �ж�����λ���Ƿ�Ϊ����
				if (i < nineArr.length - 1 && j < nineArr.length - 1) {
					if (nineArr[i + 1][j + 1].isMine()) {
						count++;
					}
				}
				nineArr[i][j].setOtherMineCount(count);
			}
		}
		return nineArr;
	}

	/**
	 * ��ӡ������Ϣ
	 * 
	 * @param arr
	 *            ������Ϣ
	 */
	private static void draw(Mine[][] arr) {
		System.out.print("   ");
		// ��ӡ����ı��
		for (int i = 0; i < arr[0].length; i++) {
			if (i < 9) {
				System.out.print(" " + (i + 1) + " ");
			} else {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			// ��ӡ��������
			if (i < 9) {
				System.out.print(" " + (i + 1));
			} else {
				System.out.print(i + 1);
			}
			System.out.print("|");
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j].isShowFalg()&&(!arr[i][j].isMine())) {
					System.out.print("-" + arr[i][j].getOtherMineCount() + "-");
				} else if (arr[i][j].isMine() && arr[i][j].isShowFalg()) {
					System.out.print("-" + "��" + "-");
				} else {
					System.out.print("-��-");
				}
			}
			System.out.print("|");
			System.out.println();
		}
	}

	/**
	 * 
	 * @param sc����̨������
	 * @param nineArr������Ϣ
	 * @return true���˳���Ϸ��false���¿�ʼ��Ϸ��������Ϸ
	 */
	private static boolean inXY(Mine[][] arr, Scanner sc) {
		while (true) {
			System.out.println("ɨ�׿�ʼ���������׵�����������M/m+������+������,�ո����������-1�˳���Ϸ");
			System.out.println("������Ҫ�������������P/p+������+������,�ո����������-1�˳���Ϸ");
			String inSelect = sc.next();
			int xVal = sc.nextInt() - 1;
			// ������Ƿ����
			if (xVal < 0 || xVal >= arr.length) {
				System.out.println("������ĺ�����Ƿ������������롣");
				continue;
			}
			if (xVal == -1) {
				return true;
			}
			int yVal = sc.nextInt() - 1;
			// ������Ƿ����
			if (yVal < 0 || yVal >= arr[0].length) {
				System.out.println("�������������Ƿ������������롣");
				continue;
			}
			if (yVal == -1) {
				return true;
			}
			// �ж��Ƿ�Ӯ����Ϸ
			if (inSelect.equalsIgnoreCase("M")) {
				System.out.println(arr[xVal][yVal].toString());
				if (checkWine(arr, xVal, yVal)) {
					findMineCount++;
					arr[xVal][yVal].setShowFalg(true);
					System.out.println("������ȷ�����ҵ����׸�����" + findMineCount + "\t���е��ף�" + mineCount + "�����ٽ�������");
				} else {
					mine.setWinCount(mine.getWinCount() - 1);
					System.out.println("����������Ѿ����ˣ����������¿�ʼ��Ϸ����Y/y���˳���Ϸ����������");
					if (sc.next().equalsIgnoreCase("")) {
						return false;
					} else {
						return true;
					}
				}
			} else if (inSelect.equalsIgnoreCase("P")) {
				if (checkWine(arr, xVal, yVal)) {
					mine.setWinCount(mine.getWinCount() - 1);
					System.out.println("�ȵ����ף����Ѿ����ˣ����������¿�ʼ��Ϸ����Y/y���˳���Ϸ����������");
					if (sc.next().equalsIgnoreCase("")) {
						return false;
					} else {
						return true;
					}
				}
				// �ж�������Ϣ,����
				arr = check(arr, xVal, yVal);
			}
			if (checkWin()) {
				System.out.println("���Ѿ�Ӯ����Ϸ�����ҵ����׸�����" + findMineCount + "\t���е��ף�" + mineCount + "����");
				System.out.println("����������Ѿ����ˣ����������¿�ʼ��Ϸ����Y/y���˳���Ϸ����������");
				if (sc.next().equalsIgnoreCase("")) {
					return false;
				} else {
					return true;
				}
			}
			draw(arr);

		}

	}

	/**
	 * 
	 * @param arr
	 *            ����������Ϣ
	 * @param xVal
	 *            ����ĺ�����
	 * @param yVal
	 *            �����������
	 * @return null:�ȵ����ף�arr������������Ϣ���
	 */
	private static Mine[][] check(Mine[][] arr, int xVal, int yVal) {
		System.out.println(xVal + "\t" + yVal);
		// ��ǰ������Ϊ��ʾ
		arr[xVal][yVal].setShowFalg(true);
		// �жϵ�ǰ���Ƿ�Ϊ0��δ0ʱ��ʾ�ܱߵķ���λ�õ���Ϣ
		if (arr[xVal][yVal].getOtherMineCount() == 0) {
			// �ѵ�ǰ���Ƿ��Ѿ��жϱ������Ϊtrue
			arr[xVal][yVal].setUsedFalg(true);
			// �ж������Ƿ����
			if (xVal >= 1 && yVal >= 1) {
				// ��������Ϊ��ʾ
				arr[xVal - 1][yVal - 1].setShowFalg(true);
				// �ж���һ�����Ƿ��Ѿ������ж�
				if (!arr[xVal - 1][yVal - 1].isUsedFalg()) {
					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal - 1][yVal - 1].getOtherMineCount() == 0) {
						check(arr, xVal - 1, yVal - 1);
					}

				}
			}

			// �ж������Ƿ����
			if (xVal >= 1) {
				// ��������Ϊ��ʾ
				arr[xVal - 1][yVal].setShowFalg(true);
				// �ж���һ�����Ƿ��Ѿ������ж�
				if (!arr[xVal - 1][yVal].isUsedFalg()) {
					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal - 1][yVal].getOtherMineCount() == 0) {
						check(arr, xVal - 1, yVal);
					}

				}

			}
			// �ж������Ƿ����
			if (xVal >= 1 && yVal < arr[0].length - 1) {
				// ��������Ϊ��ʾ
				arr[xVal - 1][yVal + 1].setShowFalg(true);
				// �ж���һ�����Ƿ��Ѿ������ж�
				if (!arr[xVal - 1][yVal + 1].isUsedFalg()) {

					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal - 1][yVal + 1].getOtherMineCount() == 0) {
						check(arr, xVal - 1, yVal + 1);
					}
				}

			}
			// �ж�����Ƿ����
			if (yVal >= 1) {
				// �������Ϊ��ʾ
				arr[xVal][yVal - 1].setShowFalg(true);
				if (!arr[xVal][yVal - 1].isUsedFalg()) {
					// �ж�����Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal][yVal - 1].getOtherMineCount() == 0) {
						check(arr, xVal, yVal - 1);
					}

				}
			}
			// �ж��ұ��Ƿ����
			if (yVal < arr[0].length - 1) {
				// �ұ�����Ϊ��ʾ
				arr[xVal][yVal + 1].setShowFalg(true);
				if (!arr[xVal][yVal + 1].isUsedFalg()) {

					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal][yVal + 1].getOtherMineCount() == 0) {
						check(arr, xVal, yVal + 1);
					}
				}
			}
			// �ж������Ƿ����
			if (xVal < arr.length - 1 && yVal >= 1) {
				// ��ǰ��������Ϊ��ʾ
				arr[xVal + 1][yVal - 1].setShowFalg(true);
				if (!arr[xVal + 1][yVal - 1].isUsedFalg()) {
					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal + 1][yVal - 1].getOtherMineCount() == 0) {
						check(arr, xVal + 1, yVal - 1);
					}
				}
			}
			// �ж������Ƿ����
			if (xVal < arr.length - 1) {
				// ��ǰ��������Ϊ��ʾ
				arr[xVal + 1][yVal].setShowFalg(true);
				if (!arr[xVal + 1][yVal].isUsedFalg()) {

					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal + 1][yVal].getOtherMineCount() == 0) {
						check(arr, xVal + 1, yVal);
					}
				}
			}
			// �ж������Ƿ����
			if (xVal < arr.length - 1 && yVal < arr[0].length - 1) {
				// ��ǰ��������Ϊ��ʾ
				arr[xVal + 1][yVal + 1].setShowFalg(true);
				if (!arr[xVal + 1][yVal].isUsedFalg()) {
					// �ж������Ƿ�Ϊ0�������0�����ж���Χ����������Ϣ
					if (arr[xVal + 1][yVal + 1].getOtherMineCount() == 0) {
						check(arr, xVal + 1, yVal + 1);
					}
				}

			}
		}
		
		return arr;
	}

	/**
	 * 
	 * @param arr��������Ϣ
	 * @param xVal������ĺ�����
	 * @param yVal�������������
	 * @return true���ȵ����ף�false�����ǵ���
	 */
	private static boolean checkWine(Mine[][] arr, int xVal, int yVal) {
		if (arr[xVal][yVal].isMine()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return true��Ӯ����Ϸ��false��ûӮ
	 */
	private static boolean checkWin() {
		if (findMineCount == mineCount) {
			// ʤ��+1
			mine.setWinCount(mine.getWinCount() + 1);
			return true;
		}
		return false;
	}

}
