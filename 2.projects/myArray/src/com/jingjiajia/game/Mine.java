package com.jingjiajia.game;

public class Mine {
	private boolean isMine;// �Ƿ��ǵ���
	private int otherMineCount;// ��Χ���׸���
	private int winCount;// Ӯ�ľ���
	private boolean showFalg = false;// �Ƿ���ʾ
	private boolean usedFalg = false;// �Ƿ��ô˵��жϹ���Χ����--���ڵݹ�����ж�

	public Mine() {
		super();
	}

	public Mine(boolean isMine, int otherMineCount, int winCount) {
		super();
		this.isMine = isMine;
		this.otherMineCount = otherMineCount;
		this.winCount = winCount;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public int getOtherMineCount() {
		return otherMineCount;
	}

	public void setOtherMineCount(int otherMineCount) {
		this.otherMineCount = otherMineCount;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public boolean isShowFalg() {
		return showFalg;
	}

	public void setShowFalg(boolean showFalg) {
		this.showFalg = showFalg;
	}

	public boolean isUsedFalg() {
		return usedFalg;
	}

	public void setUsedFalg(boolean usedFalg) {
		this.usedFalg = usedFalg;
	}

	@Override
	public String toString() {
		return "Mine [isMine=" + isMine + ", otherMineCount=" + otherMineCount + ", winCount=" + winCount
				+ ", showFalg=" + showFalg + ", usedFalg=" + usedFalg + "]";
	}

}
